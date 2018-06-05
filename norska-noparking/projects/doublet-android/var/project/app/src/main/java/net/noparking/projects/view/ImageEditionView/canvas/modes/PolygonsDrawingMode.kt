package net.noparking.projects.view.ImageEditionView.canvas.modes

import android.arch.lifecycle.Observer
import android.content.Context
import android.graphics.*
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import net.noparking.projects.R
import net.noparking.projects.database.line.Line
import net.noparking.projects.database.line.LineAsyncInsert
import net.noparking.projects.database.line.LinesCollector
import net.noparking.projects.database.polygon.*
import net.noparking.projects.utl.Position
import net.noparking.projects.view.ImageEditionView.canvas.CanvasView
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.PolygonRedimensionData

class PolygonsDrawingMode(internal val context: Context, internal val image_id: Long, internal val parent_activity: AppCompatActivity, internal val parent_view: CanvasView) {
	private val _polygons: MutableList<Polygon> = mutableListOf()
	private var _id_count = 1
	private lateinit var _current_polygon: Polygon

	private var _redimensionning_polygon: PolygonRedimensionData? = null

	private val _working_paint: Paint = Paint()
	private val _circle_paint: Paint = Paint()
	private val _clear_mode_fill_paint: Paint = Paint()
	private val _clear_mode_border_paint: Paint = Paint()

	private var _redimensionning_enabled = true
	var clear_mode = false

	val _polygons_collector = PolygonsCollector().init(context)
	val _lines_collector = LinesCollector().init(context)

	init {
		initPaint()
	}

	private fun initPaint() {
		_working_paint.isAntiAlias = true
		_working_paint.color = Color.WHITE
		_working_paint.style = Paint.Style.STROKE
		_working_paint.strokeJoin = Paint.Join.ROUND
		_working_paint.strokeWidth = 8f

		_circle_paint.isAntiAlias = true
		_circle_paint.color = Color.RED
		_circle_paint.style = Paint.Style.STROKE
		_circle_paint.strokeJoin = Paint.Join.ROUND
		_circle_paint.strokeWidth = 5f

		_clear_mode_fill_paint.isAntiAlias = true
		_clear_mode_fill_paint.color = Color.GRAY
		_clear_mode_fill_paint.style = Paint.Style.FILL_AND_STROKE
		_clear_mode_fill_paint.strokeJoin = Paint.Join.ROUND
		_clear_mode_fill_paint.strokeWidth = 8f
		_clear_mode_fill_paint.setARGB(100, 200, 200, 200)


		_clear_mode_border_paint.isAntiAlias = true
		_clear_mode_border_paint.color = Color.GRAY
		_clear_mode_border_paint.style = Paint.Style.FILL_AND_STROKE
		_clear_mode_border_paint.strokeJoin = Paint.Join.ROUND
		_clear_mode_border_paint.strokeWidth = 8f
		_clear_mode_border_paint.setARGB(255, 200, 200, 200)

	}

	fun getPolygons(): MutableList<Polygon> {
		return _polygons
	}

	fun clear() {
		_polygons.clear()
		addNewEmptyPolygon()
	}

	fun enableRedimensionning(v: Boolean) {
		_redimensionning_enabled = v
	}

	private fun addNewEmptyPolygon() {
		_polygons.add(Polygon())
		_current_polygon = _polygons[_polygons.size - 1]
		_current_polygon.id = _id_count
		_id_count++
	}

	fun onDraw(canvas: Canvas) {
		_polygons.forEach {
			if (it.status == Polygon.CLOSED || it.status == Polygon.REDIMENSIONNING_CLOSED) {
				canvas.drawPath(it.global_path, when (clear_mode) {
					true -> _clear_mode_fill_paint
					else -> it.average_fill_paint
				})
			}

			val sides_end = when (it.drawing_new_line) {
				true -> it.sides.size - 2
				false -> it.sides.size - 1
			}
			for (sides_idx in 0..sides_end) {
				canvas.drawPath(it.sides[sides_idx].path, when (clear_mode) {
					true -> _clear_mode_border_paint
					else -> it.sides[sides_idx].paint
				})
			}

			if (!clear_mode) {
				if (_redimensionning_enabled) {
					for (sides_idx in 0..sides_end) {
						canvas.drawCircle(it.sides[sides_idx].from.x, it.sides[sides_idx].from.y, REDIMENSIONNING_CIRCLE_TOLERANCE, _circle_paint)
					}
					if (it.sides.isNotEmpty()) {
						canvas.drawCircle(it.sides[it.sides.size - 1].to.x, it.sides[it.sides.size - 1].to.y, REDIMENSIONNING_CIRCLE_TOLERANCE, _circle_paint)
					}
				}

				if (_current_polygon.sides.size > 0 && _current_polygon.drawing_new_line && _redimensionning_polygon == null) {
					_current_polygon.current_side.path.reset()
					_current_polygon.current_side.path.moveTo(_current_polygon.current_side.from.x, _current_polygon.current_side.from.y)
					_current_polygon.current_side.path.lineTo(_current_polygon.current_side.to.x, _current_polygon.current_side.to.y)
					canvas.drawPath(_current_polygon.current_side.path, _working_paint)
				}
			}
		}
	}

	fun downTouch(x: Float, y: Float, color: Int = Color.WHITE) {
		if (clear_mode) {
			downTouchClearMode(x, y)
			return
		}

		_redimensionning_polygon = getTouchedPolygon(x, y)
		if (_redimensionning_polygon != null) {
			_redimensionning_polygon?.updatePolygon(x, y)
		} else {
			_current_polygon.drawing_new_line = true
			_current_polygon.addNewEmptySide()

			_current_polygon.current_side.init(color)
			_current_polygon.current_side.path.reset()

			_current_polygon.current_side.from = determineNewSideFrom(x, y)

			_current_polygon.current_side.to = Position(x, y)
		}
	}

	private fun determineNewSideFrom(x: Float, y: Float): Position {
		if (_current_polygon.sides.size == 1) {
			return Position(x, y)
		} else {
			return _current_polygon.getLastSavedSide().to
		}
	}

	fun moveTouch(x: Float, y: Float) {
		if (clear_mode) {
			return
		}
		if (_redimensionning_polygon != null) {
			_redimensionning_polygon?.updatePolygon(x, y)
		} else {
			if (_current_polygon.current_side.from.isEmpty()) {
				_current_polygon.current_side.from = Position(x, y)
			}

			val position_to_close = _current_polygon.getOriginPosition()

			if (_current_polygon.sides.size > 1 && position_to_close.isCloseFrom(Position(x, y), TOLERANCE)) {
				_current_polygon.current_side.to.x = position_to_close.x
				_current_polygon.current_side.to.y = position_to_close.y
				_current_polygon.status = Polygon.CLOSING_PROPOSITION
			} else {
				_current_polygon.current_side.to = Position(x, y)
				_current_polygon.status = Polygon.IN_PROGRESS
			}
		}
	}

	fun upTouch(x: Float, y: Float, color: Int = Color.WHITE) {
		if (clear_mode) {
			return
		}

		if (_redimensionning_polygon != null) {
			if (_current_polygon.status == Polygon.REDIMENSIONNING_CLOSED) {
				_redimensionning_polygon?.close()
			}
			_redimensionning_polygon?.resetStatus()
		}

		if ((_redimensionning_polygon != null && _current_polygon.status == Polygon.REDIMENSIONNING) ||
				_current_polygon.sides.size > 0) {
			_current_polygon.drawing_new_line = false
			_current_polygon.current_side.paint.color = color
			_current_polygon.current_side.update()
			if (_current_polygon.status == Polygon.CLOSING_PROPOSITION ||
					(_redimensionning_polygon != null && _redimensionning_polygon?.closing_proposition == true)) {
				_current_polygon.close()
				addNewEmptyPolygon()
			}
			_redimensionning_polygon = null
		}
	}

	fun getTouchedPolygon(x: Float, y: Float): PolygonRedimensionData? {
		var polygon_id = 0
		var side_id: Int

		if (_redimensionning_enabled == false) {
			return null
		}
		_polygons.forEach {
			side_id = 0
			it.sides.forEach {
				if (it.from.isCloseFrom(Position(x, y), REDIMENSIONNING_CIRCLE_TOLERANCE)) {
					_polygons[polygon_id].status = when (_polygons[polygon_id].status) {
						Polygon.CLOSED -> Polygon.REDIMENSIONNING_CLOSED
						else -> Polygon.REDIMENSIONNING
					}
					return PolygonRedimensionData(_polygons, polygon_id, side_id, true)
				}
				if (it.to.isCloseFrom(Position(x, y), REDIMENSIONNING_CIRCLE_TOLERANCE)) {
					_polygons[polygon_id].status = when (_polygons[polygon_id].status) {
						Polygon.CLOSED -> Polygon.REDIMENSIONNING_CLOSED
						else -> Polygon.REDIMENSIONNING
					}
					return PolygonRedimensionData(_polygons, polygon_id, side_id, false)
				}
				side_id++
			}
			polygon_id++
		}
		return null
	}

	fun saveAndExecute(f: () -> Unit) {
		save(f)
		_polygons_collector.stop()
		_lines_collector.stop()
	}

	private fun save(f: () -> Unit) {
		val list:  MutableList<Polygon> = mutableListOf()
		for (i in 0.._polygons.size - 1) {
			if (_polygons[i].status == Polygon.CLOSED) {
				list.add(_polygons[i])
			}
		}

		PolygonAsyncDelete().init(context).afterQuery {
			for (idx_polygons in 0..list.size - 1) {
				val polygon = list[idx_polygons]
				val to_save = net.noparking.projects.database.polygon.Polygon()
				to_save.closed = true
				to_save.image_id = image_id
				if (polygon.sides.isNotEmpty()) {
					Log.e("INSERTING NEW ITEM", "INSERTING NEW ITEM")
					PolygonAsyncInsert().init(context).afterQuery {
						polygon.db_id = it!!
						Log.e("POLYGON " + it.toString(), ": image_id: " + to_save.image_id.toString())
						for (idx_sides in 0..polygon.sides.size - 1) {
							processLineInDatabase(polygon.sides[idx_sides], polygon,
									idx_sides == polygon.sides.size - 1 && idx_polygons == list.size - 1, f)
						}
					}.execute(to_save)
				}
			}
		}.deleteByImageId(image_id).execute()
	}

	private fun processLineInDatabase(side: net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line,
									  polygon: Polygon,
									  last: Boolean,
									  f: () -> Unit) {
		val line = Line()
		if (side.db_id != 0.toLong()) {
			line.id = side.db_id
		}
		line.from_x = side.from.x
		line.from_y = side.from.y
		line.to_x = side.to.x
		line.to_y = side.to.y
		line.color = side.paint.color
		line.polygon_id = polygon.db_id

		LineAsyncInsert().init(context).afterQuery {
			Log.e("INSERTING LINE " + it.toString(), "INSERTING (polygon_id: " + line.polygon_id.toString() + ")")
			if (last) {
				f()
			}
		}.execute(line)
	}

	fun initAndExecute(f: () -> Unit) {
		retrieveFromDatabase(f)
	}

	private fun retrieveFromDatabase(f: () -> Unit) {
		_polygons_collector.init(context).getByImageId(image_id).observe(parent_activity, Observer {
			_polygons.clear()
			if (it == null || it.size == 0) {
				Log.e("POLYGONS", "nothing found, creating empty")
				addNewEmptyPolygon()
			} else {
				val count_end = it.size - 1

				Log.e("POLYGONS", "found " + it.size.toString() + " polygons")

				for (i in 0..count_end) {
					val polygon = it[i]

					Log.e("POLYGON " + polygon.id.toString(), "image_id: " + polygon.image_id.toString() + ":")

					_lines_collector.getByPolygonId(polygon.id!!).observe(parent_activity, Observer {
						Log.e("POLYGON " + polygon.id.toString(), "found " + it!!.size.toString() + " sides:")
						if (it!!.isNotEmpty()) {
							Log.e("POLYGON " + polygon.id.toString(), "creating new polygon (current count: " + _polygons.size.toString() + ")")
							addNewEmptyPolygon()
							_current_polygon.db_id = polygon.id!!
						}

						it.forEach {
							Log.e("SIDE " + it.id.toString(), "from [" + it.from_x.toString() + ", " + it.from_y.toString() + "] to [" + it.to_x.toString() + ", " + it.to_y.toString() + "]")
							_current_polygon.addNewEmptySide()
							_current_polygon.current_side.db_id = it.id!!
							_current_polygon.current_side.init(it.color)
							_current_polygon.current_side.from = Position(it.from_x, it.from_y)
							_current_polygon.current_side.to = Position(it.to_x, it.to_y)
							_current_polygon.current_side.update()
						}
						if (polygon.closed) {
							Log.e("POLYGON " + polygon.id.toString(), "CLOSING")
							_current_polygon.close()
						}

						if (i == count_end) {
							f()
							addNewEmptyPolygon()
						}
					})
				}
			}
		})
	}

	fun downTouchClearMode(x: Float, y: Float) {
		if (_polygons.size > 1) {
			_polygons.forEach {
				val bounds = RectF()
				it.global_path.computeBounds(bounds, true)

				val r = Region()
				r.setPath(it.global_path, Region(bounds.left.toInt(), bounds.top.toInt(), bounds.right.toInt(), bounds.bottom.toInt()))
				if (r.contains(x.toInt(), y.toInt())) {
					AlertDialog.Builder(parent_activity)
							.setTitle(parent_activity.getString(R.string.confirm_the_deletion))
							.setPositiveButton(parent_activity.getString(R.string.confirm), { _, _ ->
								_polygons.remove(it)
								parent_view.invalidate()
							})
							.setNegativeButton(parent_activity.getString(R.string.cancel), { _, _ -> })
							.show()
				}
			}
		}
	}

	companion object {
		val TOLERANCE = 100f
		val REDIMENSIONNING_CIRCLE_TOLERANCE = 60f
	}
}