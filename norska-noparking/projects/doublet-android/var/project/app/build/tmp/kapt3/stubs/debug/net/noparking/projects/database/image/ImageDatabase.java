package net.noparking.projects.database.image;

import java.lang.System;

@android.arch.persistence.room.Database(entities = {net.noparking.projects.database.image.Image.class}, version = 7)
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lnet/noparking/projects/database/image/ImageDatabase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "ImageDataDao", "Lnet/noparking/projects/database/image/ImageDataDao;", "Companion", "app_debug"})
public abstract class ImageDatabase extends android.arch.persistence.room.RoomDatabase {
    private static net.noparking.projects.database.image.ImageDatabase INSTANCE;
    public static final net.noparking.projects.database.image.ImageDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract net.noparking.projects.database.image.ImageDataDao ImageDataDao();
    
    public ImageDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lnet/noparking/projects/database/image/ImageDatabase$Companion;", "", "()V", "INSTANCE", "Lnet/noparking/projects/database/image/ImageDatabase;", "getINSTANCE", "()Lnet/noparking/projects/database/image/ImageDatabase;", "setINSTANCE", "(Lnet/noparking/projects/database/image/ImageDatabase;)V", "destroyInstance", "", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private final net.noparking.projects.database.image.ImageDatabase getINSTANCE() {
            return null;
        }
        
        private final void setINSTANCE(net.noparking.projects.database.image.ImageDatabase p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final net.noparking.projects.database.image.ImageDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        public final void destroyInstance() {
        }
        
        private Companion() {
            super();
        }
    }
}