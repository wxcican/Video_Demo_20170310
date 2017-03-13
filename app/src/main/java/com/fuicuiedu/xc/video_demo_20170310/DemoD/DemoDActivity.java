package com.fuicuiedu.xc.video_demo_20170310.DemoD;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fuicuiedu.xc.video_demo_20170310.R;
import com.fuicuiedu.xc.video_demo_20170310.VideoUrlRes;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


public class DemoDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_d);

        VideoView videoView = (VideoView) findViewById(R.id.demo_d_vv);

        videoView.setVideoPath(VideoUrlRes.getTestVideo1());

        videoView.start();

        //实例化控制器(注意，是Vitamio中的MediaController)
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);


    }
}
