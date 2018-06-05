package net.noparking.projects.utl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lnet/noparking/projects/utl/ImagePicker;", "", "activity", "Landroid/app/Activity;", "directory", "Lnet/noparking/projects/utl/Directory;", "(Landroid/app/Activity;Lnet/noparking/projects/utl/Directory;)V", "_dialog", "Landroid/app/AlertDialog;", "_image", "Lnet/noparking/projects/utl/Image;", "getActivity$app_debug", "()Landroid/app/Activity;", "getDirectory$app_debug", "()Lnet/noparking/projects/utl/Directory;", "chooseImageFromCamera", "", "chooseImageFromGallery", "createImage", "initDialog", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "reset", "show", "stop", "Companion", "app_debug"})
public final class ImagePicker {
    private android.app.AlertDialog _dialog;
    private net.noparking.projects.utl.Image _image;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull()
    private final net.noparking.projects.utl.Directory directory = null;
    private static final int PICTURE_FROM_CAMERA_CODE = 0;
    private static final int PICTURE_FROM_GALLERY_CODE = 1;
    public static final net.noparking.projects.utl.ImagePicker.Companion Companion = null;
    
    public final void reset() {
    }
    
    public final void stop() {
    }
    
    private final void createImage() {
    }
    
    private final void initDialog() {
    }
    
    public final void show() {
    }
    
    private final void chooseImageFromCamera() {
    }
    
    private final void chooseImageFromGallery() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.Image onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getActivity$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.noparking.projects.utl.Directory getDirectory$app_debug() {
        return null;
    }
    
    public ImagePicker(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    net.noparking.projects.utl.Directory directory) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lnet/noparking/projects/utl/ImagePicker$Companion;", "", "()V", "PICTURE_FROM_CAMERA_CODE", "", "getPICTURE_FROM_CAMERA_CODE", "()I", "PICTURE_FROM_GALLERY_CODE", "getPICTURE_FROM_GALLERY_CODE", "app_debug"})
    public static final class Companion {
        
        public final int getPICTURE_FROM_CAMERA_CODE() {
            return 0;
        }
        
        public final int getPICTURE_FROM_GALLERY_CODE() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}