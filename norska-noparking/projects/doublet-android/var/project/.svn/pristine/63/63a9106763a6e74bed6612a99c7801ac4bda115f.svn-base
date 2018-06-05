package net.noparking.projects.database.polygon_annotation

import android.content.Context
import android.os.AsyncTask

class PolygonAnnotationAsyncInsert : AsyncTask<PolygonAnnotation, Long, Long>() {
    var _items_database: PolygonAnnotationDatabase? = null
    var _func: ((Long?) -> Unit)? = null

    fun init(context: Context): PolygonAnnotationAsyncInsert {
        _items_database = PolygonAnnotationDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: PolygonAnnotation): Long? {
        return _items_database?.PolygonAnnotationDataDao()?.insert(params[0])
    }

    fun afterQuery(func: (Long?) -> Unit): PolygonAnnotationAsyncInsert {
        _func = func
        return this
    }

    override fun onPostExecute(result: Long?) {
        super.onPostExecute(result)
        if (_func != null) {
            _func?.invoke(result)
            _func = null
        }
    }
}