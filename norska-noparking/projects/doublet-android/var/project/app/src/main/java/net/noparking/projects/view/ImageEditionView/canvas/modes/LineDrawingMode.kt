package net.noparking.projects.view.ImageEditionView.canvas.modes

import android.arch.lifecycle.Observer
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.Size
import net.noparking.projects.R
import net.noparking.projects.database.line.LineAsyncDelete
import net.noparking.projects.database.line.LineAsyncInsert
import net.noparking.projects.database.line.LinesCollector
import net.noparking.projects.utl.Position
import net.noparking.projects.utl.SizeRatio
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.DrawingModes
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineDrawer

class LineDrawingMode(internal val activity: AppCompatActivity, internal val image_id: Long) {
	private val _lines: MutableList<Line> = mutableListOf()
	private var _current_line: MutableMap<Int, Line?> = mutableMapOf()
	private var _current_moving_point: MutableMap<Int, Position?> = mutableMapOf()
	private var _current_moving_line: MutableMap<Int, Line?> = mutableMapOf()
	private var _size_ratio: SizeRatio? = null
	var current_color: Int = Color.TRANSPARENT
	var mode = DrawingModes.MODE_NONE
	private val _drawer = LineDrawer()

	private val _lines_annotations: LineAnnotationMode = LineAnnotationMode(activity, _lines, image_id)

	fun init(_mode: Int) {
		_lines_annotations.init()
		mode = _mode

		_current_line[DrawingModes.MODE_LINE_COLOR_PICKING] = null
		_current_line[DrawingModes.MODE_LINE_DRAWING] = null
		_current_line[DrawingModes.MODE_LINE_DELETION] = null
		_current_moving_point[DrawingModes.MODE_LINE_COLOR_PICKING] = null
		_current_moving_point[DrawingModes.MODE_LINE_DRAWING] = null
		_current_moving_point[DrawingModes.MODE_LINE_DELETION] = null
		_current_moving_line[DrawingModes.MODE_LINE_COLOR_PICKING] = null
		_current_moving_line[DrawingModes.MODE_LINE_DRAWING] = null
		_current_moving_line[DrawingModes.MODE_LINE_DELETION] = null
		retrieveFromDatabase()
	}

	fun onDraw(canvas: Canvas) {
		if (_size_ratio != null) {
			_lines.forEach { line ->
				_drawer.draw(canvas, line, mode)
			}
			_lines_annotations.onDraw(canvas)
		}
	}

	fun downTouch(x: Float, y: Float) {
		when (mode) {
			DrawingModes.MODE_LINE_DRAWING -> {
				if (mode == DrawingModes.MODE_LINE_DRAWING) {
					_current_moving_point[mode] = findClosestPoint(x, y)
					if (_current_moving_point[mode] != null) {
						return
					}
					_current_moving_line[mode] = findClosestLine(x, y)
					if (_current_moving_line[mode] != null) {
						return
					}
					if (_current_line[mode] == null) {
						createNewLine()
						_current_line[mode]!!.setOriginPoint(x, y)
						_current_line[mode]!!.setEndPoint(x, y)
					}
				}
			}
			DrawingModes.MODE_LINE_COLOR_PICKING -> {
				_current_line[mode] = findClosestLine(x, y)
				if (_current_line[mode] != null) {
					_current_line[mode]!!.paint.color = current_color
					_current_line[mode] = null
				}
			}
			DrawingModes.MODE_LINE_DELETION -> {
				_current_line[mode] = findClosestLine(x, y)
				if (_current_line[mode] != null) {
					if (_current_line[DrawingModes.MODE_LINE_DRAWING] == _current_line[mode]) {
						_current_line[DrawingModes.MODE_LINE_DRAWING] = null
					}
					AlertDialog.Builder(activity)
							.setTitle(activity.getString(R.string.confirm_the_deletion))
							.setPositiveButton(activity.getString(R.string.confirm), { _, _ ->
								removeCurrentLine()
							})
							.setNegativeButton(activity.getString(R.string.cancel), { _, _ -> })
							.show()
				}
			}
			DrawingModes.MODE_LINE_ANNOTATION -> {
				_lines_annotations.downTouch(x, y)
			}
		}
	}

	fun removeCurrentLine() {
		if (mode == DrawingModes.MODE_LINE_DELETION) {
			_lines_annotations.removeAnnotationByLine(_current_line[mode])
			_lines.remove(_current_line[mode])
			_current_line[mode] = null
		}
	}

	fun moveTouch(x: Float, y: Float) {
		when (mode) {
			DrawingModes.MODE_LINE_DRAWING -> {
				if (_current_moving_point[mode] != null) {
					_current_moving_point[mode]!!.set(x, y)
					return
				}
				if (_current_moving_line[mode] != null) {
					_current_moving_line[mode]!!.translate(x, y)
					return
				}

				if (_current_line[mode] != null) {
					_current_line[mode]!!.setEndPoint(x, y)
				}
			}
			DrawingModes.MODE_LINE_COLOR_PICKING -> {}
			DrawingModes.MODE_LINE_DELETION -> {}
			DrawingModes.MODE_LINE_ANNOTATION -> {
				_lines_annotations.moveTouch(x, y)
			}
		}
	}

	fun upTouch(x: Float, y: Float) {
		when (mode) {
			DrawingModes.MODE_LINE_DRAWING -> {
				_current_moving_point[mode] = null
				_current_line[mode] = null

				if (_current_moving_line[mode] != null) {
					_current_moving_line[mode]!!.endTranslation()
				}
				_current_moving_line[mode] = null
			}
			DrawingModes.MODE_LINE_DELETION -> {}
			DrawingModes.MODE_LINE_COLOR_PICKING -> {}
			DrawingModes.MODE_LINE_ANNOTATION -> {
				_lines_annotations.upTouch(x, y)
			}
		}
	}

	fun save() {
		LineAsyncDelete().init(activity.baseContext).deleteByImageId(image_id).afterQuery {
			for (i in 0 until _lines.size) {
				if (_size_ratio != null) {
					Log.e("RESIZING UP", "from " + _lines[i].from.x.toString() + ", " + _lines[i].from.y.toString() + " - " + _lines[i].to.x.toString() + ", " + _lines[i].to.y.toString())
					_lines[i].resizeUp(_size_ratio!!)
					Log.e("RESIZING UP", "to " + _lines[i].from.x.toString() + ", " + _lines[i].from.y.toString() + " - " + _lines[i].to.x.toString() + ", " + _lines[i].to.y.toString())
				}
				_lines[i].toData(image_id)
				LineAsyncInsert().init(activity.baseContext).afterQuery { id ->
					_lines[i].data.id = id
					if (i == _lines.size - 1) {
						_lines_annotations.save()
					}
				}.execute(_lines[i].data)
			}
		}.execute()
	}

	fun retrieveFromDatabase() {
		LinesCollector().init(activity.baseContext).getByImageId(image_id).observe(activity, Observer { lines ->
			if (lines != null && lines.size != 0) {
				for (i in 0 until lines.size) {
					createNewLine()
					_current_line[DrawingModes.MODE_LINE_DRAWING]!!.fromData(lines[i])
					if (_size_ratio != null) {
						Log.e("RESIZING DOWN", "from " + _lines[i].from.x.toString() + ", " + _lines[i].from.y.toString() + " - " + _lines[i].to.x.toString() + ", " + _lines[i].to.y.toString())
						_current_line[DrawingModes.MODE_LINE_DRAWING]!!.resizeDown(_size_ratio!!)
						Log.e("RESIZING DOWN", "to " + _lines[i].from.x.toString() + ", " + _lines[i].from.y.toString() + " - " + _lines[i].to.x.toString() + ", " + _lines[i].to.y.toString())
					}
					if (i == lines.size - 1) {
						_lines_annotations.retrieveFromDatabase()
					}
				}
			}
		})
		_current_line[DrawingModes.MODE_LINE_DRAWING] = null
	}

	fun createNewLine() {
		if (mode == DrawingModes.MODE_LINE_DRAWING) {
			_lines.add(Line())
			_current_line[mode] = _lines[_lines.size - 1]
			_current_line[mode]!!.paint.color = current_color
		}
	}

	fun findClosestPoint(x: Float, y: Float): Position? {
		_lines.forEach { line ->
			if (line.from.isCloseFrom(x, y, RESIZING_CLICK_TOLERANCE)) {
				return line.from
			}
			if (line.to.isCloseFrom(x, y, RESIZING_CLICK_TOLERANCE)) {
				return line.to
			}
		}
		return null
	}

	fun findClosestLine(x: Float, y: Float): Line? {
		_lines.forEach { line ->
			if (line.isCloseFrom(x, y, COLORIZATION_CLICK_TOLERANCE)) {
				return line
			}
		}
		return null
	}

	fun updateSizeRatio(ratio: SizeRatio) {
		_size_ratio = null
		_lines.forEach { line ->
			Log.e("RESIZING DOWN", "from " + line.from.x.toString() + ", " + line.from.y.toString() + " - " + line.to.x.toString() + ", " + line.to.y.toString())
			line.resizeDown(ratio)
			Log.e("RESIZING DOWN", "to " + line.from.x.toString() + ", " + line.from.y.toString() + " - " + line.to.x.toString() + ", " + line.to.y.toString())
		}
		_size_ratio = ratio
	}

	companion object {
		var COLORIZATION_CLICK_TOLERANCE = 30f
		val RESIZING_CLICK_TOLERANCE = 50f
	}
}