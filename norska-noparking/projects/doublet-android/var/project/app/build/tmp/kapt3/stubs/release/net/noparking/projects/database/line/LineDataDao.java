package net.noparking.projects.database.line;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\t\u001a\u00020\nH\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007H\'\u00a8\u0006\u0010"}, d2 = {"Lnet/noparking/projects/database/line/LineDataDao;", "", "deleteAll", "", "getAll", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/line/Line;", "getById", "id", "", "getByPolygonId", "insert", "LineData", "update", "", "app_release"})
public abstract interface LineDataDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * from lines")
    public abstract android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.line.Line>> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * from lines WHERE id = :id")
    public abstract android.arch.lifecycle.LiveData<net.noparking.projects.database.line.Line> getById(long id);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM lines WHERE polygon_id = :id")
    public abstract android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.line.Line>> getByPolygonId(long id);
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line.Line LineData);
    
    @android.arch.persistence.room.Update(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract int update(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line.Line LineData);
    
    @android.arch.persistence.room.Query(value = "DELETE from lines")
    public abstract void deleteAll();
}