package net.noparking.projects.database.line_annotation

import android.content.Context
import android.os.AsyncTask

class LineAnnotationAsyncInsert : AsyncTask<LineAnnotation, Long, Long>() {
    var _items_database: LineAnnotationDatabase? = null
    var _func: ((Long?) -> Unit)? = null

    fun init(context: Context): LineAnnotationAsyncInsert {
        _items_database = LineAnnotationDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: LineAnnotation): Long? {
        return _items_database?.LineAnnotationDataDao()?.insert(params[0])
    }

    fun afterQuery(func: (Long?) -> Unit): LineAnnotationAsyncInsert {
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