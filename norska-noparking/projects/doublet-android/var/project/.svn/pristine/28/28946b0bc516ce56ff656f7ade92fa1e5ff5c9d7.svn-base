package net.noparking.projects.database.line

import android.arch.persistence.room.*

@Entity(tableName = "lines")
data class Line(@PrimaryKey(autoGenerate = true) var id: Long?,
                @ColumnInfo(name = "polygon_id") var polygon_id: Long,
                @ColumnInfo(name = "image_id") var image_id: Long,
                @ColumnInfo(name = "from_x") var from_x: Float,
                @ColumnInfo(name = "from_y") var from_y: Float,
                @ColumnInfo(name = "to_x") var to_x: Float,
                @ColumnInfo(name = "to_y") var to_y: Float,
                @ColumnInfo(name = "color") var color: Int) {
    constructor():this(null, 0, 0, 0f, 0f, 0f, 0f, 0)
}