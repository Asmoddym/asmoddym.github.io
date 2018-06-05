package net.noparking.projects.view.ImageEditionView

import android.content.Context
import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_image_editing.view.*
import net.noparking.projects.view.ImageEditionView.canvas.CanvasView
import net.noparking.projects.R
import net.noparking.projects.utl.Dimensions
import net.noparking.projects.utl.Image

class ImageEditionView(internal var context: Context, attrs: AttributeSet): RelativeLayout(context, attrs) {
	private var _bitmap: Bitmap? = null
	private var _background_dimensions = Dimensions()
	private lateinit var _image: ImageView
	private lateinit var _canvas: CanvasView

	fun init(image_id: Long, parent_activity: AppCompatActivity) {
		LayoutInflater.from(context).inflate(R.layout.layout_image_view, this)
		_image = findViewById(R.id.image_view_image_view)
		_canvas = findViewById(R.id.image_view_canvas_view)
		_canvas.init(image_id, parent_activity)
	}

	override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
		super.onSizeChanged(w, h, oldw, oldh)
		_image.setImageBitmap(_bitmap)
	}


	fun setBackgroundInfos(background: Image) {
		_bitmap = background.getBitmap()
		_background_dimensions = background.dimensions

		_image.setImageBitmap(_bitmap)

		_canvas.setViewInfos(image_edition_imageeditionview)
	}

	override fun onDraw(canvas: Canvas) {
		super.onDraw(canvas)
	}

	fun getOriginalBackgroundDimensions(): Dimensions {
		return _background_dimensions
	}

	fun getImageView(): ImageView {
		return _image
	}

	fun getCanvas(): CanvasView {
		return _canvas
	}
}