package net.noparking.projects.database.line_annotation

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface LineAnnotationDataDao {
    @Query("SELECT * from line_annotations")
    fun getAll(): LiveData<List<LineAnnotation>>

    @Query("SELECT * FROM line_annotations WHERE id = :id")
    fun getById(id: Long): LiveData<LineAnnotation>

    @Query("SELECT * FROM line_annotations WHERE image_id = :id")
    fun getByImageId(id: Long): LiveData<List<LineAnnotation>>

    @Query("SELECT * FROM line_annotations WHERE line_id = :id")
    fun getByLineId(id: Long): LiveData<LineAnnotation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(AnnotationData: LineAnnotation): Long

    @Query("DELETE FROM line_annotations WHERE id = :id")
    fun deleteById(id: Long)

    @Query("DELETE FROM line_annotations WHERE image_id = :id")
    fun deleteByImageId(id: Long)

    @Query("DELETE from line_annotations")
    fun deleteAll()
}
