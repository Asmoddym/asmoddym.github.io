package net.noparking.projects.database.project


import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface ProjectDataDao {
    @Query("SELECT * from projects")
    fun getAll(): LiveData<List<Project>>

    @Query("SELECT * from projects WHERE id = :id")
    fun getById(id: Long): LiveData<Project>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ProjectData: Project): Long

    @Query("DELETE from projects")
    fun deleteAll()

    @Query("DELETE FROM projects WHERE id = :id")
    fun deleteById(id: Long)
}
