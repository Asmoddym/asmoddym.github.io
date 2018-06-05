package net.noparking.projects.database.polygon


import android.arch.lifecycle.LiveData
import android.content.Context

class PolygonsCollector {
    var _items_database: PolygonDatabase? = null

    fun init(context: Context): PolygonsCollector {
        _items_database = PolygonDatabase.getInstance(context)
        return this
    }

    fun add(item: Polygon) {
        _items_database?.PolygonDataDao()?.insert(item)
    }

    fun getAll(): LiveData<List<Polygon>> {
        return _items_database!!.PolygonDataDao().getAll()
    }

    fun getById(id: Long): LiveData<Polygon> {
        return _items_database!!.PolygonDataDao().getById(id)
    }

    fun getByImageId(id: Long): LiveData<List<Polygon>> {
        return _items_database!!.PolygonDataDao().getByImageId(id)
    }

    fun deleteAll() {
        _items_database!!.PolygonDataDao().deleteAll()
    }

    fun stop() {
        PolygonDatabase.destroyInstance()
    }
}