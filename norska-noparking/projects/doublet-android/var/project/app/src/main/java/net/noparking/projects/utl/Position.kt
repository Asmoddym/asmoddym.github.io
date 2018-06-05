package net.noparking.projects.utl

class Position {
	var x: Float = 0.toFloat()
	var y: Float = 0.toFloat()

	constructor()
	constructor(x: Float, y: Float) {
		this.x = x
		this.y = y
	}

	fun clean() {
		x = 0.toFloat()
		y = 0.toFloat()
	}

	fun isEmpty(): Boolean {
		return x == 0.toFloat() && y == 0.toFloat()
	}

	fun isCloseFrom(position: Position, tolerance: Float): Boolean {
		return ((x >= position.x - tolerance && x <= position.x + tolerance) && (y >= position.y - tolerance && y <= position.y + tolerance))
	}

	fun isCloseFrom(_x: Float, _y: Float, tolerance: Float): Boolean {
		return ((x >= _x - tolerance && x <= _x + tolerance) && (y >= _y - tolerance && y <= _y + tolerance))
	}

	fun set(_x: Float, _y: Float) {
		x = _x
		y = _y
	}
}