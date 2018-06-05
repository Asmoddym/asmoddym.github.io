package net.noparking.projects.utl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\r2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\rJ \u0010\u001d\u001a\u00020\u00002\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\fJ\u0006\u0010\u001f\u001a\u00020\u000fR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lnet/noparking/projects/utl/ImageNamePicker;", "", "activity", "Landroid/support/v7/app/AppCompatActivity;", "project_id", "", "(Landroid/support/v7/app/AppCompatActivity;J)V", "_images_list", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/image/Image;", "_positive_action", "Lkotlin/Function2;", "", "", "", "_view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActivity$app_debug", "()Landroid/support/v7/app/AppCompatActivity;", "getProject_id$app_debug", "()J", "findImageNameInList", "name", "list", "initPicker", "setDefaultInput", "s", "setOnPositiveAction", "f", "show", "app_debug"})
public final class ImageNamePicker {
    private final android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.image.Image>> _images_list = null;
    private kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> _positive_action;
    private final android.view.View _view = null;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity activity = null;
    private final long project_id = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.ImageNamePicker setDefaultInput(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.ImageNamePicker setOnPositiveAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> f) {
        return null;
    }
    
    private final void initPicker() {
    }
    
    public final void show() {
    }
    
    private final boolean findImageNameInList(java.lang.String name, java.util.List<net.noparking.projects.database.image.Image> list) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getActivity$app_debug() {
        return null;
    }
    
    public final long getProject_id$app_debug() {
        return 0L;
    }
    
    public ImageNamePicker(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity, long project_id) {
        super();
    }
}