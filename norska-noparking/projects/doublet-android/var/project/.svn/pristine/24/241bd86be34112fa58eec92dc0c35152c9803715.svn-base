package net.noparking.projects.database.project


import android.arch.persistence.room.*
import android.content.Context

@Database(entities = arrayOf(Project::class), version = 6)
abstract class ProjectDatabase : RoomDatabase() {

    abstract fun ProjectDataDao(): ProjectDataDao

    companion object {
        private var INSTANCE: ProjectDatabase? = null

        fun getInstance(context: Context): ProjectDatabase? {
            if (INSTANCE == null) {
                synchronized(ProjectDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProjectDatabase::class.java, "projects.db")
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
