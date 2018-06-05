package net.noparking.projects.view.ImageEditionView.canvas.modes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010%\u001a\u00020&J\u0016\u0010\'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020&J\u0016\u0010,\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020&H\u0002J\u0006\u00101\u001a\u00020&J\u0016\u00102\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u00063"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/AnnotationsMode;", "", "context", "Landroid/content/Context;", "polygons", "", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/Polygon;", "image_id", "", "parent_activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/content/Context;Ljava/util/List;JLandroid/support/v7/app/AppCompatActivity;)V", "_bounds", "Landroid/graphics/RectF;", "_center", "Landroid/graphics/PointF;", "_paint", "Landroid/graphics/Paint;", "_picker", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/PolygonAnnotationPicker;", "_polygons_annotations", "", "Lnet/noparking/projects/database/polygon_annotation/PolygonAnnotation;", "clear_mode", "", "getClear_mode", "()Z", "setClear_mode", "(Z)V", "getContext$app_debug", "()Landroid/content/Context;", "getImage_id$app_debug", "()J", "getParent_activity$app_debug", "()Landroid/support/v7/app/AppCompatActivity;", "getPolygons$app_debug", "()Ljava/util/List;", "clear", "", "downTouch", "x", "", "y", "init", "moveTouch", "onDraw", "canvas", "Landroid/graphics/Canvas;", "retrieveFromDatabase", "save", "upTouch", "app_debug"})
public final class AnnotationsMode {
    private final java.util.Map<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon, net.noparking.projects.database.polygon_annotation.PolygonAnnotation> _polygons_annotations = null;
    private final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.PolygonAnnotationPicker _picker = null;
    private boolean clear_mode;
    private android.graphics.RectF _bounds;
    private android.graphics.PointF _center;
    private final android.graphics.Paint _paint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon> polygons = null;
    private final long image_id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity parent_activity = null;
    
    public final boolean getClear_mode() {
        return false;
    }
    
    public final void setClear_mode(boolean p0) {
    }
    
    public final void init() {
    }
    
    public final void clear() {
    }
    
    public final void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void downTouch(float x, float y) {
    }
    
    public final void moveTouch(float x, float y) {
    }
    
    public final void upTouch(float x, float y) {
    }
    
    private final void retrieveFromDatabase() {
    }
    
    public final void save() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon> getPolygons$app_debug() {
        return null;
    }
    
    public final long getImage_id$app_debug() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getParent_activity$app_debug() {
        return null;
    }
    
    public AnnotationsMode(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon> polygons, long image_id, @org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity parent_activity) {
        super();
    }
}