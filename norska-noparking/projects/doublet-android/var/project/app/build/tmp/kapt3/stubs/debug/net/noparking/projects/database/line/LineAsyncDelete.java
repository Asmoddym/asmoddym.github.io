package net.noparking.projects.database.line;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ#\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0016\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lnet/noparking/projects/database/line/LineAsyncDelete;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "()V", "_func", "Lkotlin/Function0;", "", "_id", "", "Ljava/lang/Long;", "_image_id", "_items_database", "Lnet/noparking/projects/database/line/LineDatabase;", "_polygon_id", "afterQuery", "func", "deleteById", "id", "deleteByImageId", "deleteByPolygonId", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "init", "context", "Landroid/content/Context;", "onPostExecute", "result", "app_debug"})
public final class LineAsyncDelete extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
    private net.noparking.projects.database.line.LineDatabase _items_database;
    private kotlin.jvm.functions.Function0<kotlin.Unit> _func;
    private java.lang.Long _polygon_id;
    private java.lang.Long _image_id;
    private java.lang.Long _id;
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line.LineAsyncDelete init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
    java.lang.Void... params) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line.LineAsyncDelete deleteByImageId(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line.LineAsyncDelete deleteById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line.LineAsyncDelete deleteByPolygonId(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.database.line.LineAsyncDelete afterQuery(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> func) {
        return null;
    }
    
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.Void result) {
    }
    
    public LineAsyncDelete() {
        super();
    }
}