package net.noparking.projects.view.ImageEditionView.canvas.modes

import android.graphics.Canvas
import android.graphics.Color
import net.noparking.projects.utl.Position
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.drawing.Drawing
import android.content.Context


class PencilDrawingMode(internal val context: Context, internal val image_id: Long) {
    private val _drawings: MutableList<Drawing> = mutableListOf()
    private lateinit var _current_drawing: Drawing

    init {
        addNewEmptyDrawing()
    }

    private fun addNewEmptyDrawing() {
        _drawings.add(Drawing())
        _current_drawing = _drawings[_drawings.size - 1]
    }

    fun clear() {
        _drawings.clear()
        addNewEmptyDrawing()
    }

    fun onDraw(canvas: Canvas) {
        _drawings.forEach {
            canvas.drawPath(it.path, it.paint)
        }
    }

    fun downTouch(x: Float, y: Float, color: Int = Color.WHITE) {
        _current_drawing.paint.color = color
        _current_drawing.path.moveTo(x, y)
        _current_drawing.position = Position(x, y)
    }

    fun moveTouch(x: Float, y: Float) {
        val dx = Math.abs(x - _current_drawing.position.x)
        val dy = Math.abs(y - _current_drawing.position.y)
        if (dx >= TOLERANCE || dy >= TOLERANCE) {
            _current_drawing.path.quadTo(_current_drawing.position.x, _current_drawing.position.y, (x + _current_drawing.position.x) / 2, (y + _current_drawing.position.y) / 2)
            _current_drawing.position.x = x
            _current_drawing.position.y = y
        }
    }

    fun upTouch(x: Float, y: Float) {
        _current_drawing.path.lineTo(_current_drawing.position.x, _current_drawing.position.y)
        addNewEmptyDrawing()
    }

    companion object {
        val TOLERANCE = 5f
    }
}