package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line_annotation

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.util.Log
import net.noparking.projects.R
import net.noparking.projects.database.line_annotation.LineAnnotation
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line

class LineAnnotationDrawer(internal val activity: AppCompatActivity) {
	val TEXT_PAINT = Paint()
	val TEXT_BG_PAINT = Paint()
	val TEXT_BG_PADDING = 10
	val TEXT_METRICS = Paint.FontMetrics()

	init {
		TEXT_PAINT.isAntiAlias = true
		TEXT_PAINT.style = Paint.Style.FILL_AND_STROKE
		TEXT_PAINT.strokeJoin = Paint.Join.ROUND
		TEXT_PAINT.strokeWidth = 2f
		TEXT_PAINT.textSize = 40f

		TEXT_PAINT.getFontMetrics(TEXT_METRICS)

		TEXT_BG_PAINT.isAntiAlias = true
		TEXT_BG_PAINT.color = Color.BLACK
		TEXT_BG_PAINT.style = Paint.Style.FILL_AND_STROKE
		TEXT_BG_PAINT.strokeJoin = Paint.Join.ROUND
		TEXT_BG_PAINT.strokeWidth = 2f
	}

	fun draw(canvas: Canvas, line: Line, lineAnnotation: LineAnnotation) {
		val middle_point = line.getMiddlePoint()
		val text = lineAnnotation.length.toString() + activity.baseContext.getString(R.string.unit_side_annotations)
		TEXT_PAINT.color = line.paint.color

		canvas.drawRect(middle_point.x - TEXT_PAINT.measureText(text) / 2 - TEXT_BG_PADDING,
				middle_point.y + TEXT_METRICS.top - TEXT_BG_PADDING,
				middle_point.x + TEXT_PAINT.measureText(text) / 2 + TEXT_BG_PADDING,
				middle_point.y + TEXT_METRICS.bottom + TEXT_BG_PADDING,
				TEXT_BG_PAINT)
		canvas.drawText(text, middle_point.x - TEXT_PAINT.measureText(text) / 2, middle_point.y, TEXT_PAINT)
	}
}