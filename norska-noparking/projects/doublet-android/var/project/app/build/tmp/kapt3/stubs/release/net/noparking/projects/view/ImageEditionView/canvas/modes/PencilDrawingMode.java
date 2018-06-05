package net.noparking.projects.view.ImageEditionView.canvas.modes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/PencilDrawingMode;", "", "context", "Landroid/content/Context;", "image_id", "", "(Landroid/content/Context;J)V", "_current_drawing", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/drawing/Drawing;", "_drawings", "", "getContext$app_release", "()Landroid/content/Context;", "getImage_id$app_release", "()J", "addNewEmptyDrawing", "", "clear", "downTouch", "x", "", "y", "color", "", "moveTouch", "onDraw", "canvas", "Landroid/graphics/Canvas;", "upTouch", "Companion", "app_release"})
public final class PencilDrawingMode {
    private final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.drawing.Drawing> _drawings = null;
    private net.noparking.projects.view.ImageEditionView.canvas.modes.utl.drawing.Drawing _current_drawing;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final long image_id = 0L;
    private static final float TOLERANCE = 5.0F;
    public static final net.noparking.projects.view.ImageEditionView.canvas.modes.PencilDrawingMode.Companion Companion = null;
    
    private final void addNewEmptyDrawing() {
    }
    
    public final void clear() {
    }
    
    public final void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void downTouch(float x, float y, int color) {
    }
    
    public final void moveTouch(float x, float y) {
    }
    
    public final void upTouch(float x, float y) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext$app_release() {
        return null;
    }
    
    public final long getImage_id$app_release() {
        return 0L;
    }
    
    public PencilDrawingMode(@org.jetbrains.annotations.NotNull()
    android.content.Context context, long image_id) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/PencilDrawingMode$Companion;", "", "()V", "TOLERANCE", "", "getTOLERANCE", "()F", "app_release"})
    public static final class Companion {
        
        public final float getTOLERANCE() {
            return 0.0F;
        }
        
        private Companion() {
            super();
        }
    }
}