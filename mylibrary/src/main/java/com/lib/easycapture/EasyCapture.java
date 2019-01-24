package com.lib.easycapture;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.File;

public class EasyCapture {

    public static final int REQUEST_CODE = 201;
    static final int PERMISSION_REQUEST_CODE = 202;

    public File setImageFile(@NonNull Activity activity) {
        File mediaStorageDir = new File(
                activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                activity.getString(R.string.app_name)
        );
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
            Log.e("EasyCapture", "failed to create directory");
        }
        Long id = System.currentTimeMillis();
        return new File(mediaStorageDir.getPath() + File.separator + id + ".jpg");
    }

    public void openCamera(@NonNull Activity activity, @NonNull File file) {
        EasyCapturePermission permission = new EasyCapturePermission();
        if (permission.checked(activity)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            String providerAuth = activity.getString(R.string.easy_capture_provider_authorities);
            Uri uri = FileProvider.getUriForFile(activity, providerAuth, file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                activity.startActivityForResult(intent, REQUEST_CODE);
            }
        } else {
            permission.showPermissionDialog(activity);
        }
    }
}
