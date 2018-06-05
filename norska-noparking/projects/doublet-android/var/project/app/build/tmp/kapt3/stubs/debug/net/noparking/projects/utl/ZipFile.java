package net.noparking.projects.utl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u001eH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lnet/noparking/projects/utl/ZipFile;", "", "context", "Landroid/content/Context;", "root", "Lnet/noparking/projects/utl/Directory;", "file_name", "", "(Landroid/content/Context;Lnet/noparking/projects/utl/Directory;Ljava/lang/String;)V", "_out", "Ljava/util/zip/ZipOutputStream;", "_path", "Ljava/io/File;", "getContext$app_debug", "()Landroid/content/Context;", "getFile_name$app_debug", "()Ljava/lang/String;", "name", "getName", "setName", "(Ljava/lang/String;)V", "getRoot$app_debug", "()Lnet/noparking/projects/utl/Directory;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "addContent", "", "file", "entry_name", "close", "generateName", "setPermissions", "app_debug"})
public final class ZipFile {
    private final java.io.File _path = null;
    @org.jetbrains.annotations.NotNull()
    private android.net.Uri uri;
    private java.util.zip.ZipOutputStream _out;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final net.noparking.projects.utl.Directory root = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String file_name = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getUri() {
        return null;
    }
    
    public final void setUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final java.lang.String generateName() {
        return null;
    }
    
    private final void setPermissions() {
    }
    
    public final void addContent(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    java.lang.String entry_name) {
    }
    
    public final void close() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.Directory getRoot$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFile_name$app_debug() {
        return null;
    }
    
    public ZipFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    net.noparking.projects.utl.Directory root, @org.jetbrains.annotations.Nullable()
    java.lang.String file_name) {
        super();
    }
}