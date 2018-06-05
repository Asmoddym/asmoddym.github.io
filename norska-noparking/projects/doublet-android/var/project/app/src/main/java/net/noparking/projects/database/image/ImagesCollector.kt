package net.noparking.projects.database.image


import android.arch.lifecycle.LiveData
import android.content.Context

class ImagesCollector {
    var _items_database: ImageDatabase? = null

    fun init(context: Context): ImagesCollector {
        _items_database = ImageDatabase.getInstance(context)
        return this
    }

    fun add(item: Image) {
        _items_database?.ImageDataDao()?.insert(item)
    }

    fun getAll(): LiveData<List<Image>> {
        return _items_database!!.ImageDataDao().getAll()
    }

    fun getByProjectId(id: Long): LiveData<List<Image>> {
        return _items_database!!.ImageDataDao().getByProjectId(id)
    }

    fun getById(id: Long): LiveData<Image> {
        return _items_database!!.ImageDataDao().getById(id)
    }

    fun stop() {
        ImageDatabase.destroyInstance()
    }
}