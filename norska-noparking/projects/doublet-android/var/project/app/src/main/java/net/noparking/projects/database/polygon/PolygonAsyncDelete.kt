package net.noparking.projects.database.polygon

import android.content.Context
import android.os.AsyncTask
import android.util.Log

class PolygonAsyncDelete : AsyncTask<Void, Void, Void>() {
    private var _items_database: PolygonDatabase? = null
    private var _func: (() -> Unit)? = null
    private var _image_id: Long? = null

    fun init(context: Context): PolygonAsyncDelete {
        _items_database = PolygonDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Void): Void? {
        if (_image_id == null) {
            _items_database?.PolygonDataDao()?.deleteAll()
        } else {
            _items_database?.PolygonDataDao()?.deleteByImageId(_image_id!!)
        }
        return null
    }

    fun deleteByImageId(id: Long): PolygonAsyncDelete {
        _image_id = id
        return this
    }

    fun afterQuery(func: () -> Unit): PolygonAsyncDelete {
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