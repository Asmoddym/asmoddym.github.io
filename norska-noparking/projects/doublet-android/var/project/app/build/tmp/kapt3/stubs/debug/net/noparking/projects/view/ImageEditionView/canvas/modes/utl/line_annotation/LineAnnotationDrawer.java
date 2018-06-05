package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line_annotation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line_annotation/LineAnnotationDrawer;", "", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TEXT_BG_PADDING", "", "getTEXT_BG_PADDING", "()I", "TEXT_BG_PAINT", "Landroid/graphics/Paint;", "getTEXT_BG_PAINT", "()Landroid/graphics/Paint;", "TEXT_METRICS", "Landroid/graphics/Paint$FontMetrics;", "getTEXT_METRICS", "()Landroid/graphics/Paint$FontMetrics;", "TEXT_PAINT", "getTEXT_PAINT", "getActivity$app_debug", "()Landroid/support/v7/app/AppCompatActivity;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "line", "Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line/Line;", "lineAnnotation", "Lnet/noparking/projects/database/line_annotation/LineAnnotation;", "app_debug"})
public final class LineAnnotationDrawer {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint TEXT_PAINT = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint TEXT_BG_PAINT = null;
    private final int TEXT_BG_PADDING = 10;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint.FontMetrics TEXT_METRICS = null;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity activity = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Paint getTEXT_PAINT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Paint getTEXT_BG_PAINT() {
        return null;
    }
    
    public final int getTEXT_BG_PADDING() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Paint.FontMetrics getTEXT_METRICS() {
        return null;
    }
    
    public final void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas, @org.jetbrains.annotations.NotNull()
    net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.Line line, @org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line_annotation.LineAnnotation lineAnnotation) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getActivity$app_debug() {
        return null;
    }
    
    public LineAnnotationDrawer(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity) {
        super();
    }
}