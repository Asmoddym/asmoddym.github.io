package net.noparking.projects.database.line_annotation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f0\u000eJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lnet/noparking/projects/database/line_annotation/LineAnnotationsCollector;", "", "()V", "_items_database", "Lnet/noparking/projects/database/line_annotation/LineAnnotationDatabase;", "get_items_database", "()Lnet/noparking/projects/database/line_annotation/LineAnnotationDatabase;", "set_items_database", "(Lnet/noparking/projects/database/line_annotation/LineAnnotationDatabase;)V", "add", "", "item", "Lnet/noparking/projects/database/line_annotation/LineAnnotation;", "getAll", "Landroid/arch/lifecycle/LiveData;", "", "getById", "id", "", "getByImageId", "getByLineId", "init", "context", "Landroid/content/Context;", "stop", "app_debug"})
public final class LineAnnotationsCollector {
    @org.jetbrains.annotations.Nullable()
    private net.noparking.projects.database.line_annotation.LineAnnotationDatabase _items_database;
    
    @org.jetbrains.annotations.Nullable()
    public final net.noparking.projects.database.line_annotation.LineAnnotationDatabase get_items_database() {
        return null;
    }
    
    public final void set_items_database(@org.jetbrains.annotations.Nullable()
    net.noparking.projects.database.line_annotation.LineAnnotationDatabase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line_annotation.LineAnnotationsCollector init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void add(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.line_annotation.LineAnnotation item) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.line_annotation.LineAnnotation>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.LiveData<java.util.List<net.noparking.projects.database.line_annotation.LineAnnotation>> getByImageId(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.LiveData<net.noparking.projects.database.line_annotation.LineAnnotation> getByLineId(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.LiveData<net.noparking.projects.database.line_annotation.LineAnnotation> getById(long id) {
        return null;
    }
    
    public final void stop() {
    }
    
    public LineAnnotationsCollector() {
        super();
    }
}