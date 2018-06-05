package net.noparking.projects.database.polygon;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\nH\'\u00a8\u0006\u0011"}, d2 = {"Lnet/noparking/projects/database/polygon/PolygonDataDao;", "", "deleteAll", "", "deleteByImageId", "id", "", "getAll", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/polygon/Polygon;", "getById", "getByImageId", "insert", "PolygonData", "update", "", "app_release"})
public abstract interface PolygonDataDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * from polygons")
    public abstract android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.polygon.Polygon>> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * from polygons WHERE id = :id")
    public abstract android.arch.lifecycle.LiveData<net.noparking.projects.database.polygon.Polygon> getById(long id);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM polygons WHERE image_id = :id")
    public abstract android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.polygon.Polygon>> getByImageId(long id);
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.polygon.Polygon PolygonData);
    
    @android.arch.persistence.room.Update()
    public abstract int update(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.polygon.Polygon PolygonData);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM polygons WHERE image_id = :id")
    public abstract void deleteByImageId(long id);
    
    @android.arch.persistence.room.Query(value = "DELETE from polygons")
    public abstract void deleteAll();
}