package com.lib.easycapture;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

class EasyCapturePermission {

    private String[] permissions = {CAMERA, WRITE_EXTERNAL_STORAGE};

    boolean checked(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission : permissions) {
                int currentPermission = ActivityCompat.checkSelfPermission(activity, permission);
                if (currentPermission != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    void showPermissionDialog(Activity activity) {
        ActivityCompat.requestPermissions(activity, permissions, EasyCapture.PERMISSION_REQUEST_CODE);
    }
}
