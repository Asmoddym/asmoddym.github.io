package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u0004J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020\u001fJ\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\'J\u0016\u0010)\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u0016\u0010*\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-J\u0016\u0010.\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u0006\u0010/\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011\u00a8\u00060"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line/Line;", "", "()V", "_last_translation_point", "Lnet/noparking/projects/utl/Position;", "_path", "Landroid/graphics/Path;", "data", "Lnet/noparking/projects/database/line/Line;", "getData", "()Lnet/noparking/projects/database/line/Line;", "setData", "(Lnet/noparking/projects/database/line/Line;)V", "from", "getFrom", "()Lnet/noparking/projects/utl/Position;", "setFrom", "(Lnet/noparking/projects/utl/Position;)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "to", "getTo", "setTo", "endTranslation", "", "fromData", "_data", "getMiddlePoint", "isCloseFrom", "", "x", "", "y", "tolerance", "isTranslating", "resizeDown", "ratio", "Lnet/noparking/projects/utl/SizeRatio;", "resizeUp", "setEndPoint", "setOriginPoint", "toData", "image_id", "", "translate", "updatePath", "app_debug"})
public final class Line {
    @org.jetbrains.annotations.NotNull()
    private net.noparking.projects.database.line.Line data;
    @org.jetbrains.annotations.NotNull()
    private net.noparking.projects.utl.Position from;
    @org.jetbrains.annotations.NotNull()
    private net.noparking.projects.utl.Position to;
    private net.noparking.projects.utl.Position _last_translation_point;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paint = null;
    private final android.graphics.Path _path = null;
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line.Line getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line.Line p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.Position getFrom() {
        return null;
    }
    
    public final void setFrom(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.utl.Position p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.Position getTo() {
        return null;
    }
    
    public final void setTo(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.utl.Position p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Paint getPaint() {
        return null;
    }
    
    public final void setOriginPoint(float x, float y) {
    }
    
    public final void setEndPoint(float x, float y) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Path updatePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line fromData(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line.Line _data) {
        return null;
    }
    
    public final void toData(long image_id) {
    }
    
    public final boolean isCloseFrom(float x, float y, float tolerance) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.Position getMiddlePoint() {
        return null;
    }
    
    public final void translate(float x, float y) {
    }
    
    public final void endTranslation() {
    }
    
    public final boolean isTranslating() {
        return false;
    }
    
    public final void resizeUp(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.utl.SizeRatio ratio) {
    }
    
    public final void resizeDown(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.utl.SizeRatio ratio) {
    }
    
    public Line() {
        super();
    }
}