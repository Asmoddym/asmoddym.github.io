package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import net.noparking.projects.utl.Position
import net.noparking.projects.utl.Math
import net.noparking.projects.utl.SizeRatio


class Line {
	var data = net.noparking.projects.database.line.Line()

	var from = Position()
	var to = Position()

	private var _last_translation_point: Position? = null

	val paint = Paint()
	private val _path = Path()

	init {
		paint.isAntiAlias = true
		paint.color = Color.WHITE
		paint.style = Paint.Style.STROKE
		paint.strokeJoin = Paint.Join.ROUND
		paint.strokeWidth = 8f
	}

	fun setOriginPoint(x: Float, y: Float) {
		from.x = x
		from.y = y
	}

	fun setEndPoint(x: Float, y: Float) {
		to.x = x
		to.y = y
	}

	fun updatePath(): Path {
		_path.reset()
		_path.moveTo(from.x, from.y)
		_path.lineTo(to.x, to.y)
		return _path
	}

	fun fromData(_data: net.noparking.projects.database.line.Line): Line {
		data = _data

		from = Position(data.from_x, data.from_y)
		to = Position(data.to_x, data.to_y)
		paint.color = data.color
		return this
	}

	fun toData(image_id: Long) {
		data.from_x = from.x
		data.from_y = from.y
		data.to_x = to.x
		data.to_y = to.y
		data.color = paint.color
		data.image_id = image_id
	}

	fun isCloseFrom(x: Float, y: Float, tolerance: Float): Boolean {
		val first_part = Math().distance(from, Position(x, y))
		val second_part = Math().distance(Position(x, y), to)
		val distance = Math().distance(from, to)

		return first_part + second_part <= distance + tolerance
	}

	fun getMiddlePoint(): Position {
		return Position((from.x + to.x) / 2, (from.y + to.y) / 2)
	}

	fun translate(x: Float, y: Float) {
		if (_last_translation_point == null) {
			_last_translation_point = Position(x, y)
		} else {
			val delta = Position(x - _last_translation_point?.x!!, y - _last_translation_point?.y!!)
			_last_translation_point?.y = y
			_last_translation_point?.x = x
			from.x += delta.x
			from.y += delta.y
			to.x += delta.x
			to.y += delta.y
		}
	}

	fun endTranslation() {
		_last_translation_point = null
	}

	fun isTranslating(): Boolean {
		return _last_translation_point != null
	}

	fun resizeUp(ratio: SizeRatio) {
		from.x *= ratio.width
		from.y *= ratio.height

		to.x *= ratio.width
		to.y *= ratio.height
	}

	fun resizeDown(ratio: SizeRatio) {
		from.x /= ratio.width
		from.y /= ratio.height

		to.x /= ratio.width
		to.y /= ratio.height
	}
}
