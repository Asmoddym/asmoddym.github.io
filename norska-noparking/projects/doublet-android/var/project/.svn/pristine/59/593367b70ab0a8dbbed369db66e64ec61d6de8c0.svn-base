package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon

import android.support.v7.app.AppCompatActivity

class PolygonAnnotationData(internal var polygon: Polygon, internal var activity: AppCompatActivity) {
	var height: Float = 0f
	var width: Float = 0f
	var surface: Float = 0f
	var comment: String = ""
}

//
//import android.app.Activity
//import android.app.AlertDialog
//import android.text.Editable
//import android.text.TextWatcher
//import android.view.View
//import kotlinx.android.synthetic.main.layout_polygon_annotation.view.*
//import net.noparking.projects.R
//
//class PolygonAnnotationData(internal var polygon: Polygon, internal var activity: Activity) {
//	var height: Float = 0f
//	var width: Float = 0f
//	var surface: Float = 0f
//	var comment: String = ""
//	var is_recalculating = false
//
//	fun show(array: MutableMap<Int, PolygonAnnotationData>) {
//		val builder = AlertDialog.Builder(activity)
//		val view = initView()
//
//
//		builder.setView(view)
//				.setTitle(activity.getString(R.string.handle_annotations))
//				.setPositiveButton(activity.getString(R.string.ok), { dialog, which -> })
//				.setNegativeButton(activity.getString(R.string.cancel), { dialog, which ->
//					array.remove(array.size - 1)
//				})
//				.create()
//				.show()
//	}
//
//	private fun initView(): View {
//		val inflater = activity.layoutInflater
//		val view = inflater.inflate(R.layout.layout_polygon_annotation, null)
//
//		view.layout_polygon_annotation_width.text.replace(0, view.layout_polygon_annotation_width.text.length, when (width) { 0f -> ""
//			else -> width.toString()
//		})
//		view.layout_polygon_annotation_height.text.replace(0, view.layout_polygon_annotation_height.text.length, when (width) { 0f -> ""
//			else -> width.toString()
//		})
//		view.layout_polygon_annotation_surface.text.replace(0, view.layout_polygon_annotation_surface.text.length, when (surface) { 0f -> ""
//			else -> surface.toString()
//		})
//		view.layout_polygon_annotation_comment.text.replace(0, view.layout_polygon_annotation_comment.text.length, comment)
//
//		view.layout_polygon_annotation_width.addTextChangedListener(object : TextWatcher {
//			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//			override fun afterTextChanged(s: Editable?) {
//				if (!s.isNullOrEmpty()) {
//					width = s.toString().toFloat()
//					recalculateSurface(view)
//				} else {
//					width = 0f
//				}
//			}
//		})
//
//		view.layout_polygon_annotation_height.addTextChangedListener(object : TextWatcher {
//			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//			override fun afterTextChanged(s: Editable?) {
//				if (!s.isNullOrEmpty()) {
//					height = s.toString().toFloat()
//					recalculateSurface(view)
//				} else {
//					height = 0f
//				}
//			}
//		})
//
//		view.layout_polygon_annotation_surface.addTextChangedListener(object : TextWatcher {
//			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//			override fun afterTextChanged(s: Editable?) {
//				surface = s.toString().toFloat()
//				if (!is_recalculating) {
//					view.layout_polygon_annotation_height.text.replace(0, view.layout_polygon_annotation_height.text.length, "")
//					view.layout_polygon_annotation_width.text.replace(0, view.layout_polygon_annotation_width.text.length, "")
//				} else {
//					is_recalculating = false
//				}
//			}
//		})
//
//		view.layout_polygon_annotation_comment.addTextChangedListener(object : TextWatcher {
//			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//			override fun afterTextChanged(s: Editable?) {
//				comment = s.toString()
//			}
//		})
//		return view
//	}
//
//	private fun recalculateSurface(view: View) {
//		var width = view.layout_polygon_annotation_width.text.toString()
//		var height = view.layout_polygon_annotation_height.text.toString()
//		val text = view.layout_polygon_annotation_surface.text
//
//		if (!width.isEmpty() && !height.isEmpty()) {
//			surface = width.toFloat() * height.toFloat()
//			is_recalculating = true
//			text.replace(0, text.length, surface.toString())
//		}
//	}
//}