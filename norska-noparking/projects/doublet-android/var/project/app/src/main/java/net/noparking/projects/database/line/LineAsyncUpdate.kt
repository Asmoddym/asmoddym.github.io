package net.noparking.projects.database.line

import android.content.Context
import android.os.AsyncTask

class LineAsyncUpdate: AsyncTask<Line, Int, Int>() {
    private var _items_database: LineDatabase? = null
    private var _func: ((Int?) -> Unit)? = null

    fun init(context: Context): LineAsyncUpdate {
        _items_database = LineDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Line): Int? {
        return _items_database?.LineDataDao()?.update(params[0])
    }

    fun afterQuery(func: (Int?) -> Unit): LineAsyncUpdate {
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