package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import net.noparking.projects.utl.Position

class Line {
    var db_id: Long = 0
    var from: Position = Position()
    var to: Position = Position()
    var path: Path = Path()
    var paint: Paint = Paint()

    private fun initPaint(color: Int) {
        paint.isAntiAlias = true
        paint.color = color
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 8f
    }

    fun clean() {
        from.clean()
        to.clean()
        initPaint(Color.WHITE)
        path.reset()
    }

    fun init(color: Int) {
        clean()
        initPaint(color)
        path.reset()
    }

    fun update() {
        path.reset()
        path.moveTo(from.x, from.y)
        path.lineTo(to.x, to.y)
        path.close()
    }
}