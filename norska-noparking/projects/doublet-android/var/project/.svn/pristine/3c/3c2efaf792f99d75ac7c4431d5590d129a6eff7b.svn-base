package net.noparking.projects.database.line

import android.content.Context
import android.os.AsyncTask

class LineAsyncInsert : AsyncTask<Line, Long, Long>() {
    private var _items_database: LineDatabase? = null
    private var _func: ((Long?) -> Unit)? = null

    fun init(context: Context): LineAsyncInsert {
        _items_database = LineDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Line): Long? {
        return _items_database?.LineDataDao()?.insert(params[0])
    }

    fun afterQuery(func: (Long?) -> Unit): LineAsyncInsert {
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