package net.noparking.projects.database.polygon

import android.content.Context
import android.os.AsyncTask

class PolygonAsyncInsert : AsyncTask<Polygon, Long, Long>() {
    private var _items_database: PolygonDatabase? = null
    private var _func: ((Long?) -> Unit)? = null

    fun init(context: Context): PolygonAsyncInsert {
        _items_database = PolygonDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Polygon): Long? {
        return _items_database?.PolygonDataDao()?.insert(params[0])
    }

    fun afterQuery(func: (Long?) -> Unit): PolygonAsyncInsert {
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