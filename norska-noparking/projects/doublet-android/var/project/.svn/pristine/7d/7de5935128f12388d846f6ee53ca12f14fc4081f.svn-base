package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.drawing

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import net.noparking.projects.utl.Position

class Drawing {
    var position: Position = Position()
    var path: Path = Path()
    var paint: Paint = Paint()

    init {
        initPaint(Color.WHITE)
    }

    private fun initPaint(color: Int) {
        paint.isAntiAlias = true
        paint.color = color
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 8f
    }
}