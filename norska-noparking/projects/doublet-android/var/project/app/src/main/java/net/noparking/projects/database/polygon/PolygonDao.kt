package net.noparking.projects.database.polygon

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface PolygonDataDao {
    @Query("SELECT * from polygons")
    fun getAll(): LiveData<List<Polygon>>

    @Query("SELECT * from polygons WHERE id = :id")
    fun getById(id: Long): LiveData<Polygon>

    @Query("SELECT * FROM polygons WHERE image_id = :id")
    fun getByImageId(id: Long): LiveData<List<Polygon>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(PolygonData: Polygon): Long

    @Update
    fun update(PolygonData: Polygon): Int

    @Query("DELETE FROM polygons WHERE image_id = :id")
    fun deleteByImageId(id: Long)

    @Query("DELETE from polygons")
    fun deleteAll()
}
