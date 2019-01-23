# EasyCapture
EasyCapture android camera library
- Using Intent(MediaStore.ACTION_IMAGE_CAPTURE)
- Using file provider so it's support for android nougat 7.0 or above
- Already handled for runtime permission

![](https://s2.gifyu.com/images/easycapture.gif)

# Setup

```java
// Add jitpack.io on your gradle root
repositories {
    maven { url 'https://jitpack.io' }
}
```

```java
// Add EasyCapture on your gradle app
dependencies {
    implementation 'com.github.firdausmaulan:EasyCapture:1.0.0'
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
