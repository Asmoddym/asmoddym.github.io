package net.noparking.projects.utl

import android.content.Context
import android.os.AsyncTask
import net.noparking.projects.database.image.Image

class AsyncZipper : AsyncTask<(List<Image>?) -> Unit, Void, Void>() {
	private var _list: List<Image>? = null

	fun init(context: Context, list: List<Image>?): AsyncZipper {
		_list = list
		return this
	}

	override fun doInBackground(vararg params: (list: List<Image>?) -> Unit): Void? {
		if (_list != null) {
			params[0].invoke(_list)
		}
		return null
	}

	override fun onPostExecute(result: Void) {
		super.onPostExecute(result)
	}
}