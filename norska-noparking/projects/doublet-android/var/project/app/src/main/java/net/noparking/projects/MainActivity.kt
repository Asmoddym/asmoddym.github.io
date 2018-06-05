package net.noparking.projects

import android.app.Activity
import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.content.FileProvider
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.noparking.projects.activity.ImageEditionActivity
import net.noparking.projects.activity.ProjectsManagerActivity
import net.noparking.projects.database.image.ImageAsyncDelete
import net.noparking.projects.database.image.ImagesCollector
import net.noparking.projects.database.line.LineAsyncDelete
import net.noparking.projects.database.line.LinesCollector
import net.noparking.projects.database.polygon.Polygon
import net.noparking.projects.database.polygon.PolygonAsyncDelete
import net.noparking.projects.database.polygon.PolygonsCollector
import net.noparking.projects.database.polygon_annotation.PolygonAnnotationAsyncDelete
import net.noparking.projects.database.polygon_annotation.PolygonAnnotationsCollector
import net.noparking.projects.database.project.ProjectAsyncDelete
import net.noparking.projects.database.project.ProjectsCollector
import net.noparking.projects.utl.Directory
import net.noparking.projects.utl.Image
import java.io.File

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
        initItems()
	}

	fun initItems() {
//
////CAMERA NORMALE
//		val intent = Intent(this, ImageEditionActivity::class.java)
//		intent.putExtra("project_directory", File(File(baseContext.filesDir, "doublet-projects"), "test_20180529_171851"))
//		intent.putExtra("image_id", 45.toLong())
//		startActivity(intent)


//// CAMERA FRONTALE
//        val image = Image(baseContext, contentResolver)
//        image.file = File(File(filesDir, "doublet-projects"), "JPEG_20180515_113342.jpg")
//        image.uri = FileProvider.getUriForFile(baseContext, baseContext.packageName + ".fileprovider", File(File(filesDir, "doublet-projects"), "JPEG_20180515_113342.jpg"))
//        val intent = Intent(this, ImageEditionActivity::class.java)
//        intent.putExtra("image_uri", image.uri)
//        intent.putExtra("image_file", image.file)
//        startActivity(intent)
//

////DUMP BDD
//		val a = ProjectsCollector().init(baseContext)
//		a.getAll().observe(this, Observer {
//			it!!.forEach { Log.e("PROJECT " + it.id.toString(), it.id.toString()) }
//		})
//		a.stop()
//
//		val b = ImagesCollector().init(baseContext)
//		b.getAll().observe(this, Observer {
//			it!!.forEach { Log.e("IMAGE " + it.id.toString(), "project_id: " + it.project_id.toString()) }
//		})
//		b.stop()
//
//		val c = PolygonsCollector().init(baseContext)
//		c.getAll().observe(this, Observer {
//			it!!.forEach { Log.e("POLYGON " + it.id.toString(), "image_id: " + it.image_id.toString()) }
//		})
//		c.stop()
//
//		val d = LinesCollector().init(baseContext)
//		d.getAll().observe(this, Observer {
//			it!!.forEach { Log.e("LINE " + it.id.toString(), "polygon_id: " + it.polygon_id.toString()) }
//		})
//		d.stop()
//
//		val e = PolygonAnnotationsCollector().init(baseContext)
//		e.getAll().observe(this, Observer {
//			it!!.forEach { Log.e("ANNOTATION " + it.id.toString(), "polygon_id: " + it.polygon_id.toString()) }
//		})
//		e.stop()
//

//
////HARD RESET
//		ProjectAsyncDelete().init(baseContext).execute()
//		ImageAsyncDelete().init(baseContext).execute()
//		PolygonAsyncDelete().init(baseContext).execute()
//		LineAsyncDelete().init(baseContext).execute()
//		PolygonAnnotationAsyncDelete().init(baseContext).execute()
//		val root = Directory(baseContext.filesDir, getString(R.string.projects_directory))
//		root.getPath().list().forEach {
//			val dir = Directory(root.getPath(), it)
//			dir.delete()
//		}

		val intent = Intent(this, ProjectsManagerActivity::class.java)
		startActivity(intent)
	}
}