package net.noparking.projects.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0017\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\fH\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lnet/noparking/projects/activity/ProjectsManagerActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "_projects_list", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/project/Project;", "compareProjectNames", "", "name", "", "createNewProject", "", "color", "", "deleteProject", "project", "generateDirectoryFromProjectName", "raw", "goToProjectManager", "project_id", "", "(Ljava/lang/Long;)V", "goToProjectParametring", "initNewProjectButton", "initProjectsView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_release"})
public final class ProjectsManagerActivity extends android.support.v7.app.AppCompatActivity {
    private android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.project.Project>> _projects_list;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initNewProjectButton() {
    }
    
    private final void initProjectsView() {
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
    
    private final void goToProjectManager(java.lang.Long project_id) {
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