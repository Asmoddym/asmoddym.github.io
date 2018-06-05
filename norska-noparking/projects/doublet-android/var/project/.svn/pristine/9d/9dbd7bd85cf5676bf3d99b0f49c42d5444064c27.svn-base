package net.noparking.projects.utl

import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_image_name_picker.view.*
import net.noparking.projects.R
import net.noparking.projects.database.image.Image
import net.noparking.projects.database.image.ImagesCollector

class ImageNamePicker(internal val activity: AppCompatActivity, internal val project_id: Long) {
    private val _images_list = ImagesCollector().init(activity.baseContext).getByProjectId(project_id)
    private var _positive_action: ((String, Boolean) -> Unit)? = null
    private val _view = activity.layoutInflater.inflate(R.layout.layout_image_name_picker, null)

    init {
        _images_list.observe(activity, Observer {
            initPicker()
        })
    }

    fun setDefaultInput(s: String): ImageNamePicker {
        _view.layout_image_name_picker_input.text.replace(0, _view.layout_image_name_picker_input.text.length, s)
        return this
    }

    fun setOnPositiveAction(f: (String, Boolean) -> Unit): ImageNamePicker {
        _positive_action = f
        return this
    }

    private fun initPicker() {
        _view.layout_image_name_picker_input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                _view.layout_image_name_picker_name_already_taken.visibility = when (findImageNameInList(s.toString(), _images_list.value)) {
                    true -> View.VISIBLE
                    false -> View.INVISIBLE
                }
            }
        })
    }

    fun show() {
        val picker = AlertDialog.Builder(activity)
        picker.setView(_view)
                .setOnDismissListener {
                    if (_view.parent != null) {
                        (_view.parent as ViewGroup).removeView(_view)
                    }
                }
                .setTitle(activity.getString(R.string.choose_an_image_name))
                .setPositiveButton(activity.getString(R.string.ok), { _, _ ->
                    if (_positive_action != null) {
                        _positive_action?.invoke(_view.layout_image_name_picker_input.text.toString(),
                                findImageNameInList(_view.layout_image_name_picker_input.text.toString(), _images_list.value))
                    }
                })
                .setNegativeButton(activity.getString(R.string.cancel), { _, _ ->
                })
                .create()
                .show()
    }

    private fun findImageNameInList(name: String, list: List<Image>?): Boolean {
        list?.forEach {
            if (it.image_name == name) {
                return true
            }
        }
        return false
    }
}