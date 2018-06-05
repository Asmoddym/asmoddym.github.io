package net.noparking.projects.database.image

import android.content.Context
import android.os.AsyncTask

class ImageAsyncInsert : AsyncTask<Image, Long, Long>() {
    var _items_database: ImageDatabase? = null
    var _func: ((Long?) -> Unit)? = null

    fun init(context: Context): ImageAsyncInsert {
        _items_database = ImageDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Image): Long? {
        return _items_database?.ImageDataDao()?.insert(params[0])
    }

    fun afterQuery(func: (Long?) -> Unit): ImageAsyncInsert {
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