package net.noparking.projects.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\"\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u0012\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0012\u0010+\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u0014H\u0014J\b\u00102\u001a\u00020\u0016H\u0016J\u0010\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020\u0014H\u0002J\u0010\u00106\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u000207H\u0002J\b\u00108\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lnet/noparking/projects/activity/ProjectManagerActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "_image_picker", "Lnet/noparking/projects/utl/ImagePicker;", "_images_collector", "Lnet/noparking/projects/database/image/ImagesCollector;", "_images_list", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/image/Image;", "_project", "Lnet/noparking/projects/database/project/Project;", "_project_directory", "Lnet/noparking/projects/utl/Directory;", "_projects_collector", "Lnet/noparking/projects/database/project/ProjectsCollector;", "_projects_list", "_root_directory", "changeProjectParameters", "", "compareImageNames", "", "name", "", "compareProjectNames", "goToImageEdition", "image", "goToImageParametring", "initCollectors", "initDirectories", "directory_name", "initSupportActionBar", "initViewItems", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onSupportNavigateUp", "retrieveProjectImages", "project", "retrieveProjectInfos", "saveImage", "Lnet/noparking/projects/utl/Image;", "updateTitle", "app_release"})
public final class ProjectManagerActivity extends android.support.v7.app.AppCompatActivity {
    private final net.noparking.projects.database.project.ProjectsCollector _projects_collector = null;
    private final net.noparking.projects.database.image.ImagesCollector _images_collector = null;
    private net.noparking.projects.utl.Directory _root_directory;
    private net.noparking.projects.utl.Directory _project_directory;
    private net.noparking.projects.utl.ImagePicker _image_picker;
    private net.noparking.projects.database.project.Project _project;
    private android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.image.Image>> _images_list;
    private android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.project.Project>> _projects_list;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initCollectors() {
    }
    
    private final void initSupportActionBar() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    private final void retrieveProjectInfos() {
    }
    
    private final void updateTitle() {
    }
    
    private final void retrieveProjectImages(net.noparking.projects.database.project.Project project) {
    }
    
    private final void initDirectories(java.lang.String directory_name) {
    }
    
    private final void initViewItems() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void saveImage(net.noparking.projects.utl.Image image) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void goToImageEdition(net.noparking.projects.database.image.Image image) {
    }
    
    private final void changeProjectParameters() {
    }
    
    private final void goToImageParametring(net.noparking.projects.database.image.Image image) {
    }
    
    private final boolean compareImageNames(java.lang.String name) {
        return false;
    }
    
    private final boolean compareProjectNames(java.lang.String name) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.Nullable()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    public ProjectManagerActivity() {
        super();
    }
}