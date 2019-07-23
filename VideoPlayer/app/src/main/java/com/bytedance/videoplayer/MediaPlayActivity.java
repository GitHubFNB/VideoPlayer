package com.bytedance.videoplayer;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.io.IOException;


public class MediaPlayActivity extends AppCompatActivity {

    private  VideoView videoView;
    private MediaPlayer player;
    private SurfaceHolder holder;

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration configuration= this.getResources().getConfiguration();
        int ori = configuration.orientation ;

        MediaController mediaController = new MediaController(this);
        Uri uri = Uri.parse("android.resource://" + "com.bytedance.videoplayer" + "/raw/" + R.raw.bytedance);
        if(ori == configuration.ORIENTATION_LANDSCAPE){// 横屏
            setContentView(R.layout.activity_media_play_full);

            videoView = findViewById(R.id.videoViewFull);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();

        }else if(ori == configuration.ORIENTATION_PORTRAIT){
        // 竖屏
            setContentView(R.layout.activity_media_play);
            videoView = findViewById(R.id.videoView);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
        }


    }


}
