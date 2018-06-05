package net.noparking.projects.database.project

import android.arch.lifecycle.LiveData
import android.content.Context
import android.os.AsyncTask

class ProjectAsyncInsert : AsyncTask<Project, Long, Long>() {
    var _items_database: ProjectDatabase? = null
    var _func: ((Long?) -> Unit)? = null

    fun init(context: Context): ProjectAsyncInsert {
        _items_database = ProjectDatabase.getInstance(context)
        return this
    }

    override fun doInBackground(vararg params: Project): Long? {
        return _items_database?.ProjectDataDao()?.insert(params[0])
    }

    fun afterQuery(func: (Long?) -> Unit): ProjectAsyncInsert {
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