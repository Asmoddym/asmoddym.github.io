package net.noparking.projects.activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_project_manager.*
import kotlinx.android.synthetic.main.layout_image_description.view.*
import kotlinx.android.synthetic.main.layout_zipper_state.view.*
import net.noparking.projects.R
import net.noparking.projects.adapter.LinearLayoutAdapter
import net.noparking.projects.database.image.Image
import net.noparking.projects.database.image.ImageAsyncDelete
import net.noparking.projects.database.image.ImageAsyncInsert
import net.noparking.projects.database.image.ImagesCollector
import net.noparking.projects.database.line.LineAsyncDelete
import net.noparking.projects.database.line.LinesCollector
import net.noparking.projects.database.line_annotation.LineAnnotationsCollector
import net.noparking.projects.database.line_annotation.LineAnnotation
import net.noparking.projects.database.polygon.PolygonAsyncDelete
import net.noparking.projects.database.polygon.PolygonsCollector
import net.noparking.projects.database.polygon_annotation.PolygonAnnotationAsyncDelete
import net.noparking.projects.database.project.Project
import net.noparking.projects.database.project.ProjectAsyncDelete
import net.noparking.projects.database.project.ProjectAsyncInsert
import net.noparking.projects.database.project.ProjectsCollector
import net.noparking.projects.utl.*
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.DrawingModes
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineDrawer
import net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line_annotation.LineAnnotationDrawer
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ProjectManagerActivity : AppCompatActivity() {
	private val _projects_collector = ProjectsCollector()
	private val _images_collector = ImagesCollector()

	private lateinit var _root_directory: Directory
	private lateinit var _project_directory: Directory
	private var _image_picker: ImagePicker? = null
	private var _new_image_created = false

	private var _project: Project? = null

	private lateinit var _images_list: LiveData<List<Image>>
	private lateinit var _projects_list: LiveData<List<Project>>

	private var _email_text = ""

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		requestWindowFeature(Window.FEATURE_NO_TITLE)
		this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

		setContentView(R.layout.activity_project_manager)

		initCollectors()

		initSupportActionBar()
		retrieveProjectInfos()
	}

	private fun initCollectors() {
		_images_collector.init(baseContext)
		_projects_collector.init(baseContext)
		_projects_list = _projects_collector.getAll()
		_projects_list.observe(this, Observer {})
	}

	private fun initSupportActionBar() {
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		supportActionBar?.setDisplayShowHomeEnabled(true)
	}

	override fun onSupportNavigateUp(): Boolean {
		finish()
		return super.onSupportNavigateUp()
	}

	private fun retrieveProjectInfos() {
		_projects_collector.getById(intent.getLongExtra("project_id", 0)).observe(this, Observer<Project> {
			if (it != null) {
				_project = it
				_images_list = _images_collector.init(baseContext).getByProjectId(_project?.id!!)
				updateTitle()
				initDirectories(it.directory)
				retrieveProjectImages()
				initViewItems()
			}
		})
	}

	private fun updateTitle() {
		title = getString(R.string.project) + " \"" + _project!!.project_name + "\""
		if (_project!!.color != Color.TRANSPARENT) {
			supportActionBar?.setBackgroundDrawable(ColorDrawable(_project!!.color))
		}
	}

	private fun retrieveProjectImages() {
		_images_list.observe(this, Observer { list ->
			if (list != null && list.isNotEmpty() && _new_image_created == false) {
				setImagesListVisibility(STATE_SHOW)
				val array: ArrayList<LinearLayout> = arrayListOf()
				list.forEach { image ->
					val view = layoutInflater.inflate(R.layout.layout_image_description, null) as LinearLayout
					view.layout_image_description_image_name.text = image.image_name
					view.layout_image_description_last_modification_time.text = SimpleDateFormat("MM/dd/yyyy - HH:mm:ss").format(Date(image.last_modification_time))
					array.add(view)
				}

				project_manager_images_list.adapter = LinearLayoutAdapter(applicationContext, array)
				project_manager_images_list.setOnItemClickListener { _, _, _, id -> goToImageEdition(list[id.toInt()]) }
				project_manager_images_list.setOnItemLongClickListener { _, _, _, id -> goToImageParametring(list[id.toInt()]);true }

				project_manager_export.isClickable = true
				project_manager_export.alpha = 1f
				project_manager_export.setOnClickListener { exportProject() }
			} else {
				project_manager_export.isClickable = false
				project_manager_export.alpha = 0.3f

				setImagesListVisibility(when (_new_image_created) { true -> STATE_LOADING
					else -> STATE_NO_IMAGE
				})
			}
		})
	}

	private fun initDirectories(directory_name: String) {
		_root_directory = Directory(baseContext.filesDir, getString(R.string.projects_directory))
		_root_directory.create()
		_project_directory = Directory(_root_directory.getPath(), directory_name)
		_project_directory.create()
	}

	private fun initViewItems() {
		_image_picker = ImagePicker(this, _project_directory)
		project_manager_new_image.setOnClickListener { _image_picker?.show() }
	}

	private fun exportProject() {
		val list = _images_list.value
		val view = layoutInflater.inflate(R.layout.layout_zipper_state, null)

		view.layout_zipper_state_current.text = "0"
		view.layout_zipper_state_total.text = list?.size.toString()
		val dialog = AlertDialog.Builder(this)
				.setView(view)
				.setOnDismissListener {
					if (view.parent != null) {
						(view.parent as ViewGroup).removeView(view)
					}
				}
				.create()
		dialog.show()

		Thread(Runnable {
			val zip_files: MutableList<ZipFile> = mutableListOf()
			var zip: ZipFile? = null

			_email_text = getString(R.string.images) + ": " + list!!.size.toString() + "\n\n"
			for (i in 0 until list.size) {
				if (i % 5 == 0) {
					zip_files.add(ZipFile(baseContext, _project_directory, "ZIP_" + _project?.directory + "_" + ((i / 5) + 1).toString() + ".zip"))
					zip = zip_files[zip_files.size - 1]
				}
				this.runOnUiThread({ view.layout_zipper_state_current.text = (i + 1).toString() })
				val image = list[i]

				val blit_image = blitImageDrawings(image)
				zip?.addContent(File(_project_directory.getPath(), image.file_name), image.image_name + ".jpg")

				val annotated = File(_project_directory.getPath(), blit_image.second.file_name)
				if (annotated.exists()) {
					zip?.addContent(File(_project_directory.getPath(), blit_image.second.file_name), blit_image.first)
				}
			}
			val uris: ArrayList<Uri> = arrayListOf()
			zip_files.forEach { z ->
				z.close()
				uris.add(z.uri)
			}
			dialog.dismiss()
			sendMail(getString(R.string.export_for_project) + "\"" + _project?.project_name + "\"", _email_text, uris)
		}).start()
	}

	fun blitImageDrawings(db_image: Image): Pair<String, net.noparking.projects.utl.Image> {
		val blit_image = net.noparking.projects.utl.Image(baseContext, _project_directory, contentResolver)
		blit_image.create(db_image.file_name + "_rendered.jpg")
		blit_image.removeIfExisting()

		val image = net.noparking.projects.utl.Image(baseContext, _project_directory, contentResolver)
		image.uri = Uri.parse(db_image.uri)
		image.file = File(_project_directory.getPath(), db_image.file_name)

		val canvas = Canvas()
		val bitmap = image.getBitmap()!!
		canvas.setBitmap(bitmap)

		val annotations = LineAnnotationsCollector().init(baseContext)
		val lines_collector = LinesCollector().init(baseContext)
		val annotations_drawer = LineAnnotationDrawer(this)
		val lines_drawer = LineDrawer()
		val line = Line()
		lines_collector.getByImageId(db_image.id!!).observe(this, Observer { lines ->
			if (lines != null && lines.isNotEmpty()) {
				for (line_idx in 0 until lines.size) {
					val db_line = lines[line_idx]
					line.fromData(db_line)
					line.paint.strokeWidth *= (1.5).toFloat()
					lines_drawer.draw(canvas, line, DrawingModes.MODE_NONE)
					annotations.getByLineId(db_line.id!!).observe(this, Observer { annotation ->
						if (annotation != null) {
							if (annotation.comment.isNotEmpty()) {
								_email_text += "- " + db_image.image_name + ": " + "\n" + annotation.comment + "\n\n"
							}
							annotations_drawer.TEXT_PAINT.color = line.paint.color
							annotations_drawer.draw(canvas, line, annotation)
						}
						if (line_idx == lines.size - 1) {
							val out = FileOutputStream(blit_image.file)
							bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
							out.close()
						}
					})
				}
			}
		})
		annotations.stop()
		lines_collector.stop()

		return Pair(db_image.image_name + "(" + getString(R.string.with_annotations) + ").jpg", blit_image)
	}

//
//	private fun generateMessageText(list: List<Image>?): String {
//		var text = getString(R.string.images) + ": " + _images_list.value?.size.toString() + "\n\n"
//		if (list != null && list.isNotEmpty()) {
//			list.forEach { image ->
//			}
//		}
//		return text
//	}

	private fun sendMail(subject: String, text: String, attachments: ArrayList<Uri>) {
		val emailIntent = Intent(Intent.ACTION_SEND_MULTIPLE).apply {
			putExtra(Intent.EXTRA_SUBJECT, subject)
			putExtra(Intent.EXTRA_TEXT, text)
			putParcelableArrayListExtra(Intent.EXTRA_STREAM, attachments)
		}
		emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
		emailIntent.type = "text/plain"
		startActivity(emailIntent)
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (requestCode == ACTIVITY_IMAGE_EDITION) {
			_new_image_created = false
		} else {
			val new_image = _image_picker!!.onActivityResult(requestCode, resultCode, data)
			if (new_image.uri == Uri.EMPTY) {
				Toast.makeText(this, getString(R.string.error_creating_image), Toast.LENGTH_LONG).show()
			} else {
				saveImage(new_image)
			}
		}
	}

	private fun saveImage(image: net.noparking.projects.utl.Image) {
		val to_save = Image()

		to_save.creation_time = System.currentTimeMillis()
		to_save.last_modification_time = to_save.creation_time

		to_save.file_name = image.file_name
		to_save.uri = image.uri.toString()
		to_save.project_id = _project?.id!!

		ProjectItemParametring(this)
				.setDefaultColor(Color.TRANSPARENT)
				.allowEmptyInput()
				.setHint(to_save.file_name.substring(0, to_save.file_name.lastIndexOf('.')))
				.setDefaultInput("")
				.setNegativeAction {}
				.disableNegativeLabelConfirmation()
				.setNegativeLabel(getString(R.string.cancel))
				.setPositiveAction { name, color ->
					to_save.image_name = when (name != "") {
						true -> name
						else -> to_save.file_name.substring(0, to_save.file_name.lastIndexOf('.'))
					}
					to_save.color = color

					ImageAsyncInsert().init(baseContext).afterQuery {
						to_save.id = it
						_new_image_created = true
						setImagesListVisibility(STATE_LOADING)
						goToImageEdition(to_save)
					}.execute(to_save)
				}
				.show()
	}

	private fun setImagesListVisibility(state: Int) {
		if (state == STATE_NO_IMAGE) {
			project_manager_images_list.visibility = View.GONE
			project_manager_no_images.visibility = View.VISIBLE
			project_manager_saving.visibility = View.GONE
		} else if (state == STATE_SHOW) {
			project_manager_images_list.visibility = View.VISIBLE
			project_manager_no_images.visibility = View.GONE
			project_manager_saving.visibility = View.GONE
		} else if (state == STATE_LOADING) {
			project_manager_images_list.visibility = View.GONE
			project_manager_no_images.visibility = View.GONE
			project_manager_saving.visibility = View.VISIBLE
		}
	}

	override fun onResume() {
		super.onResume()
		_image_picker?.reset()
	}

	private fun goToImageEdition(image: Image) {
		val intent = Intent(this, ImageEditionActivity::class.java)
		intent.putExtra("image_id", image.id)
		intent.putExtra("project_directory", _project_directory.getPath())
		startActivityForResult(intent, ACTIVITY_IMAGE_EDITION)
		setImagesListVisibility(STATE_LOADING)
	}

	private fun changeProjectParameters() {
		ProjectItemParametring(this)
				.setDefaultColor(_project?.color!!)
				.setDefaultInput(_project?.project_name!!)
				.setPositiveAction { name, color ->
					_project?.project_name = name
					_project?.color = color
					ProjectAsyncInsert().init(baseContext).execute(_project)
					updateTitle()
				}
				.setNegativeAction { deleteProject() }
				.setComparisonMethod { name -> compareProjectNames(name) }
				.show()
	}

	private fun deleteProject() {
		if (_project == null) {
			return
		}
		ImagesCollector().init(baseContext).getByProjectId(_project?.id!!).observe(this, Observer { images ->
			images!!.forEach { image ->
				PolygonsCollector().init(baseContext).getByImageId(image.id!!).observe(this, Observer { polygons ->
					polygons!!.forEach { polygon ->
						LineAsyncDelete().init(baseContext).deleteByPolygonId(polygon.id!!).execute()
						PolygonAnnotationAsyncDelete().init(baseContext).deleteByPolygonId(polygon.id!!).execute()
					}
					PolygonAsyncDelete().init(baseContext).deleteByImageId(image.id!!).execute()
				})
				ImageAsyncDelete().init(baseContext).deleteById(image.id!!).execute()
			}
		})
		ProjectAsyncDelete().init(baseContext).deleteById(_project?.id!!).execute()

		val root = Directory(baseContext.filesDir, getString(R.string.projects_directory))
		val directory = Directory(root.getPath(), _project?.directory!!)
		directory.delete()
	}

	private fun deleteImage(image: Image) {
		val file_name = image.file_name
		PolygonsCollector().init(baseContext).getByImageId(image.id!!).observe(this, Observer { polygons ->
			polygons!!.forEach { polygon ->
				LineAsyncDelete().init(baseContext).deleteByPolygonId(polygon.id!!).execute()
				PolygonAnnotationAsyncDelete().init(baseContext).deleteByPolygonId(polygon.id!!).execute()
			}
			PolygonAsyncDelete().init(baseContext).deleteByImageId(image.id!!).execute()
		})
		ImageAsyncDelete().init(baseContext).deleteById(image.id!!).execute()
		File(_project_directory.getPath(), file_name).delete()
		File(_project_directory.getPath(), file_name + "_rendered.jpg").delete()
	}

	private fun goToImageParametring(image: Image) {
		val param = ProjectItemParametring(this)
		param.setDefaultInput(image.image_name)
				.setDefaultColor(image.color)
				.setHint(image.image_name)
				.setComparisonMethod { name -> compareImageNames(name) }
				.setPositiveAction { name, color ->
					if (name != "") {
						image.image_name = name
					}
					image.color = color
					image.last_modification_time = System.currentTimeMillis()
					ImageAsyncInsert().init(baseContext).execute(image)
				}
				.setNegativeAction { deleteImage(image) }
				.show()
	}

	private fun compareImageNames(name: String): Boolean {
		if (_images_list.value != null || _images_list.value!!.isNotEmpty()) {
			_images_list.value?.forEach { image ->
				if (image.image_name == name) {
					return true
				}
			}
		}
		return false
	}

	private fun compareProjectNames(name: String): Boolean {
		if (_projects_list.value != null && _projects_list.value!!.isNotEmpty()) {
			_projects_list.value?.forEach { project ->
				if (project.project_name == name) {
					return true
				}
			}
		}
		return false
	}

	override fun onOptionsItemSelected(item: MenuItem?): Boolean {
		super.onOptionsItemSelected(item)
		when (item?.itemId) {
			R.id.menu_project_manager_main_project_parameters -> { changeProjectParameters() }
			else -> { finish() }
		}
		return true
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		super.onCreateOptionsMenu(menu)
		menuInflater.inflate(R.menu.menu_project_manager_main, menu)
		return true
	}

	companion object {
		val STATE_NO_IMAGE = 0
		val STATE_SHOW = 1
		val STATE_LOADING = 2

		val ACTIVITY_IMAGE_EDITION = 3
	}
}
