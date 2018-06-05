package net.noparking.projects.view.ImageEditionView.canvas.modes

import android.arch.lifecycle.Observer
import android.graphics.*
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line
import android.support.v7.app.AppCompatActivity
import net.noparking.projects.R
import net.noparking.projects.database.line_annotation.LineAnnotation
import net.noparking.projects.database.line_annotation.LineAnnotationAsyncDelete
import net.noparking.projects.database.line_annotation.LineAnnotationAsyncInsert
import net.noparking.projects.database.line_annotation.LineAnnotationsCollector
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line_annotation.LineAnnotationDrawer

class LineAnnotationMode(internal val activity: AppCompatActivity,
						 internal val lines: MutableList<Line>,
						 internal val image_id: Long) {
	private val _lines_annotations: MutableMap<Line, LineAnnotation> = mutableMapOf()
	private val _picker = LineAnnotationPicker(activity)
	private val _drawer = LineAnnotationDrawer(activity)

	fun init() {
		retrieveFromDatabase()
	}

	fun onDraw(canvas: Canvas) {
		_lines_annotations.forEach { line, annotation ->
			_drawer.draw(canvas, line, annotation)
		}
	}

	fun downTouch(x: Float, y: Float) {
		lines.forEach { line ->
			if (line.isCloseFrom(x, y, CLICK_TOLERANCE)) {
				val tmp = when (_lines_annotations.containsKey(line)) {
					true -> _lines_annotations[line]!!
					else -> LineAnnotation()
				}
				_picker.init()
						.setData(tmp)
						.setNegativeLabel(activity.getString(when (_lines_annotations.containsKey(line)) {
							true -> R.string.delete
							else -> R.string.cancel
						}))
						.setPositiveLabel(activity.getString(R.string.save))
						.enableConfirmation(_lines_annotations.containsKey(line))
						.setNegativeAction { id -> deleteAnnotation(line) }
						.setPositiveAction { id, length, comment -> saveAnnotation(id, length, comment, tmp, line) }
						.show()
				return
			}
		}
	}

	fun saveAnnotation(id: Long, length: Float?, comment: String, annotation: LineAnnotation, reference: Line) {
		annotation.comment = comment
		annotation.image_id = image_id
		annotation.length = length
		if (!_lines_annotations.containsKey(reference)) {
			_lines_annotations[reference] = annotation
		}
	}

	fun deleteAnnotation(line: Line) {
		if (_lines_annotations.containsKey(line)) {
			_lines_annotations.remove(line)
		}
	}

	fun moveTouch(x: Float, y: Float) {}

	fun upTouch(x: Float, y: Float) {}

	fun retrieveFromDatabase() {
		LineAnnotationsCollector().init(activity.baseContext).getByImageId(image_id).observe(activity, Observer { annotations ->
			if (annotations != null && annotations.isNotEmpty()) {
				annotations.forEach { annotation ->
					lines.forEach { line ->
						if (line.data.id == annotation.line_id) {
							_lines_annotations[line] = annotation
						}
					}
				}
			}
		})
	}

	fun save() {
		LineAnnotationAsyncDelete().init(activity.baseContext).deleteByImageId(image_id).afterQuery {
			_lines_annotations.forEach { line, annotation ->
				annotation.line_id = line.data.id!!
				LineAnnotationAsyncInsert().init(activity.baseContext).execute(annotation)
			}
		}.execute()
	}

	fun removeAnnotationByLine(line: Line?) {
		if (line != null && _lines_annotations.containsKey(line)) {
			_lines_annotations.remove(line)
		}
	}

	companion object {
		val CLICK_TOLERANCE = 30f
	}
}