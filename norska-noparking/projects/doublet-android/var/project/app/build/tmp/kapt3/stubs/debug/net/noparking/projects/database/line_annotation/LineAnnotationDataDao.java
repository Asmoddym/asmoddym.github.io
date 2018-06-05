package net.noparking.projects.database.line_annotation;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000bH\'\u00a8\u0006\u0011"}, d2 = {"Lnet/noparking/projects/database/line_annotation/LineAnnotationDataDao;", "", "deleteAll", "", "deleteById", "id", "", "deleteByImageId", "getAll", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/line_annotation/LineAnnotation;", "getById", "getByImageId", "getByLineId", "insert", "AnnotationData", "app_debug"})
public abstract interface LineAnnotationDataDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * from line_annotations")
    public abstract android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.line_annotation.LineAnnotation>> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM line_annotations WHERE id = :id")
    public abstract android.arch.lifecycle.LiveData<net.noparking.projects.database.line_annotation.LineAnnotation> getById(long id);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM line_annotations WHERE image_id = :id")
    public abstract android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.line_annotation.LineAnnotation>> getByImageId(long id);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM line_annotations WHERE line_id = :id")
    public abstract android.arch.lifecycle.LiveData<net.noparking.projects.database.line_annotation.LineAnnotation> getByLineId(long id);
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line_annotation.LineAnnotation AnnotationData);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM line_annotations WHERE id = :id")
    public abstract void deleteById(long id);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM line_annotations WHERE image_id = :id")
    public abstract void deleteByImageId(long id);
    
    @android.arch.persistence.room.Query(value = "DELETE from line_annotations")
    public abstract void deleteAll();
}