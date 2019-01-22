package com.lib.easycapture;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

class EasyCapPermission {
    boolean camera(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permission = ContextCompat.checkSelfPermission(activity, CAMERA);
            if (permission == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(
                        activity,
                        new String[]{CAMERA},
                        EasyCapture.PERMISSION_CAMERA
                );
                return false;
            }
        }
        return true;
    }

    boolean writeStorage(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permission = ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE);
            if (permission == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(
                        activity,
                        new String[]{WRITE_EXTERNAL_STORAGE},
                        EasyCapture.PERMISSION_STORAGE
                );
                return false;
            }
        }
        return true;
    }
}
