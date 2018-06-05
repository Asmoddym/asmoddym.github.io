package net.noparking.projects.database.project;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0012\u001a\u00020\u00002\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00070\u0006J#\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0016\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0017\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0002\u0010\u001dR*\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lnet/noparking/projects/database/project/ProjectAsyncInsert;", "Landroid/os/AsyncTask;", "Lnet/noparking/projects/database/project/Project;", "", "()V", "_func", "Lkotlin/Function1;", "", "get_func", "()Lkotlin/jvm/functions/Function1;", "set_func", "(Lkotlin/jvm/functions/Function1;)V", "_items_database", "Lnet/noparking/projects/database/project/ProjectDatabase;", "get_items_database", "()Lnet/noparking/projects/database/project/ProjectDatabase;", "set_items_database", "(Lnet/noparking/projects/database/project/ProjectDatabase;)V", "afterQuery", "func", "doInBackground", "params", "", "([Lnet/noparking/projects/database/project/Project;)Ljava/lang/Long;", "init", "context", "Landroid/content/Context;", "onPostExecute", "result", "(Ljava/lang/Long;)V", "app_release"})
public final class ProjectAsyncInsert extends android.os.AsyncTask<net.noparking.projects.database.project.Project, java.lang.Long, java.lang.Long> {
    @org.jetbrains.annotations.Nullable()
    private net.noparking.projects.database.project.ProjectDatabase _items_database;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> _func;
    
    @org.jetbrains.annotations.Nullable()
    public final net.noparking.projects.database.project.ProjectDatabase get_items_database() {
        return null;
    }
    
    public final void set_items_database(@org.jetbrains.annotations.Nullable()
    net.noparking.projects.database.project.ProjectDatabase p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> get_func() {
        return null;
    }
    
    public final void set_func(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.project.ProjectAsyncInsert init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Long doInBackground(@org.jetbrains.annotations.NotNull()
    net.noparking.projects.database.project.Project... params) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.project.ProjectAsyncInsert afterQuery(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> func) {
        return null;
    }
    
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.Long result) {
    }
    
    public ProjectAsyncInsert() {
        super();
    }
}