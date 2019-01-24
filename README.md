# EasyCapture
EasyCapture android camera library
- Using Intent(MediaStore.ACTION_IMAGE_CAPTURE)
- Using file provider so it's support for android nougat 7.0 or above
- Already handled for runtime permission

![](https://s2.gifyu.com/images/easy-capture.gif)

# Setup

```xml
<!-- Add it into your string.xml -->
<string name="easy_capture_provider_authorities" translatable="false">your.package.name.provider</string>
```

```xml
<!-- Add it into your AndroidManifest.xml -->
<!-- Make sure the android:authorities value same as easy_capture_provider_authorities on your string -->
<provider
    android:name="android.support.v4.content.FileProvider"
    android:authorities="your.package.name.provider"
    android:exported="false"
    android:grantUriPermissions="true">
        <meta-data
            android:name="android.support.FILE_PROVIDER_PATHS"
            android:resource="@xml/provider_paths" />
</provider>
```

```java
// Add jitpack.io on your gradle root
repositories {
    maven { url 'https://jitpack.io' }
}
```

```java
// Add EasyCapture on your gradle app
dependencies {
    implementation 'com.github.firdausmaulan:EasyCapture:1.0.1'
}
```

# Example

```java
File imageFile;
EasyCapture easyCapture = new EasyCapture();

yourLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        imageFile = easyCapture.setImageFile(YourActivity.this);
        easyCapture.openCamera(YourActivity.this, imageFile);
    }
});

@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == Activity.RESULT_OK) {
        if (requestCode == EasyCapture.REQUEST_CODE) {
            //loadImage(imageFile);
        }
    }
}
```

[Click here for full example](https://github.com/firdausmaulan/EasyCapture/blob/master/app/src/main/java/com/easy/capture/MainActivity.java)
