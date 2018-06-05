package net.noparking.projects.database.polygon

import android.content.Context
import android.os.AsyncTask

class PolygonAsyncUpdate: AsyncTask<Polygon, Int, Int>() {
    private var _items_database: PolygonDatabase? = null
    private var _func: ((Int?) -> Unit)? = null

    fun init(context: Context): PolygonAsyncUpdate {
        _items_database = PolygonDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Polygon): Int? {
        return _items_database?.PolygonDataDao()?.update(params[0])
    }

    fun afterQuery(func: (Int?) -> Unit): PolygonAsyncUpdate {
        _func = func
        return this
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        if (_func != null) {
            _func?.invoke(result)
            _func = null
        }
    }
}