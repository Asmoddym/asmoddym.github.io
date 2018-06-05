package net.noparking.projects.utl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007J\u001a\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0006\u0010\u001b\u001a\u00020\bR\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lnet/noparking/projects/utl/ProjectNamePicker;", "", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "_positive_action", "Lkotlin/Function1;", "", "", "_projects_list", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/project/Project;", "_view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getActivity$app_release", "()Landroid/support/v7/app/AppCompatActivity;", "findProjectNameInList", "", "name", "list", "initPicker", "setDefaultInput", "s", "setOnPositiveAction", "f", "show", "app_release"})
public final class ProjectNamePicker {
    private final android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.project.Project>> _projects_list = null;
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> _positive_action;
    private final android.view.View _view = null;
    @org.jetbrains.annotations.NotNull()
    private final android.support.v7.app.AppCompatActivity activity = null;
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.ProjectNamePicker setDefaultInput(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.ProjectNamePicker setOnPositiveAction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> f) {
        return null;
    }
    
    private final void initPicker() {
    }
    
    public final void show() {
    }
    
    private final boolean findProjectNameInList(java.lang.String name, java.util.List<net.noparking.projects.database.project.Project> list) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v7.app.AppCompatActivity getActivity$app_release() {
        return null;
    }
    
    public ProjectNamePicker(@org.jetbrains.annotations.NotNull()
    android.support.v7.app.AppCompatActivity activity) {
        super();
    }
}