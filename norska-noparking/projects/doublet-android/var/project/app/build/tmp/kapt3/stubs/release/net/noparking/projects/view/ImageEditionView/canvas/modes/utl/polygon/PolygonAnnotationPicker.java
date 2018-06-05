package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0000J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0006J)\u0010\u001c\u001a\u00020\u00002!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\nJ}\u0010!\u001a\u00020\u00002u\u0010\u001d\u001aq\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0\rJ\u0006\u0010&\u001a\u00020\u000bJ\b\u0010\'\u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R4\u0010\f\u001a(\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006("}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/polygon/PolygonAnnotationPicker;", "", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "_data", "Lnet/noparking/projects/database/polygon_annotation/PolygonAnnotation;", "_id", "", "_on_delete", "Lkotlin/Function1;", "", "_on_save", "Lkotlin/Function5;", "", "", "_picker", "Landroid/support/v7/app/AlertDialog;", "_recalculating", "", "_view", "Landroid/view/View;", "getActivity$app_release", "()Landroid/support/v7/app/AppCompatActivity;", "init", "recalculateSurface", "setData", "data", "setOnDeleteAction", "f", "Lkotlin/ParameterName;", "name", "id", "setOnSaveAction", "width", "height", "surface", "comment", "show", "updateView", "app_release"})
public final class PolygonAnnotationPicker {
    private android.view.View _view;
    private net.noparking.projects.database.polygon_annotation.PolygonAnnotation _data;
    private kotlin.jvm.functions.Function5<? super java.lang.Long, ? super java.lang.Float, ? super java.lang.Float, ? super java.lang.Float, ? super java.lang.String, kotlin.Unit> _on_save;
    private kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> _on_delete;
    private android.support.v7.app.AlertDialog _picker;
    private boolean _recalculating;
    private long _id;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity activity = null;
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.PolygonAnnotationPicker setData(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.polygon_annotation.PolygonAnnotation data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.PolygonAnnotationPicker setOnSaveAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function5<? super java.lang.Long, ? super java.lang.Float, ? super java.lang.Float, ? super java.lang.Float, ? super java.lang.String, kotlin.Unit> f) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.PolygonAnnotationPicker setOnDeleteAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> f) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.polygon.PolygonAnnotationPicker init() {
        return null;
    }
    
    public final void show() {
    }
    
    private final void updateView() {
    }
    
    private final void recalculateSurface() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getActivity$app_release() {
        return null;
    }
    
    public PolygonAnnotationPicker(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity) {
        super();
    }
}