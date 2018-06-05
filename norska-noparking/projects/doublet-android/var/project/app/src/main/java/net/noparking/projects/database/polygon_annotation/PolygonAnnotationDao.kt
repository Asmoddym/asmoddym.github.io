package net.noparking.projects.database.polygon_annotation

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface PolygonAnnotationDataDao {
    @Query("SELECT * from polygon_annotations")
    fun getAll(): LiveData<List<PolygonAnnotation>>

    @Query("SELECT * from polygon_annotations WHERE id = :id")
    fun getById(id: Long): LiveData<PolygonAnnotation>

    @Query("SELECT * FROM polygon_annotations WHERE polygon_id = :id")
    fun getByPolygonId(id: Long): LiveData<PolygonAnnotation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(AnnotationData: PolygonAnnotation): Long

    @Query("DELETE FROM polygon_annotations WHERE polygon_id = :id")
    fun deleteByPolygonId(id: Long)

    @Query("DELETE FROM polygon_annotations WHERE image_id = :id")
    fun deleteByImageId(id: Long)

    @Query("DELETE from polygon_annotations")
    fun deleteAll()
}
