package net.noparking.projects.database.line_annotation

import android.arch.persistence.room.*
import android.content.Context

@Database(entities = arrayOf(LineAnnotation::class), version = 1)
abstract class LineAnnotationDatabase : RoomDatabase() {

    abstract fun LineAnnotationDataDao(): LineAnnotationDataDao

    companion object {
        private var INSTANCE: LineAnnotationDatabase? = null

        fun getInstance(context: Context): LineAnnotationDatabase? {
            if (INSTANCE == null) {
                synchronized(LineAnnotationDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LineAnnotationDatabase::class.java, "line_annotations.db")
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
