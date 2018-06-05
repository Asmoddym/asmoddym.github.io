package net.noparking.projects.utl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010)\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010,\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010-\u001a\u00020*H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0014\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0007J\b\u00102\u001a\u00020*H\u0002J\u0014\u00103\u001a\u0004\u0018\u0001002\b\u00104\u001a\u0004\u0018\u000100H\u0002J\u0006\u00105\u001a\u00020*R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u00066"}, d2 = {"Lnet/noparking/projects/utl/Image;", "Ljava/io/Serializable;", "context", "Landroid/content/Context;", "directory", "Lnet/noparking/projects/utl/Directory;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/Context;Lnet/noparking/projects/utl/Directory;Landroid/content/ContentResolver;)V", "_angle", "", "getContentResolver$app_debug", "()Landroid/content/ContentResolver;", "getContext$app_debug", "()Landroid/content/Context;", "dimensions", "Lnet/noparking/projects/utl/Dimensions;", "getDimensions", "()Lnet/noparking/projects/utl/Dimensions;", "setDimensions", "(Lnet/noparking/projects/utl/Dimensions;)V", "getDirectory$app_debug", "()Lnet/noparking/projects/utl/Directory;", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "file_name", "", "getFile_name", "()Ljava/lang/String;", "setFile_name", "(Ljava/lang/String;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "create", "", "name", "generateName", "generatePermissions", "generateUriFromFile", "getBitmap", "Landroid/graphics/Bitmap;", "content_resolver", "getImageSpecifications", "getRotatedBitmap", "source", "removeIfExisting", "app_debug"})
public final class Image implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String file_name;
    @org.jetbrains.annotations.NotNull()
    private android.net.Uri uri;
    @org.jetbrains.annotations.NotNull()
    public java.io.File file;
    private float _angle;
    @org.jetbrains.annotations.NotNull()
    private net.noparking.projects.utl.Dimensions dimensions;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private final net.noparking.projects.utl.Directory directory = null;
    @org.jetbrains.annotations.Nullable()
    private final android.content.ContentResolver contentResolver = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFile_name() {
        return null;
    }
    
    public final void setFile_name(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getUri() {
        return null;
    }
    
    public final void setUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.Dimensions getDimensions() {
        return null;
    }
    
    public final void setDimensions(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.utl.Dimensions p0) {
    }
    
    public final void create(@org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    public final void removeIfExisting() {
    }
    
    private final java.lang.String generateName(java.lang.String name) {
        return null;
    }
    
    private final void generatePermissions() {
    }
    
    private final android.net.Uri generateUriFromFile(java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getBitmap(@org.jetbrains.annotations.Nullable()
    android.content.ContentResolver content_resolver) {
        return null;
    }
    
    private final void getImageSpecifications() {
    }
    
    private final android.graphics.Bitmap getRotatedBitmap(android.graphics.Bitmap source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final net.noparking.projects.utl.Directory getDirectory$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.ContentResolver getContentResolver$app_debug() {
        return null;
    }
    
    public Image(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    net.noparking.projects.utl.Directory directory, @org.jetbrains.annotations.Nullable()
    android.content.ContentResolver contentResolver) {
        super();
    }
}