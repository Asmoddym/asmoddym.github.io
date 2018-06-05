package net.noparking.projects.database.polygon


import android.arch.persistence.room.*
import android.content.Context

@Database(entities = arrayOf(Polygon::class), version = 4)
abstract class PolygonDatabase : RoomDatabase() {

	abstract fun PolygonDataDao(): PolygonDataDao

	companion object {
		private var INSTANCE: PolygonDatabase? = null

		fun getInstance(context: Context): PolygonDatabase? {
			if (INSTANCE == null) {
				synchronized(PolygonDatabase::class) {
					INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
							PolygonDatabase::class.java, "polygons.db")
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