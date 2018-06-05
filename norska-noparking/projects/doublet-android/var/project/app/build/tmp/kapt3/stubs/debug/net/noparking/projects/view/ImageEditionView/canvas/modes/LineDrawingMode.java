package net.noparking.projects.view.ImageEditionView.canvas.modes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&J\u0018\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&J\u0018\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&J\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\tJ\u0016\u0010,\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&J\u000e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020#J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#J\u0016\u00103\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&J\u000e\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u0015R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\r0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001c\u00a8\u00067"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/LineDrawingMode;", "", "activity", "Landroid/support/v7/app/AppCompatActivity;", "image_id", "", "(Landroid/support/v7/app/AppCompatActivity;J)V", "_current_line", "", "", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line/Line;", "_current_moving_line", "_current_moving_point", "Lnet/noparking/projects/utl/Position;", "_drawer", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line/LineDrawer;", "_lines", "", "_lines_annotations", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/LineAnnotationMode;", "_size_ratio", "Lnet/noparking/projects/utl/SizeRatio;", "getActivity$app_debug", "()Landroid/support/v7/app/AppCompatActivity;", "current_color", "getCurrent_color", "()I", "setCurrent_color", "(I)V", "getImage_id$app_debug", "()J", "mode", "getMode", "setMode", "createNewLine", "", "downTouch", "x", "", "y", "findClosestLine", "findClosestPoint", "init", "_mode", "moveTouch", "onDraw", "canvas", "Landroid/graphics/Canvas;", "removeCurrentLine", "retrieveFromDatabase", "save", "upTouch", "updateSizeRatio", "ratio", "Companion", "app_debug"})
public final class LineDrawingMode {
    private final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line> _lines = null;
    private java.util.Map<java.lang.Integer, net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line> _current_line;
    private java.util.Map<java.lang.Integer, net.noparking.projects.utl.Position> _current_moving_point;
    private java.util.Map<java.lang.Integer, net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line> _current_moving_line;
    private net.noparking.projects.utl.SizeRatio _size_ratio;
    private int current_color;
    private int mode;
    private final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineDrawer _drawer = null;
    private final net.noparking.projects.view.ImageEditionView.canvas.modes.LineAnnotationMode _lines_annotations = null;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity activity = null;
    private final long image_id = 0L;
    private static float COLORIZATION_CLICK_TOLERANCE;
    private static final float RESIZING_CLICK_TOLERANCE = 50.0F;
    public static final net.noparking.projects.view.ImageEditionView.canvas.modes.LineDrawingMode.Companion Companion = null;
    
    public final int getCurrent_color() {
        return 0;
    }
    
    public final void setCurrent_color(int p0) {
    }
    
    public final int getMode() {
        return 0;
    }
    
    public final void setMode(int p0) {
    }
    
    public final void init(int _mode) {
    }
    
    public final void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void downTouch(float x, float y) {
    }
    
    public final void removeCurrentLine() {
    }
    
    public final void moveTouch(float x, float y) {
    }
    
    public final void upTouch(float x, float y) {
    }
    
    public final void save() {
    }
    
    public final void retrieveFromDatabase() {
    }
    
    public final void createNewLine() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final net.noparking.projects.utl.Position findClosestPoint(float x, float y) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line findClosestLine(float x, float y) {
        return null;
    }
    
    public final void updateSizeRatio(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.utl.SizeRatio ratio) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getActivity$app_debug() {
        return null;
    }
    
    public final long getImage_id$app_debug() {
        return 0L;
    }
    
    public LineDrawingMode(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity, long image_id) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/LineDrawingMode$Companion;", "", "()V", "COLORIZATION_CLICK_TOLERANCE", "", "getCOLORIZATION_CLICK_TOLERANCE", "()F", "setCOLORIZATION_CLICK_TOLERANCE", "(F)V", "RESIZING_CLICK_TOLERANCE", "getRESIZING_CLICK_TOLERANCE", "app_debug"})
    public static final class Companion {
        
        public final float getCOLORIZATION_CLICK_TOLERANCE() {
            return 0.0F;
        }
        
        public final void setCOLORIZATION_CLICK_TOLERANCE(float p0) {
        }
        
        public final float getRESIZING_CLICK_TOLERANCE() {
            return 0.0F;
        }
        
        private Companion() {
            super();
        }
    }
}