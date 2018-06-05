package net.noparking.projects.database.project

import android.arch.persistence.room.*
import android.graphics.Color

@Entity(tableName = "projects")
data class Project(@PrimaryKey(autoGenerate = true) var id: Long?,
                   @ColumnInfo(name = "project_name") var project_name: String,
                   @ColumnInfo(name = "directory") var directory: String,
				   @ColumnInfo(name = "color") var color: Int) {
    constructor():this(null,"", "", Color.TRANSPARENT)
}