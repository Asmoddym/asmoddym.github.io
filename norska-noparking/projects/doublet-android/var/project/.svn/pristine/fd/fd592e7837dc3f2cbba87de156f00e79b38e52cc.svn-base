package net.noparking.projects.database.line


import android.arch.lifecycle.LiveData
import android.content.Context

class LinesCollector {
	var _items_database: LineDatabase? = null

	fun init(context: Context): LinesCollector {
		_items_database = LineDatabase.getInstance(context)
		return this
	}

	fun add(item: Line) {
		_items_database?.LineDataDao()?.insert(item)
	}

	fun getAll(): LiveData<List<Line>> {
		return _items_database!!.LineDataDao().getAll()
	}

	fun getByPolygonId(id: Long): LiveData<List<Line>> {
		return _items_database!!.LineDataDao().getByPolygonId(id)
	}

	fun getById(id: Long): LiveData<Line> {
		return _items_database!!.LineDataDao().getById(id)
	}

	fun getByImageId(id: Long): LiveData<List<Line>> {
		return _items_database!!.LineDataDao().getByImageId(id)
	}

	fun stop() {
		LineDatabase.destroyInstance()
	}
}