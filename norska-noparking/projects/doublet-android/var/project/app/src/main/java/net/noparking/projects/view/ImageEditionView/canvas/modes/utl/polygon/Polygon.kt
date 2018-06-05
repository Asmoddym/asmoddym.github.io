package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import net.noparking.projects.utl.Position

class Polygon {
	var db_id: Long = 0
	val sides: MutableList<Line> = mutableListOf()
	val global_path: Path = Path()
	val average_fill_paint: Paint = Paint()
	var status = IN_PROGRESS
	var drawing_new_line = false
	var id = 0

	init {
		average_fill_paint.isAntiAlias = true
		average_fill_paint.color = Color.WHITE
		average_fill_paint.style = Paint.Style.FILL_AND_STROKE
		average_fill_paint.strokeJoin = Paint.Join.ROUND
		average_fill_paint.strokeWidth = 8f
	}

	lateinit var current_side: Line

	fun addNewEmptySide() {
		sides.add(Line())
		current_side = sides[sides.size - 1]
	}

	fun getLastSide(): Line {
		return sides[sides.size - 1]
	}

	fun getLastSavedSide(): Line {
		return sides[sides.size - 2]
	}

	fun setColor(color: Int) {
		sides.forEach {
			it.paint.color = color
		}
	}

	fun getOriginPosition(): Position {
		return sides[0].from
	}

	fun clean() {
		sides.clear()
	}

	fun close() {
		status = CLOSED
		updateGlobalPath()
	}

	fun updateGlobalPath() {
		var r = 0
		var g = 0
		var b = 0

		global_path.reset()
		if (sides.isEmpty()) {
			return;
		}

		global_path.moveTo(sides[0].from.x, sides[0].from.y)
		sides.forEach {
			global_path.lineTo(it.to.x, it.to.y)

			r += Color.red(it.paint.color)
			g += Color.green(it.paint.color)
			b += Color.blue(it.paint.color)
		}
		global_path.close()
		average_fill_paint.setARGB(100, r / sides.size, g / sides.size, b / sides.size)
	}

	companion object {
		val IN_PROGRESS = 0
		val CLOSING_PROPOSITION = 1
		val CLOSED = 2

		val REDIMENSIONNING = 3
		val REDIMENSIONNING_CLOSED = 4
	}
}