package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u001eJ\u0006\u00104\u001a\u00020+R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010 \"\u0004\b)\u0010\"\u00a8\u00066"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/Polygon;", "", "()V", "average_fill_paint", "Landroid/graphics/Paint;", "getAverage_fill_paint", "()Landroid/graphics/Paint;", "current_side", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/Line;", "getCurrent_side", "()Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/Line;", "setCurrent_side", "(Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/Line;)V", "db_id", "", "getDb_id", "()J", "setDb_id", "(J)V", "drawing_new_line", "", "getDrawing_new_line", "()Z", "setDrawing_new_line", "(Z)V", "global_path", "Landroid/graphics/Path;", "getGlobal_path", "()Landroid/graphics/Path;", "id", "", "getId", "()I", "setId", "(I)V", "sides", "", "getSides", "()Ljava/util/List;", "status", "getStatus", "setStatus", "addNewEmptySide", "", "clean", "close", "getLastSavedSide", "getLastSide", "getOriginPosition", "Lnet/noparking/projects/utl/Position;", "setColor", "color", "updateGlobalPath", "Companion", "app_debug"})
public final class Polygon {
    private long db_id;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line> sides = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Path global_path = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint average_fill_paint = null;
    private int status;
    private boolean drawing_new_line;
    private int id;
    @org.jetbrains.annotations.NotNull()
    public net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line current_side;
    private static final int IN_PROGRESS = 0;
    private static final int CLOSING_PROPOSITION = 1;
    private static final int CLOSED = 2;
    private static final int REDIMENSIONNING = 3;
    private static final int REDIMENSIONNING_CLOSED = 4;
    public static final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Polygon.Companion Companion = null;
    
    public final long getDb_id() {
        return 0L;
    }
    
    public final void setDb_id(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line> getSides() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Path getGlobal_path() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Paint getAverage_fill_paint() {
        return null;
    }
    
    public final int getStatus() {
        return 0;
    }
    
    public final void setStatus(int p0) {
    }
    
    public final boolean getDrawing_new_line() {
        return false;
    }
    
    public final void setDrawing_new_line(boolean p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line getCurrent_side() {
        return null;
    }
    
    public final void setCurrent_side(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line p0) {
    }
    
    public final void addNewEmptySide() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line getLastSide() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.Line getLastSavedSide() {
        return null;
    }
    
    public final void setColor(int color) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.Position getOriginPosition() {
        return null;
    }
    
    public final void clean() {
    }
    
    public final void close() {
    }
    
    public final void updateGlobalPath() {
    }
    
    public Polygon() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/Polygon$Companion;", "", "()V", "CLOSED", "", "getCLOSED", "()I", "CLOSING_PROPOSITION", "getCLOSING_PROPOSITION", "IN_PROGRESS", "getIN_PROGRESS", "REDIMENSIONNING", "getREDIMENSIONNING", "REDIMENSIONNING_CLOSED", "getREDIMENSIONNING_CLOSED", "app_debug"})
    public static final class Companion {
        
        public final int getIN_PROGRESS() {
            return 0;
        }
        
        public final int getCLOSING_PROPOSITION() {
            return 0;
        }
        
        public final int getCLOSED() {
            return 0;
        }
        
        public final int getREDIMENSIONNING() {
            return 0;
        }
        
        public final int getREDIMENSIONNING_CLOSED() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}