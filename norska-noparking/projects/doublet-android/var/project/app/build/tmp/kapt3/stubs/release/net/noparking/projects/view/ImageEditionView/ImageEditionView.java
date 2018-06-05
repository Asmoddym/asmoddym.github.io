package net.noparking.projects.view.ImageEditionView;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J(\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0014J\u0010\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006#"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/ImageEditionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_bitmap", "Landroid/graphics/Bitmap;", "_canvas", "Lnet/noparking/projects/view/ImageEditionView/canvas/CanvasView;", "_image", "Landroid/widget/ImageView;", "getContext$app_release", "()Landroid/content/Context;", "setContext$app_release", "(Landroid/content/Context;)V", "getCanvas", "init", "", "image_id", "", "parent_activity", "Landroid/support/v7/app/AppCompatActivity;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "", "h", "oldw", "oldh", "setBitmap", "bitmap", "app_release"})
public final class ImageEditionView extends android.widget.RelativeLayout {
    private android.graphics.Bitmap _bitmap;
    private android.widget.ImageView _image;
    private net.noparking.projects.view.ImageEditionView.canvas.CanvasView _canvas;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    private java.util.HashMap _$_findViewCache;
    
    public final void init(long image_id, @org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity parent_activity) {
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void setBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap bitmap) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.CanvasView getCanvas() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext$app_release() {
        return null;
    }
    
    public final void setContext$app_release(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    public ImageEditionView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        super(null);
    }
}