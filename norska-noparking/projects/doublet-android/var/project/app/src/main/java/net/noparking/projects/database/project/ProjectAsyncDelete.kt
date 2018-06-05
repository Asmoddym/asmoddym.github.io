package net.noparking.projects.database.project

import android.content.Context
import android.os.AsyncTask
import android.util.Log

class ProjectAsyncDelete : AsyncTask<Void, Void, Void>() {
    private var _items_database: ProjectDatabase? = null
    private var _func: (() -> Unit)? = null
    private var _id: Long? = null

    fun init(context: Context): ProjectAsyncDelete {
        _items_database = ProjectDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Void): Void? {
        if (_id == null) {
            _items_database?.ProjectDataDao()?.deleteAll()
        } else {
            _items_database?.ProjectDataDao()?.deleteById(_id!!)
        }
        return null
    }

    fun deleteById(id: Long): ProjectAsyncDelete {
        _id = id
        return this
    }

    fun afterQuery(func: () -> Unit): ProjectAsyncDelete {
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