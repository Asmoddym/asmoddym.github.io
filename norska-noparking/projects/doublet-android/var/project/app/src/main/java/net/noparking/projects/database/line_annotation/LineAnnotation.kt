package net.noparking.projects.database.line_annotation

import android.arch.persistence.room.*

@Entity(tableName = "line_annotations")
data class LineAnnotation(@PrimaryKey(autoGenerate = true) var id: Long?,
						  @ColumnInfo(name = "line_id") var line_id: Long,
						  @ColumnInfo(name = "image_id") var image_id: Long,
						  @ColumnInfo(name = "length") var length: Float?,
						  @ColumnInfo(name = "comment") var comment: String) {
	constructor() : this(null, 0, 0, null, "")
}