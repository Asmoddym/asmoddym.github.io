package net.noparking.projects.database.project


import android.arch.lifecycle.LiveData
import android.content.Context

class ProjectsCollector {
    var _items_database: ProjectDatabase? = null

    fun init(context: Context): ProjectsCollector {
        _items_database = ProjectDatabase.getInstance(context)
        return this
    }

    fun add(item: Project) {
        _items_database?.ProjectDataDao()?.insert(item)
    }

    fun getAll(): LiveData<List<Project>> {
        return _items_database!!.ProjectDataDao().getAll()
    }

    fun getById(id: Long): LiveData<Project> {
        return _items_database!!.ProjectDataDao().getById(id)
    }

    fun stop() {
        ProjectDatabase.destroyInstance()
    }
}