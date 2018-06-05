package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line

import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_line_annotation.view.*
import net.noparking.projects.R
import net.noparking.projects.database.line_annotation.LineAnnotation

class LineAnnotationPicker(internal val activity: AppCompatActivity) {
	private lateinit var _view: View
	private var _data: LineAnnotation? = null
	private var _on_positive: ((Long, Float?, String) -> Unit)? = null
	private var _on_negative: ((Long) -> Unit)? = null
	private var _confirmation_label: String = activity.getString(R.string.confirm_the_deletion)
	private var _confirmation = true
	private lateinit var _picker: AlertDialog

	private var _id: Long = 0.toLong()

	fun setData(data: LineAnnotation): LineAnnotationPicker {
		_data = data
		_id = when (data.id) {
			null -> 0
			else -> data.id!!
		}
		return this
	}

	fun setNegativeConfirmationLabel(str: String): LineAnnotationPicker {
		_confirmation_label = str
		return this
	}

	fun enableConfirmation(state: Boolean): LineAnnotationPicker {
		_confirmation = state
		return this
	}

	fun setPositiveAction(f: (id: Long, length: Float?, comment: String) -> Unit): LineAnnotationPicker {
		_on_positive = f
		return this
	}

	fun setNegativeAction(f: (id: Long) -> Unit): LineAnnotationPicker {
		_on_negative = f
		return this
	}

	fun setPositiveLabel(str: String): LineAnnotationPicker {
		_view.layout_line_annotation_positive.text = str
		return this
	}

	fun setNegativeLabel(str: String): LineAnnotationPicker {
		_view.layout_line_annotation_negative.text = str
		return this
	}

	fun init(): LineAnnotationPicker {
		_view = activity.layoutInflater.inflate(R.layout.layout_line_annotation, null)
		return this
	}

	fun show() {
		updateView()
		_picker = AlertDialog.Builder(activity)
				.setView(_view)
				.setOnDismissListener {
					if (_view.parent != null) {
						(_view.parent as ViewGroup).removeView(_view)
					}
				}
				.setTitle(activity.getString(R.string.handle_annotations))
				.create()
		_picker.show()
	}

	private fun updateView() {
		if (_data != null && _data?.length != null) {
			_view.layout_line_annotation_length.text.replace(0, _view.layout_line_annotation_length.text.length, _data?.length!!.toString())
		}
		_view.layout_line_annotation_comment.text.replace(0, _view.layout_line_annotation_comment.text.length, _data?.comment)

		_view.layout_line_annotation_positive.setOnClickListener {
			if (_on_positive != null) {
				if (_data != null) {
					_on_positive!!.invoke(_id,
							_view.layout_line_annotation_length.text.toString().toFloatOrNull(),
							_view.layout_line_annotation_comment.text.toString())
				}
			}
			_picker.dismiss()
		}


		_view.layout_line_annotation_negative.setOnClickListener {
			if (_confirmation) {
				if (_on_negative != null) {
					AlertDialog.Builder(activity)
							.setTitle(_confirmation_label)
							.setPositiveButton(activity.getString(R.string.confirm), { _, _ ->
								_on_negative!!.invoke(_id)
							})
							.setNegativeButton(activity.getString(R.string.cancel), { _, _ -> })
							.show()
				} else {
					_on_negative!!.invoke(_id)
				}
			}
			_picker.dismiss()
		}
	}
}