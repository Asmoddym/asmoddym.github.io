package net.noparking.projects.utl

import android.graphics.Color
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_project_item_parametring.view.*
import net.noparking.projects.R
import petrov.kristiyan.colorpicker.ColorPicker

class ProjectItemParametring(internal val activity: AppCompatActivity) {
	private val _view = activity.layoutInflater.inflate(R.layout.layout_project_item_parametring, null)
	private var _positive_action: ((String, Int) -> Unit)? = null
	private var _negative_action: (() -> Unit)? = null
	private var _color: Int = Color.TRANSPARENT
	private var _comparison_method: ((String) -> Boolean)? = null
	private var _negative_confirmation = true
	private var _allow_empty = false
	private var _default_input = ""

	fun setDefaultInput(str: String): ProjectItemParametring {
		_default_input = str
		_view.layout_project_item_parametring_input.text.replace(0, _view.layout_project_item_parametring_input.text.length, str)
		return this
	}

	fun disableNegativeLabelConfirmation(): ProjectItemParametring {
		_negative_confirmation = false
		return this
	}

	fun setPositiveLabel(str: String): ProjectItemParametring {
		_view.layout_project_item_parametring_positive_button.text = str
		return this
	}

	fun setNegativeLabel(str: String): ProjectItemParametring {
		_view.layout_project_item_parametring_negative_button.text = str
		return this
	}

	fun setHint(str: String): ProjectItemParametring {
		_view.layout_project_item_parametring_input.hint = str
		return this
	}

	fun setDefaultColor(color: Int): ProjectItemParametring {
		_color = color
		_view.layout_project_item_parametring_pick_color.setBackgroundColor(_color)
		return this
	}

	fun setPositiveAction(f: (name: String, color: Int) -> Unit): ProjectItemParametring {
		_positive_action = f
		return this
	}

	fun setNegativeAction(f: () -> Unit): ProjectItemParametring {
		_negative_action = f
		return this
	}

	fun allowEmptyInput(): ProjectItemParametring {
		_allow_empty = true
		return this
	}

	fun setComparisonMethod(f: (input: String) -> Boolean): ProjectItemParametring {
		_comparison_method = f
		return this
	}

	fun show() {
		val picker = AlertDialog.Builder(activity)
				.setView(_view)
				.setOnDismissListener {
					if (_view.parent != null) {
						(_view.parent as ViewGroup).removeView(_view)
					}
				}
				.create()

		_view.layout_project_item_parametring_pick_color.setOnClickListener {
			val colorPicker = ColorPicker(activity)
			colorPicker.setTitle(activity.getString(R.string.choose_a_color))
			colorPicker.setOnFastChooseColorListener(object : ColorPicker.OnFastChooseColorListener {
				override fun setOnFastChooseColorListener(position: Int, color: Int) {
					_color = color
					_view.layout_project_item_parametring_pick_color.setBackgroundColor(_color)
				}
				override fun onCancel() {}
			}).show()
		}

		if (_negative_action != null) {
			_view.layout_project_item_parametring_negative_button.setOnClickListener {
				picker.dismiss()
				if (_negative_confirmation) {
					AlertDialog.Builder(activity)
							.setTitle(activity.getString(R.string.confirm_the_deletion))
							.setPositiveButton(activity.getString(R.string.confirm), { _, _ ->
								_negative_action?.invoke()
							})
							.setNegativeButton(activity.getString(R.string.cancel), { _, _ -> })
							.show()
				} else {
					_negative_action?.invoke()
				}
			}
		}

		if (_positive_action != null) {
			_view.layout_project_item_parametring_positive_button.setOnClickListener {
				picker.dismiss()
				_positive_action?.invoke(_view.layout_project_item_parametring_input.text.toString(), _color)
			}
		}

		_view.layout_project_item_parametring_input.addTextChangedListener(object : TextWatcher {
			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
			override fun afterTextChanged(s: Editable?) {
				val comparison =  when (_comparison_method) {
					null -> false
					else -> when (s.toString() == _default_input) {
						true -> false
						else -> _comparison_method?.invoke(s.toString())
					}
				}
				_view.layout_project_item_parametring_name_already_taken.visibility = when (comparison) { true -> View.VISIBLE else -> View.INVISIBLE}

				if (s.isNullOrEmpty()) {
					_view.layout_project_item_parametring_positive_button.isClickable = _allow_empty
					_view.layout_project_item_parametring_positive_button.alpha = when (_allow_empty) { true -> 1f else -> 0.3f }
				} else {
					_view.layout_project_item_parametring_positive_button.isClickable = !comparison!!
					_view.layout_project_item_parametring_positive_button.alpha = when (comparison) { true -> 0.3f else -> 1f }
				}
			}
		})

		if (_default_input.isEmpty() && !_allow_empty) {
			_view.layout_project_item_parametring_positive_button.isClickable = false
			_view.layout_project_item_parametring_positive_button.alpha = 0.3f
		}

		picker.show()
	}
}