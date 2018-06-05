package net.noparking.projects.activity

import android.arch.lifecycle.Observer
import android.content.ComponentCallbacks2
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
import net.noparking.projects.R
import net.noparking.projects.utl.Image
import kotlinx.android.synthetic.main.activity_image_editing.*
import net.noparking.projects.database.image.ImageAsyncInsert
import net.noparking.projects.database.image.ImagesCollector
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.DrawingModes
import petrov.kristiyan.colorpicker.ColorPicker
import java.io.File

class ImageEditionActivity : AppCompatActivity() {
	private lateinit var _background: Image

	private var _image = net.noparking.projects.database.image.Image()
	private lateinit var _border: Drawable

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestWindowFeature(Window.FEATURE_NO_TITLE)
		this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
		setContentView(R.layout.activity_image_editing)

		_border = getDrawable(R.drawable.drawable_border_line)
		initSupportActionBar()
		retrieveImageInfos()
	}

	private fun initSupportActionBar() {
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		supportActionBar?.setDisplayShowHomeEnabled(true)
	}

	private fun retrieveImageInfos() {
		if (intent.extras.containsKey("image_id")) {
			ImagesCollector().init(baseContext).getById(intent.extras["image_id"] as Long).observe(this, Observer { image ->
				if (image != null) {
					_image = image
					updateTitle()
					initBackground()
					initControlPanel()
				}
			})
		}
	}

	private fun updateTitle() {
		title = getString(R.string.image) + " \"" + _image.image_name + "\""

		if (_image.color != Color.TRANSPARENT) {
			supportActionBar?.setBackgroundDrawable(ColorDrawable(_image.color))
		}
	}

	private fun initBackground() {
		_background = Image(baseContext, null, contentResolver)
		_background.uri = Uri.parse(_image.uri)
		_background.file = File(intent.extras["project_directory"] as File, _image.file_name)
		image_edition_imageeditionview.init(_image.id!!, this)
		image_edition_imageeditionview.setBackgroundInfos(_background)
	}

	private fun initControlPanel() {
		image_edition_view_current_color.setBackgroundColor(Color.CYAN)
		image_edition_imageeditionview.getCanvas().setColor(Color.CYAN)
		updateButtonsLayout(image_edition_imagebutton_control_polygon_edition)

		image_edition_imagebutton_control_color_picker.setOnClickListener {
			val colorPicker = ColorPicker(this)

			colorPicker.setTitle(getString(R.string.choose_a_color))
			colorPicker.setOnFastChooseColorListener(object : ColorPicker.OnFastChooseColorListener {
				override fun setOnFastChooseColorListener(position: Int, color: Int) {
					updateButtonsLayout(image_edition_imagebutton_control_color_picker)
					image_edition_imageeditionview.getCanvas().setColor(color)
					image_edition_imageeditionview.getCanvas().setDrawingMode(DrawingModes.MODE_LINE_COLOR_PICKING)
					image_edition_view_current_color.setBackgroundColor(color)
				}

				override fun onCancel() {}
			}).show()
		}

		image_edition_imagebutton_control_polygon_edition.setOnClickListener {
			updateButtonsLayout(image_edition_imagebutton_control_polygon_edition)
			image_edition_imageeditionview.getCanvas().setDrawingMode(DrawingModes.MODE_LINE_DRAWING)
		}

		image_edition_imagebutton_control_clear_canvas.setOnClickListener {
			updateButtonsLayout(image_edition_imagebutton_control_clear_canvas)
			image_edition_imageeditionview.getCanvas().setDrawingMode(DrawingModes.MODE_LINE_DELETION)
		}

		image_edition_imagebutton_control_annotations_edition.setOnClickListener {
			updateButtonsLayout(image_edition_imagebutton_control_annotations_edition)
			image_edition_imageeditionview.getCanvas().setDrawingMode(DrawingModes.MODE_LINE_ANNOTATION)
		}
	}

	fun updateButtonsLayout(button: ImageButton) {
		if (button == image_edition_imagebutton_control_color_picker) {
			image_edition_imagebutton_control_color_picker.background = _border
		} else {
			image_edition_imagebutton_control_color_picker.setBackgroundColor(Color.TRANSPARENT)
		}

		if (button == image_edition_imagebutton_control_annotations_edition) {
			image_edition_imagebutton_control_annotations_edition.background = _border
		} else {
			image_edition_imagebutton_control_annotations_edition.setBackgroundColor(Color.TRANSPARENT)
		}

		if (button == image_edition_imagebutton_control_clear_canvas) {
			image_edition_imagebutton_control_clear_canvas.background = _border
		} else {
			image_edition_imagebutton_control_clear_canvas.setBackgroundColor(Color.TRANSPARENT)
		}

		if (button == image_edition_imagebutton_control_polygon_edition) {
			image_edition_imagebutton_control_polygon_edition.background = _border
		} else {
			image_edition_imagebutton_control_polygon_edition.setBackgroundColor(Color.TRANSPARENT)
		}
	}

	override fun onOptionsItemSelected(item: MenuItem?): Boolean {
		super.onOptionsItemSelected(item)
		if (item?.itemId == R.id.menu_image_edition_main_save_and_quit) {
			finish()
		} else {
			finish()
		}
		return true
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		super.onCreateOptionsMenu(menu)
		menuInflater.inflate(R.menu.menu_image_edition_main, menu)
		return true
	}

	override fun onDestroy() {
		image_edition_imageeditionview.getCanvas().destroy()

		_image.last_modification_time = System.currentTimeMillis()
		ImageAsyncInsert().init(baseContext).execute(_image)

		super.onDestroy()
	}
}