package net.noparking.projects.database.image


import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface ImageDataDao {
    @Query("SELECT * from images")
    fun getAll(): LiveData<List<Image>>

    @Query("SELECT * from images WHERE id = :id")
    fun getById(id: Long): LiveData<Image>

    @Query("SELECT * FROM images WHERE project_id = :id")
    fun getByProjectId(id: Long): LiveData<List<Image>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ImageData: Image): Long

    @Query("DELETE FROM images WHERE id = :id")
    fun deleteById(id: Long)

    @Query("DELETE from images")
    fun deleteAll()
}
