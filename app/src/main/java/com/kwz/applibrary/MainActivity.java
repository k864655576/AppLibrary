package com.kwz.applibrary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kang.library.widget.banner.Banner;
import com.kang.library.widget.banner.BannerConfig;
import com.kang.library.widget.banner.listener.OnBannerListener;
import com.kang.library.widget.banner.loader.ImageLoader;
import com.kang.library.widget.banner.loader.ImageLoaderInterface;
import com.kang.library.widget.banner.transformer.CubeOutTransformer;
import com.kwz.glideimageview.progress.GlideApp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.kang.library.widget.banner.BannerConfig.NUM_INDICATOR;


public class MainActivity extends AppCompatActivity {

    Banner banner;
    TextView tv;


//    GlideImageView ivIcon;
//    public static final String girl_thumbnail = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl_thumbnail.jpg";
//    public static final String girl = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl.jpg";
//
//    private CircleProgressView progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ivIcon = findViewById(R.id.ivIcon);
//        progressView = findViewById(R.id.progressView);
//        RequestOptions requestOptions = ivIcon.getImageLoader().requestOptions(R.color.placeholder_color);
//        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
//
//        ivIcon.load(girl, requestOptions).listener(new OnGlideImageViewListener() {
//            @Override
//            public void onProgress(int percent, boolean isDone, GlideException exception) {
//                Log.i("-->>image32", "percent: " + percent + " isDone: " + isDone);
//            }
//        });
//        ivIcon.loadImage(girl, android.R.color.black).listener(new OnGlideImageViewListener() {
//
//            @Override
//            public void onProgress(int percent, boolean isDone, GlideException exception) {
//                if (exception != null && !TextUtils.isEmpty(exception.getMessage())) {
//                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
//                }
//                progressView.setProgress(percent);
//                progressView.setVisibility(isDone ? View.GONE : View.VISIBLE);
//                progressView.setProgress(percent);
//            }
//        });

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

        banner = findViewById(R.id.banners);
        tv = findViewById(R.id.tv);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        List<String> listImage = new ArrayList<>();
        listImage.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
        listImage.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        listImage.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
//
//        List<String> titles = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            titles.add("数据源" + i);
//        }
        banner.setBannerAnimation(CubeOutTransformer.class).setIndicatorGravity(BannerConfig.RIGHT).setIndicatorGravity(BannerConfig.CENTER);

        banner.setImages(listImage).setImageLoader(new GlideImageLoader()).setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        }).start();

    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            GlideApp.with(context).load(path).into(imageView);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
