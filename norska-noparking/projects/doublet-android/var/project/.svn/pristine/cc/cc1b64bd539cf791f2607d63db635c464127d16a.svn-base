package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.DrawingModes

class LineDrawer {
	fun draw(canvas: Canvas, line: Line, mode: Int) {
		canvas.drawPath(line.updatePath(), line.paint)
		if (mode == DrawingModes.MODE_LINE_DRAWING && !line.isTranslating()) {
			canvas.drawCircle(line.from.x, line.from.y, RESIZING_CIRCLE_RADIUS, RESIZING_CIRCLE_PAINT)
			canvas.drawCircle(line.to.x, line.to.y, RESIZING_CIRCLE_RADIUS, RESIZING_CIRCLE_PAINT)
		}
	}

	val RESIZING_CIRCLE_RADIUS = 50f
	val RESIZING_CIRCLE_PAINT = Paint()

	init {
		RESIZING_CIRCLE_PAINT.isAntiAlias = true
		RESIZING_CIRCLE_PAINT.color = Color.RED
		RESIZING_CIRCLE_PAINT.style = Paint.Style.STROKE
		RESIZING_CIRCLE_PAINT.strokeJoin = Paint.Join.ROUND
		RESIZING_CIRCLE_PAINT.strokeWidth = 5f
	}
}