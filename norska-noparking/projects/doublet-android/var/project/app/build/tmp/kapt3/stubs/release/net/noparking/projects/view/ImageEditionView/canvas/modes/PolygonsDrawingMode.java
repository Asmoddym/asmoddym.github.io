package net.noparking.projects.view.ImageEditionView.canvas.modes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 O2\u00020\u0001:\u0001OB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010/\u001a\u000200H\u0002J\u0006\u00101\u001a\u000200J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0002J \u00107\u001a\u0002002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\b\b\u0002\u00108\u001a\u00020\u0012J\u0016\u00109\u001a\u0002002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205J\u000e\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u001eJ\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018J\u0018\u0010=\u001a\u0004\u0018\u00010 2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205J\u0014\u0010>\u001a\u0002002\f\u0010?\u001a\b\u0012\u0004\u0012\u0002000@J\b\u0010A\u001a\u000200H\u0002J\u0016\u0010B\u001a\u0002002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205J\u000e\u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020EJ.\u0010F\u001a\u0002002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u001e2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002000@H\u0002J\u0016\u0010K\u001a\u0002002\f\u0010?\u001a\b\u0012\u0004\u0012\u0002000@H\u0002J\u0016\u0010L\u001a\u0002002\f\u0010?\u001a\b\u0012\u0004\u0012\u0002000@H\u0002J\u0014\u0010M\u001a\u0002002\f\u0010?\u001a\b\u0012\u0004\u0012\u0002000@J \u0010N\u001a\u0002002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\b\b\u0002\u00108\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.\u00a8\u0006P"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/PolygonsDrawingMode;", "", "context", "Landroid/content/Context;", "image_id", "", "parent_activity", "Landroid/support/v7/app/AppCompatActivity;", "parent_view", "Lnet/noparking/projects/view/ImageEditionView/canvas/CanvasView;", "(Landroid/content/Context;JLandroid/support/v7/app/AppCompatActivity;Lnet/noparking/projects/view/ImageEditionView/canvas/CanvasView;)V", "_circle_paint", "Landroid/graphics/Paint;", "_clear_mode_border_paint", "_clear_mode_fill_paint", "_current_polygon", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/Polygon;", "_id_count", "", "_lines_collector", "Lnet/noparking/projects/database/line/LinesCollector;", "get_lines_collector", "()Lnet/noparking/projects/database/line/LinesCollector;", "_polygons", "", "_polygons_collector", "Lnet/noparking/projects/database/polygon/PolygonsCollector;", "get_polygons_collector", "()Lnet/noparking/projects/database/polygon/PolygonsCollector;", "_redimensionning_enabled", "", "_redimensionning_polygon", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/PolygonRedimensionData;", "_working_paint", "clear_mode", "getClear_mode", "()Z", "setClear_mode", "(Z)V", "getContext$app_release", "()Landroid/content/Context;", "getImage_id$app_release", "()J", "getParent_activity$app_release", "()Landroid/support/v7/app/AppCompatActivity;", "getParent_view$app_release", "()Lnet/noparking/projects/view/ImageEditionView/canvas/CanvasView;", "addNewEmptyPolygon", "", "clear", "determineNewSideFrom", "Lnet/noparking/projects/utl/Position;", "x", "", "y", "downTouch", "color", "downTouchClearMode", "enableRedimensionning", "v", "getPolygons", "getTouchedPolygon", "initAndExecute", "f", "Lkotlin/Function0;", "initPaint", "moveTouch", "onDraw", "canvas", "Landroid/graphics/Canvas;", "processLineInDatabase", "side", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/Line;", "polygon", "last", "retrieveFromDatabase", "save", "saveAndExecute", "upTouch", "Companion", "app_release"})
public final class PolygonsDrawingMode {
    private final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon> _polygons = null;
    private int _id_count;
    private net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon _current_polygon;
    private net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.PolygonRedimensionData _redimensionning_polygon;
    private final android.graphics.Paint _working_paint = null;
    private final android.graphics.Paint _circle_paint = null;
    private final android.graphics.Paint _clear_mode_fill_paint = null;
    private final android.graphics.Paint _clear_mode_border_paint = null;
    private boolean _redimensionning_enabled;
    private boolean clear_mode;
    @org.jetbrains.annotations.NotNull()
    private final net.noparking.projects.database.polygon.PolygonsCollector _polygons_collector = null;
    @org.jetbrains.annotations.NotNull()
    private final net.noparking.projects.database.line.LinesCollector _lines_collector = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final long image_id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity parent_activity = null;
    @org.jetbrains.annotations.NotNull()
    private final net.noparking.projects.view.ImageEditionView.canvas.CanvasView parent_view = null;
    private static final float TOLERANCE = 100.0F;
    private static final float REDIMENSIONNING_CIRCLE_TOLERANCE = 60.0F;
    public static final net.noparking.projects.view.ImageEditionView.canvas.modes.PolygonsDrawingMode.Companion Companion = null;
    
    public final boolean getClear_mode() {
        return false;
    }
    
    public final void setClear_mode(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.polygon.PolygonsCollector get_polygons_collector() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line.LinesCollector get_lines_collector() {
        return null;
    }
    
    private final void initPaint() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon> getPolygons() {
        return null;
    }
    
    public final void clear() {
    }
    
    public final void enableRedimensionning(boolean v) {
    }
    
    private final void addNewEmptyPolygon() {
    }
    
    public final void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void downTouch(float x, float y, int color) {
    }
    
    private final net.noparking.projects.utl.Position determineNewSideFrom(float x, float y) {
        return null;
    }
    
    public final void moveTouch(float x, float y) {
    }
    
    public final void upTouch(float x, float y, int color) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.PolygonRedimensionData getTouchedPolygon(float x, float y) {
        return null;
    }
    
    public final void saveAndExecute(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> f) {
    }
    
    private final void save(kotlin.jvm.functions.Function0<kotlin.Unit> f) {
    }
    
    private final void processLineInDatabase(net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line side, net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon polygon, boolean last, kotlin.jvm.functions.Function0<kotlin.Unit> f) {
    }
    
    public final void initAndExecute(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> f) {
    }
    
    private final void retrieveFromDatabase(kotlin.jvm.functions.Function0<kotlin.Unit> f) {
    }
    
    public final void downTouchClearMode(float x, float y) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext$app_release() {
        return null;
    }
    
    public final long getImage_id$app_release() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getParent_activity$app_release() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.CanvasView getParent_view$app_release() {
        return null;
    }
    
    public PolygonsDrawingMode(@org.jetbrains.annotations.NotNull()
    android.content.Context context, long image_id, @org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity parent_activity, @org.jetbrains.annotations.NotNull()
    net.noparking.projects.view.ImageEditionView.canvas.CanvasView parent_view) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/PolygonsDrawingMode$Companion;", "", "()V", "REDIMENSIONNING_CIRCLE_TOLERANCE", "", "getREDIMENSIONNING_CIRCLE_TOLERANCE", "()F", "TOLERANCE", "getTOLERANCE", "app_release"})
    public static final class Companion {
        
        public final float getTOLERANCE() {
            return 0.0F;
        }
        
        public final float getREDIMENSIONNING_CIRCLE_TOLERANCE() {
            return 0.0F;
        }
        
        private Companion() {
            super();
        }
    }
}