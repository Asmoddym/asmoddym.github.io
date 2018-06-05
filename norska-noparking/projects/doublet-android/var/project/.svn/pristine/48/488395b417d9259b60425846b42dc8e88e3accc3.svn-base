package net.noparking.projects.database.line_annotation

import android.content.Context
import android.os.AsyncTask

class LineAnnotationAsyncDelete : AsyncTask<Void, Void, Void>() {
	private var _items_database: LineAnnotationDatabase? = null
	private var _func: (() -> Unit)? = null
	private var _id: Long? = null
	private var _image_id: Long? = null

	fun init(context: Context): LineAnnotationAsyncDelete {
		_items_database = LineAnnotationDatabase.getInstance(context)
		return this
	}

	override fun doInBackground(vararg params: Void): Void? {
		if (_id != null) {
			_items_database?.LineAnnotationDataDao()?.deleteById(_id!!)
		} else if (_image_id != null) {
			_items_database?.LineAnnotationDataDao()?.deleteByImageId(_image_id!!)
		} else {
			_items_database?.LineAnnotationDataDao()?.deleteAll()
		}
		return null
	}

	fun deleteById(id: Long): LineAnnotationAsyncDelete {
		_id = id
		return this
	}

	fun deleteByImageId(id: Long): LineAnnotationAsyncDelete {
		_image_id = id
		return this
	}

	fun afterQuery(func: () -> Unit): LineAnnotationAsyncDelete {
		_func = func
		return this
	}

	override fun onPostExecute(result: Void?) {
		super.onPostExecute(result)
		if (_func != null) {
			_func?.invoke()
			_func = null
		}
	}
}