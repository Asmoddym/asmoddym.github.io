package net.noparking.projects.database.line

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface LineDataDao {
    @Query("SELECT * from lines")
    fun getAll(): LiveData<List<Line>>

    @Query("SELECT * from lines WHERE id = :id")
    fun getById(id: Long): LiveData<Line>

    @Query("SELECT * FROM lines WHERE polygon_id = :id")
    fun getByPolygonId(id: Long): LiveData<List<Line>>

    @Query("SELECT * FROM lines WHERE image_id = :id")
    fun getByImageId(id: Long): LiveData<List<Line>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(LineData: Line): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(LineData: Line): Int

	@Query("DELETE FROM lines WHERE id = :id")
	fun deleteById(id: Long)

    @Query("DELETE FROM lines WHERE polygon_id = :id")
	fun deleteByPolygonId(id: Long)

    @Query("DELETE FROM lines WHERE image_id = :id")
    fun deleteByImageId(id: Long)

    @Query("DELETE from lines")
    fun deleteAll()
}
