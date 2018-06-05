package net.noparking.projects.view.ImageEditionView.canvas

import android.content.Context
import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import net.noparking.projects.view.ImageEditionView.ImageEditionView
import net.noparking.projects.view.ImageEditionView.canvas.modes.LineDrawingMode
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.DrawingModes
import net.noparking.projects.utl.SizeRatio

class CanvasView(internal var context: Context, attrs: AttributeSet): View(context, attrs) {
	private lateinit var _parent_activity: AppCompatActivity
	private lateinit var _lines_drawing_mode: LineDrawingMode
	private lateinit var _parent_view: ImageEditionView
	private var _size_ratio = SizeRatio()

	fun init(image_id: Long, parent_activity: AppCompatActivity) {
		_parent_activity = parent_activity

		_lines_drawing_mode = LineDrawingMode(parent_activity, image_id)
		_lines_drawing_mode.init(DrawingModes.MODE_LINE_DRAWING)
		invalidate()
	}

	fun setColor(color: Int) {
		_lines_drawing_mode.current_color = color
		invalidate()
	}

	fun setClearMode(): Boolean {
		invalidate()
		return true
	}

	fun clear() {
		invalidate()
	}

	fun setDrawingMode(mode: Int) {
		_lines_drawing_mode.mode = mode
		invalidate()
	}

	override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
		val view = _parent_view.getImageView()
		val original_dim = _parent_view.getOriginalBackgroundDimensions()

		if (original_dim.width > 0 && original_dim.height > 0) {
			_size_ratio.width = original_dim.width.toFloat() / view.width.toFloat()
			_size_ratio.height = original_dim.height.toFloat() / view.height.toFloat()
			_parent_view.getImageView()
			_lines_drawing_mode.updateSizeRatio(_size_ratio)
		}
		invalidate()
	}

	override fun onDraw(canvas: Canvas) {
		_lines_drawing_mode.onDraw(canvas)
		invalidate()
	}

	override fun onTouchEvent(event: MotionEvent): Boolean {
		val x = event.x
		val y = event.y

		Log.e(x.toString(), y.toString())


		when (event.action) {
			MotionEvent.ACTION_DOWN -> {
				downTouch(x, y)
			}
			MotionEvent.ACTION_MOVE -> {
				moveTouch(x, y)
			}
			MotionEvent.ACTION_UP -> {
				upTouch(x, y)
			}
		}
		invalidate()
		return true
	}

	private fun downTouch(x: Float, y: Float) {
		_lines_drawing_mode.downTouch(x, y)
		invalidate()
	}

	private fun moveTouch(x: Float, y: Float) {
		_lines_drawing_mode.moveTouch(x, y)
		invalidate()
	}

	private fun upTouch(x: Float, y: Float) {
		_lines_drawing_mode.upTouch(x, y)
		invalidate()
	}

	fun destroy() {
		_lines_drawing_mode.save()
	}

	fun setViewInfos(parent_view: ImageEditionView) {
		_parent_view = parent_view
	}
}