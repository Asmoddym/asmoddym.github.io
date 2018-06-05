package net.noparking.projects.view.ImageEditionView.canvas;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nJ\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0014J(\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010\'\u001a\u00020$H\u0014J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0006\u0010,\u001a\u00020)J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020$J\u000e\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020$J\u000e\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\fJ\u0018\u00103\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u00064"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/CanvasView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_lines_drawing_mode", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/LineDrawingMode;", "_parent_activity", "Landroid/support/v7/app/AppCompatActivity;", "_parent_view", "Lnet/noparking/projects/view/ImageEditionView/ImageEditionView;", "_size_ratio", "Lnet/noparking/projects/utl/SizeRatio;", "getContext$app_debug", "()Landroid/content/Context;", "setContext$app_debug", "(Landroid/content/Context;)V", "clear", "", "destroy", "downTouch", "x", "", "y", "init", "image_id", "", "parent_activity", "moveTouch", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "", "h", "oldw", "oldh", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setClearMode", "setColor", "color", "setDrawingMode", "mode", "setViewInfos", "parent_view", "upTouch", "app_debug"})
public final class CanvasView extends android.view.View {
    private android.support.v7.app.AppCompatActivity _parent_activity;
    private net.noparking.projects.view.ImageEditionView.canvas.modes.LineDrawingMode _lines_drawing_mode;
    private net.noparking.projects.view.ImageEditionView.ImageEditionView _parent_view;
    private net.noparking.projects.utl.SizeRatio _size_ratio;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    private java.util.HashMap _$_findViewCache;
    
    public final void init(long image_id, @org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity parent_activity) {
    }
    
    public final void setColor(int color) {
    }
    
    public final boolean setClearMode() {
        return false;
    }
    
    public final void clear() {
    }
    
    public final void setDrawingMode(int mode) {
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    private final void downTouch(float x, float y) {
    }
    
    private final void moveTouch(float x, float y) {
    }
    
    private final void upTouch(float x, float y) {
    }
    
    public final void destroy() {
    }
    
    public final void setViewInfos(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.view.ImageEditionView.ImageEditionView parent_view) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext$app_debug() {
        return null;
    }
    
    public final void setContext$app_debug(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    public CanvasView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        super(null);
    }
}