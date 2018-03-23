package com.kwz.applibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.load.engine.GlideException;
import com.kwz.glideimageview.GlideImageView;
import com.kwz.glideimageview.progress.CircleProgressView;
import com.kwz.glideimageview.progress.OnGlideImageViewListener;

public class MainActivity extends AppCompatActivity {

    GlideImageView ivIcon;
    public static final String girl_thumbnail = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl_thumbnail.jpg";
    public static final String girl = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl.jpg";

    private CircleProgressView progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivIcon = findViewById(R.id.ivIcon);
        progressView = findViewById(R.id.progressView);
//        RequestOptions requestOptions = ivIcon.getImageLoader().requestOptions(R.color.placeholder_color);
//        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
//
////        ivIcon.load(girl, requestOptions).listener(new OnGlideImageViewListener() {
////            @Override
////            public void onProgress(int percent, boolean isDone, GlideException exception) {
////                Log.i("-->>image32", "percent: " + percent + " isDone: " + isDone);
////            }
////        });
        ivIcon.loadImage(girl, android.R.color.black).listener(new OnGlideImageViewListener() {

            @Override
            public void onProgress(int percent, boolean isDone, GlideException exception) {
                if (exception != null && !TextUtils.isEmpty(exception.getMessage())) {
                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                }
                progressView.setProgress(percent);
                progressView.setVisibility(isDone ? View.GONE : View.VISIBLE);
                progressView.setProgress(percent);
            }
        });

//        RequestOptions requestOptions = ivIcon.requestOptions(android.R.color.black)
//                .centerCrop();
//        RequestOptions requestOptionsWithoutCache = ivIcon.requestOptions(android.R.color.black)
//                .centerCrop()
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.NONE);
//
//        GlideImageLoader imageLoader = ivIcon.getImageLoader();
//
//        imageLoader.setOnGlideImageViewListener(girl, new OnGlideImageViewListener() {
//            @Override
//            public void onProgress(int percent, boolean isDone, GlideException exception) {
//                Log.i("-->>image32", "percent: " + percent + " isDone: " + isDone);
//            }
//        });
//        imageLoader.setOnProgressListener(girl, new OnProgressListener() {
//            @Override
//            public void onProgress(String imageUrl, long bytesRead, long totalBytes, boolean isDone, GlideException exception) {
//                Log.i("-->>image34", "percent: " + bytesRead + " isDone: " + isDone);
//            }
//        });
//
//        imageLoader.requestBuilder(girl, requestOptionsWithoutCache)
//                .thumbnail(Glide.with(MainActivity.this)
//                        .load(girl_thumbnail)
//                        .apply(requestOptions))
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .into(ivIcon);
    }
}
