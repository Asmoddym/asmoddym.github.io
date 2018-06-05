package net.noparking.projects.database.polygon

import android.arch.persistence.room.*

@Entity(tableName = "polygons")
data class Polygon(@PrimaryKey(autoGenerate = true) var id: Long?,
                   @ColumnInfo(name = "image_id") var image_id: Long,
                   @ColumnInfo(name = "closed") var closed: Boolean) {
    constructor():this(null, 0, false)
}