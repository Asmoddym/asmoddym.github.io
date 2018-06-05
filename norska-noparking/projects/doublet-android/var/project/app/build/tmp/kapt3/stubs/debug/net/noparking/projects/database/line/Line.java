package net.noparking.projects.database.line;

import java.lang.System;

@android.arch.persistence.room.Entity(tableName = "lines")
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002BG\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u0010)\u001a\u00020\u0004H\u00c6\u0003J\t\u0010*\u001a\u00020\u0004H\u00c6\u0003J\t\u0010+\u001a\u00020\bH\u00c6\u0003J\t\u0010,\u001a\u00020\bH\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\t\u0010.\u001a\u00020\bH\u00c6\u0003J\t\u0010/\u001a\u00020\rH\u00c6\u0003J`\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001\u00a2\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u00020\rH\u00d6\u0001J\t\u00106\u001a\u000207H\u00d6\u0001R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001e\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001e\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b\'\u0010\u0016\u00a8\u00068"}, d2 = {"Lnet/noparking/projects/database/line/Line;", "", "()V", "id", "", "polygon_id", "image_id", "from_x", "", "from_y", "to_x", "to_y", "color", "", "(Ljava/lang/Long;JJFFFFI)V", "getColor", "()I", "setColor", "(I)V", "getFrom_x", "()F", "setFrom_x", "(F)V", "getFrom_y", "setFrom_y", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getImage_id", "()J", "setImage_id", "(J)V", "getPolygon_id", "setPolygon_id", "getTo_x", "setTo_x", "getTo_y", "setTo_y", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;JJFFFFI)Lnet/noparking/projects/database/line/Line;", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class Line {
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.PrimaryKey(autoGenerate = true)
    private java.lang.Long id;
    @android.arch.persistence.room.ColumnInfo(name = "polygon_id")
    private long polygon_id;
    @android.arch.persistence.room.ColumnInfo(name = "image_id")
    private long image_id;
    @android.arch.persistence.room.ColumnInfo(name = "from_x")
    private float from_x;
    @android.arch.persistence.room.ColumnInfo(name = "from_y")
    private float from_y;
    @android.arch.persistence.room.ColumnInfo(name = "to_x")
    private float to_x;
    @android.arch.persistence.room.ColumnInfo(name = "to_y")
    private float to_y;
    @android.arch.persistence.room.ColumnInfo(name = "color")
    private int color;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    public final long getPolygon_id() {
        return 0L;
    }
    
    public final void setPolygon_id(long p0) {
    }
    
    public final long getImage_id() {
        return 0L;
    }
    
    public final void setImage_id(long p0) {
    }
    
    public final float getFrom_x() {
        return 0.0F;
    }
    
    public final void setFrom_x(float p0) {
    }
    
    public final float getFrom_y() {
        return 0.0F;
    }
    
    public final void setFrom_y(float p0) {
    }
    
    public final float getTo_x() {
        return 0.0F;
    }
    
    public final void setTo_x(float p0) {
    }
    
    public final float getTo_y() {
        return 0.0F;
    }
    
    public final void setTo_y(float p0) {
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int p0) {
    }
    
    public Line(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long polygon_id, long image_id, float from_x, float from_y, float to_x, float to_y, int color) {
        super();
    }
    
    public Line() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    public final float component6() {
        return 0.0F;
    }
    
    public final float component7() {
        return 0.0F;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line.Line copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long polygon_id, long image_id, float from_x, float from_y, float to_x, float to_y, int color) {
        return null;
    }
    
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(java.lang.Object p0) {
        return false;
    }
}