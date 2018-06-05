package net.noparking.projects.database.image

import android.content.Context
import android.os.AsyncTask
import android.util.Log

class ImageAsyncDelete : AsyncTask<Void, Void, Void>() {
    private var _items_database: ImageDatabase? = null
    private var _func: (() -> Unit)? = null
    private var _id: Long? = null

    fun init(context: Context): ImageAsyncDelete {
        _items_database = ImageDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Void): Void? {
        if (_id == null) {
            _items_database?.ImageDataDao()?.deleteAll()
        } else {
            _items_database?.ImageDataDao()?.deleteById(_id!!)
        }
        return null
    }

    fun deleteById(id: Long): ImageAsyncDelete {
        _id = id
        return this
    }

    fun afterQuery(func: () -> Unit): ImageAsyncDelete {
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