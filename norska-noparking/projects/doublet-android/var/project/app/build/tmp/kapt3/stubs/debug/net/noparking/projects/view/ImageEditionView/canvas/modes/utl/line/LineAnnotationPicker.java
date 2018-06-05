package net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0000J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\nJ)\u0010\u001e\u001a\u00020\u00002!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\bJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\bJU\u0010&\u001a\u00020\u00002M\u0010\u001f\u001aI\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\'\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000f0\u0011J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\bJ\u0006\u0010*\u001a\u00020\u000fJ\b\u0010+\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006,"}, d2 = {"Lnet/noparking/projects/view/ImageEditionView/canvas/modes/utl/line/LineAnnotationPicker;", "", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "_confirmation", "", "_confirmation_label", "", "_data", "Lnet/noparking/projects/database/line_annotation/LineAnnotation;", "_id", "", "_on_negative", "Lkotlin/Function1;", "", "_on_positive", "Lkotlin/Function3;", "", "_picker", "Landroid/support/v7/app/AlertDialog;", "_view", "Landroid/view/View;", "getActivity$app_debug", "()Landroid/support/v7/app/AppCompatActivity;", "enableConfirmation", "state", "init", "setData", "data", "setNegativeAction", "f", "Lkotlin/ParameterName;", "name", "id", "setNegativeConfirmationLabel", "str", "setNegativeLabel", "setPositiveAction", "length", "comment", "setPositiveLabel", "show", "updateView", "app_debug"})
public final class LineAnnotationPicker {
    private android.view.View _view;
    private net.noparking.projects.database.line_annotation.LineAnnotation _data;
    private kotlin.jvm.functions.Function3<? super java.lang.Long, ? super java.lang.Float, ? super java.lang.String, kotlin.Unit> _on_positive;
    private kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> _on_negative;
    private java.lang.String _confirmation_label;
    private boolean _confirmation;
    private android.support.v7.app.AlertDialog _picker;
    private long _id;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity activity = null;
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker setData(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line_annotation.LineAnnotation data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker setNegativeConfirmationLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker enableConfirmation(boolean state) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker setPositiveAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.Long, ? super java.lang.Float, ? super java.lang.String, kotlin.Unit> f) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker setNegativeAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> f) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker setPositiveLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker setNegativeLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.view.ImageEditionView.canvas.modes.utl.line.LineAnnotationPicker init() {
        return null;
    }
    
    public final void show() {
    }
    
    private final void updateView() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getActivity$app_debug() {
        return null;
    }
    
    public LineAnnotationPicker(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity) {
        super();
    }
}