package net.noparking.projects.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 I2\u00020\u0001:\u0001IB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\u0010\u0010\'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0004H\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\"\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0012\u00101\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0012\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u001cH\u0014J\b\u0010;\u001a\u00020\u000eH\u0016J\b\u0010<\u001a\u00020\u001cH\u0002J\b\u0010=\u001a\u00020\u001cH\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0019H\u0002J0\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020D0Cj\b\u0012\u0004\u0012\u00020D`EH\u0002J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020-H\u0002J\b\u0010H\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lnet/noparking/projects/activity/ProjectManagerActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "_email_text", "", "_image_picker", "Lnet/noparking/projects/utl/ImagePicker;", "_images_collector", "Lnet/noparking/projects/database/image/ImagesCollector;", "_images_list", "Landroid/arch/lifecycle/LiveData;", "", "Lnet/noparking/projects/database/image/Image;", "_new_image_created", "", "_project", "Lnet/noparking/projects/database/project/Project;", "_project_directory", "Lnet/noparking/projects/utl/Directory;", "_projects_collector", "Lnet/noparking/projects/database/project/ProjectsCollector;", "_projects_list", "_root_directory", "blitImageDrawings", "Lkotlin/Pair;", "Lnet/noparking/projects/utl/Image;", "db_image", "changeProjectParameters", "", "compareImageNames", "name", "compareProjectNames", "deleteImage", "image", "deleteProject", "exportProject", "goToImageEdition", "goToImageParametring", "initCollectors", "initDirectories", "directory_name", "initSupportActionBar", "initViewItems", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onSupportNavigateUp", "retrieveProjectImages", "retrieveProjectInfos", "saveImage", "sendMail", "subject", "text", "attachments", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "setImagesListVisibility", "state", "updateTitle", "Companion", "app_debug"})
public final class ProjectManagerActivity extends android.support.v7.app.AppCompatActivity {
    private final net.noparking.projects.database.project.ProjectsCollector _projects_collector = null;
    private final net.noparking.projects.database.image.ImagesCollector _images_collector = null;
    private net.noparking.projects.utl.Directory _root_directory;
    private net.noparking.projects.utl.Directory _project_directory;
    private net.noparking.projects.utl.ImagePicker _image_picker;
    private boolean _new_image_created;
    private net.noparking.projects.database.project.Project _project;
    private android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.image.Image>> _images_list;
    private android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.project.Project>> _projects_list;
    private java.lang.String _email_text;
    private static final int STATE_NO_IMAGE = 0;
    private static final int STATE_SHOW = 1;
    private static final int STATE_LOADING = 2;
    private static final int ACTIVITY_IMAGE_EDITION = 3;
    public static final net.noparking.projects.activity.ProjectManagerActivity.Companion Companion = null;
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
    
    private final void retrieveProjectImages() {
    }
    
    private final void initDirectories(java.lang.String directory_name) {
    }
    
    private final void initViewItems() {
    }
    
    private final void exportProject() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.String, net.noparking.projects.utl.Image> blitImageDrawings(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.image.Image db_image) {
        return null;
    }
    
    private final void sendMail(java.lang.String subject, java.lang.String text, java.util.ArrayList<android.net.Uri> attachments) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void saveImage(net.noparking.projects.utl.Image image) {
    }
    
    private final void setImagesListVisibility(int state) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void goToImageEdition(net.noparking.projects.database.image.Image image) {
    }
    
    private final void changeProjectParameters() {
    }
    
    private final void deleteProject() {
    }
    
    private final void deleteImage(net.noparking.projects.database.image.Image image) {
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
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lnet/noparking/projects/activity/ProjectManagerActivity$Companion;", "", "()V", "ACTIVITY_IMAGE_EDITION", "", "getACTIVITY_IMAGE_EDITION", "()I", "STATE_LOADING", "getSTATE_LOADING", "STATE_NO_IMAGE", "getSTATE_NO_IMAGE", "STATE_SHOW", "getSTATE_SHOW", "app_debug"})
    public static final class Companion {
        
        public final int getSTATE_NO_IMAGE() {
            return 0;
        }
        
        public final int getSTATE_SHOW() {
            return 0;
        }
        
        public final int getSTATE_LOADING() {
            return 0;
        }
        
        public final int getACTIVITY_IMAGE_EDITION() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}