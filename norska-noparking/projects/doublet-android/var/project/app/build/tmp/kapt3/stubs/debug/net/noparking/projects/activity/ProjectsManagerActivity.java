package net.noparking.projects.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0012H\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lnet/noparking/projects/activity/ProjectsManagerActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "_images_list", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/image/Image;", "_images_number", "", "", "", "_projects_list", "Lnet/noparking/projects/database/project/Project;", "compareProjectNames", "", "name", "", "createNewProject", "", "color", "deleteProject", "project", "generateDirectoryFromProjectName", "raw", "getImagesNumber", "images", "goToProjectManager", "goToProjectParametring", "initNewProjectButton", "initProjectsView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
public final class ProjectsManagerActivity extends android.support.v7.app.AppCompatActivity {
    private android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.project.Project>> _projects_list;
    private final java.util.Map<java.lang.Long, java.lang.Integer> _images_number = null;
    private android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.image.Image>> _images_list;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initNewProjectButton() {
    }
    
    private final void initProjectsView() {
    }
    
    private final void getImagesNumber(java.util.List<net.noparking.projects.database.image.Image> images) {
    }
    
    private final boolean compareProjectNames(java.lang.String name) {
        return false;
    }
    
    private final void goToProjectParametring(net.noparking.projects.database.project.Project project) {
    }
    
    private final void deleteProject(net.noparking.projects.database.project.Project project) {
    }
    
    private final void createNewProject(java.lang.String name, int color) {
    }
    
    private final void goToProjectManager(net.noparking.projects.database.project.Project project) {
    }
    
    private final java.lang.String generateDirectoryFromProjectName(java.lang.String raw) {
        return null;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public ProjectsManagerActivity() {
        super();
    }
}