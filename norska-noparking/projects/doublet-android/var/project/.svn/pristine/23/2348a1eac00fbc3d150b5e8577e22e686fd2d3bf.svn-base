package net.noparking.projects.activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.activity_projects_manager.*
import kotlinx.android.synthetic.main.layout_project_description.view.*
import net.noparking.projects.R
import net.noparking.projects.adapter.LinearLayoutAdapter
import net.noparking.projects.database.image.ImageAsyncDelete
import net.noparking.projects.database.image.ImagesCollector
import net.noparking.projects.database.image.Image
import net.noparking.projects.database.line.LineAsyncDelete
import net.noparking.projects.database.polygon.PolygonAsyncDelete
import net.noparking.projects.database.polygon.PolygonsCollector
import net.noparking.projects.database.polygon_annotation.PolygonAnnotationAsyncDelete
import net.noparking.projects.database.project.Project
import net.noparking.projects.database.project.ProjectAsyncDelete
import net.noparking.projects.database.project.ProjectAsyncInsert
import net.noparking.projects.database.project.ProjectsCollector
import net.noparking.projects.utl.Directory
import net.noparking.projects.utl.ProjectItemParametring
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ProjectsManagerActivity : AppCompatActivity() {
	private lateinit var _projects_list: LiveData<List<Project>>

	private val _images_number: MutableMap<Long, Int> = mutableMapOf()

	private lateinit var _images_list: LiveData<List<Image>>

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		requestWindowFeature(Window.FEATURE_NO_TITLE)
		this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

		setContentView(R.layout.activity_projects_manager)
		title = getString(R.string.projects_list)

		_projects_list = ProjectsCollector().init(baseContext).getAll()
		_images_list = ImagesCollector().init(baseContext).getAll()
		_images_list.observe(this, Observer {
			_images_number.clear()
			getImagesNumber(it)
			initNewProjectButton()
			initProjectsView()
		})
	}

	private fun initNewProjectButton() {
		projects_manager_new_project.setOnClickListener {
			ProjectItemParametring(this)
					.setDefaultColor(Color.TRANSPARENT)
					.setDefaultInput("")
					.setNegativeAction {}
					.setNegativeLabel(getString(R.string.cancel))
					.disableNegativeLabelConfirmation()
					.setHint(getString(R.string.project_name))
					.setComparisonMethod { input -> compareProjectNames(input) }
					.setPositiveAction { name, color -> createNewProject(name, color) }
					.show()
		}
	}

	private fun initProjectsView() {
		_projects_list.observe(this, Observer {projects ->
			if (projects != null && projects.isNotEmpty()) {
				projects_manager_projects_list.visibility = View.VISIBLE
				projects_manager_no_projects.visibility = View.GONE

				val array: ArrayList<LinearLayout> = arrayListOf()
				projects.forEach {project ->
					val layout = layoutInflater.inflate(R.layout.layout_project_description, null) as LinearLayout

					layout.layout_project_description_project_name.text = project.project_name
					layout.layout_project_description_images_number.text = when (_images_number.containsKey(project.id)) {
						true -> _images_number[project.id]!!.toString()
						else -> "0"
					}
					array.add(layout)
				}
				projects_manager_projects_list.adapter = LinearLayoutAdapter(applicationContext, array)
				projects_manager_projects_list.setOnItemClickListener { _, _, _, id -> goToProjectManager(projects[id.toInt()]) }
				projects_manager_projects_list.setOnItemLongClickListener { _, _, _, id ->
					goToProjectParametring(projects[id.toInt()])
					true }
			} else {
				projects_manager_projects_list.visibility = View.GONE
				projects_manager_no_projects.visibility = View.VISIBLE
			}
		})
	}

	private fun getImagesNumber(images: List<Image>?) {
		if (images != null && images.isNotEmpty()) {
			images.forEach { image ->
				_images_number[image.project_id] = when (_images_number.containsKey(image.project_id)) {
					true -> _images_number[image.project_id]!! + 1
					else -> 1
				}
			}
		}
	}

	private fun compareProjectNames(name: String): Boolean {
		_projects_list.value!!.forEach {
			if (it.project_name == name) {
				return true
			}
		}
		return false
	}

	private fun goToProjectParametring(project: Project) {
		val param = ProjectItemParametring(this)
		param.setDefaultInput(project.project_name)
				.setDefaultColor(project.color)
				.setComparisonMethod { name -> compareProjectNames(name) }
				.setPositiveAction { name, color ->
					project.project_name = name
					project.color = color
					ProjectAsyncInsert().init(baseContext).execute(project) }
				.setNegativeAction { deleteProject(project) }
				.show()
	}

	private fun deleteProject(project: Project) {
		ImagesCollector().init(baseContext).getByProjectId(project.id!!).observe(this, Observer {images ->
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
		ProjectAsyncDelete().init(baseContext).deleteById(project.id!!).execute()

		val root = Directory(baseContext.filesDir, getString(R.string.projects_directory))
		val directory = Directory(root.getPath(), project.directory)
		directory.delete()
	}

	private fun createNewProject(name: String, color: Int) {
		val project = Project()
		project.directory = generateDirectoryFromProjectName(name)
		project.project_name = name
		project.color = color
		ProjectAsyncInsert().init(baseContext).afterQuery { project.id = it; goToProjectManager(project) }.execute(project)
	}

	private fun goToProjectManager(project: Project) {
		val intent = Intent(this, ProjectManagerActivity::class.java)
		intent.putExtra("project_id", project.id)
		startActivity(intent)
	}

	private fun generateDirectoryFromProjectName(raw: String): String {
		val result = raw.toLowerCase().replace(' ', '_')
		return result + "_" + SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
	}

	override fun onDestroy() {
		super.onDestroy()
	}
}