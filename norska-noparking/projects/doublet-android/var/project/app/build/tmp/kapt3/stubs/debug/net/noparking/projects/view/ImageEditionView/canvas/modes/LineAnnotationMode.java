package net.noparking.projects.view.ImageEditionView.canvas.modes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0001/B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0006\u0010$\u001a\u00020\u0018J\u0006\u0010%\u001a\u00020\u0018J5\u0010&\u001a\u00020\u00182\u0006\u0010\'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u0006\u00a2\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u00060"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/LineAnnotationMode;", "", "activity", "Landroid/support/v7/app/AppCompatActivity;", "lines", "", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line/Line;", "image_id", "", "(Landroid/support/v7/app/AppCompatActivity;Ljava/util/List;J)V", "_drawer", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line_annotation/LineAnnotationDrawer;", "_lines_annotations", "", "Lnet/noparking/projects/database/line_annotation/LineAnnotation;", "_picker", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line/LineAnnotationPicker;", "getActivity$app_debug", "()Landroid/support/v7/app/AppCompatActivity;", "getImage_id$app_debug", "()J", "getLines$app_debug", "()Ljava/util/List;", "deleteAnnotation", "", "line", "downTouch", "x", "", "y", "init", "moveTouch", "onDraw", "canvas", "Landroid/graphics/Canvas;", "removeAnnotationByLine", "retrieveFromDatabase", "save", "saveAnnotation", "id", "length", "comment", "", "annotation", "reference", "(JLjava/lang/Float;Ljava/lang/String;Lnet/noparking/projects/database/line_annotation/LineAnnotation;Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line/Line;)V", "upTouch", "Companion", "app_debug"})
public final class LineAnnotationMode {
    private final java.util.Map<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line, net.noparking.projects.database.line_annotation.LineAnnotation> _lines_annotations = null;
    private final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker _picker = null;
    private final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line_annotation.LineAnnotationDrawer _drawer = null;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity activity = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line> lines = null;
    private final long image_id = 0L;
    private static final float CLICK_TOLERANCE = 30.0F;
    public static final net.noparking.projects.view.ImageEditionView.canvas.modes.LineAnnotationMode.Companion Companion = null;
    
    public final void init() {
    }
    
    public final void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void downTouch(float x, float y) {
    }
    
    public final void saveAnnotation(long id, @org.jetbrains.annotations.Nullable()
    java.lang.Float length, @org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line_annotation.LineAnnotation annotation, @org.jetbrains.annotations.NotNull()
    net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line reference) {
    }
    
    public final void deleteAnnotation(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line line) {
    }
    
    public final void moveTouch(float x, float y) {
    }
    
    public final void upTouch(float x, float y) {
    }
    
    public final void retrieveFromDatabase() {
    }
    
    public final void save() {
    }
    
    public final void removeAnnotationByLine(@org.jetbrains.annotations.Nullable()
    net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line line) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getActivity$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line> getLines$app_debug() {
        return null;
    }
    
    public final long getImage_id$app_debug() {
        return 0L;
    }
    
    public LineAnnotationMode(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line> lines, long image_id) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/LineAnnotationMode$Companion;", "", "()V", "CLICK_TOLERANCE", "", "getCLICK_TOLERANCE", "()F", "app_debug"})
    public static final class Companion {
        
        public final float getCLICK_TOLERANCE() {
            return 0.0F;
        }
        
        private Companion() {
            super();
        }
    }
}