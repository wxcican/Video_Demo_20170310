package com.fuicuiedu.xc.video_demo_20170310.DemoB;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.fuicuiedu.xc.video_demo_20170310.R;
import com.fuicuiedu.xc.video_demo_20170310.VideoUrlRes;


public class DemoBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_b);

        //拿到VideoView
        VideoView videoView = (VideoView) findViewById(R.id.demo_b_vv);
        //设置数据源
        videoView.setVideoPath(VideoUrlRes.getTestVideo1());
        //开始播放
        videoView.start();

        //实例化控制器
        MediaController mediaController = new MediaController(this);
        //添加控制器
        videoView.setMediaController(mediaController);

    }
}
