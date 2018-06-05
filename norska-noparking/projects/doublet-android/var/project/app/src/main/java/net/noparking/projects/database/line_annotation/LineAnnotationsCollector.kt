package net.noparking.projects.database.line_annotation

import android.arch.lifecycle.LiveData
import android.content.Context

class LineAnnotationsCollector {
	var _items_database: LineAnnotationDatabase? = null

	fun init(context: Context): LineAnnotationsCollector {
		_items_database = LineAnnotationDatabase.getInstance(context)
		return this
	}

	fun add(item: LineAnnotation) {
		_items_database?.LineAnnotationDataDao()?.insert(item)
	}

	fun getAll(): LiveData<List<LineAnnotation>> {
		return _items_database!!.LineAnnotationDataDao().getAll()
	}

	fun getByImageId(id: Long): LiveData<List<LineAnnotation>> {
		return _items_database!!.LineAnnotationDataDao().getByImageId(id)
	}

	fun getByLineId(id: Long): LiveData<LineAnnotation> {
		return _items_database!!.LineAnnotationDataDao().getByLineId(id)
	}

	fun getById(id: Long): LiveData<LineAnnotation> {
		return _items_database!!.LineAnnotationDataDao().getById(id)
	}

	fun stop() {
		LineAnnotationDatabase.destroyInstance()
	}
}