package com.easy.capture;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lib.easycapture.EasyCapture;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btnCapture;
    private File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        btnCapture = findViewById(R.id.btnCapture);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyCapture easyCapture = new EasyCapture();
                imageFile = easyCapture.setImageFile(MainActivity.this);
                easyCapture.openCamera(MainActivity.this, imageFile);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == EasyCapture.REQUEST_CODE) {
                loadImage(imageFile);
            }
        }
    }

    private void loadImage(File imageFile) {
        RequestOptions requestOptions = new RequestOptions()
                .override(512, 512);
        Glide.with(this).load(imageFile).apply(requestOptions).into(imageView);
    }
}
