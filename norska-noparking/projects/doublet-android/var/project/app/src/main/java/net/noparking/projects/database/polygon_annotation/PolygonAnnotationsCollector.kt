package net.noparking.projects.database.polygon_annotation

import android.arch.lifecycle.LiveData
import android.content.Context

class PolygonAnnotationsCollector {
    var _items_database: PolygonAnnotationDatabase? = null

    fun init(context: Context): PolygonAnnotationsCollector {
        _items_database = PolygonAnnotationDatabase.getInstance(context)
        return this
    }

    fun add(item: PolygonAnnotation) {
        _items_database?.PolygonAnnotationDataDao()?.insert(item)
    }

    fun getAll(): LiveData<List<PolygonAnnotation>> {
        return _items_database!!.PolygonAnnotationDataDao().getAll()
    }

    fun getByPolygonId(id: Long): LiveData<PolygonAnnotation> {
        return _items_database!!.PolygonAnnotationDataDao().getByPolygonId(id)
    }

    fun getById(id: Long): LiveData<PolygonAnnotation> {
        return _items_database!!.PolygonAnnotationDataDao().getById(id)
    }

    fun stop() {
        PolygonAnnotationDatabase.destroyInstance()
    }
}