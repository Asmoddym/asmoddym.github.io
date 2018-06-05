package net.noparking.projects.database.line

import android.content.Context
import android.os.AsyncTask

class LineAsyncDelete : AsyncTask<Void, Void, Void>() {
	private var _items_database: LineDatabase? = null
	private var _func: (() -> Unit)? = null
	private var _polygon_id: Long? = null
	private var _image_id: Long? = null
	private var _id: Long? = null

	fun init(context: Context): LineAsyncDelete {
		_items_database = LineDatabase.getInstance(context)
		return this
	}

	override fun doInBackground(vararg params: Void): Void? {
		if (_id != null) {
			_items_database?.LineDataDao()?.deleteById(_id!!)
		} else if (_image_id != null) {
			_items_database?.LineDataDao()?.deleteByImageId(_image_id!!)
		} else if (_polygon_id != null) {
			_items_database?.LineDataDao()?.deleteByPolygonId(_polygon_id!!)
		} else {
			_items_database?.LineDataDao()?.deleteAll()
		}
		return null
	}

	fun deleteByImageId(id: Long): LineAsyncDelete {
		_image_id = id
		return this
	}

	fun deleteById(id: Long): LineAsyncDelete {
		_id = id
		return this
	}

	fun deleteByPolygonId(id: Long): LineAsyncDelete {
		_polygon_id = id
		return this
	}

	fun afterQuery(func: () -> Unit): LineAsyncDelete {
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