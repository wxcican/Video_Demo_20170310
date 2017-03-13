package com.fuicuiedu.xc.video_demo_20170310.DemoC;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.fuicuiedu.xc.video_demo_20170310.R;
import com.fuicuiedu.xc.video_demo_20170310.VideoUrlRes;

import java.io.IOException;

import io.vov.vitamio.MediaPlayer;


public class DemoCActivity extends AppCompatActivity {

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_c);


        surfaceView = (SurfaceView) findViewById(R.id.demo_c_sv);
        surfaceHolder = surfaceView.getHolder();

        //使用surfaceView时，要对PixelFormat（像素格式）处理，否则会花屏！
        surfaceHolder.setFormat(PixelFormat.RGBA_8888);

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    mediaPlayer = new MediaPlayer(DemoCActivity.this);
                    mediaPlayer.setDisplay(surfaceHolder);
                    mediaPlayer.setDataSource(VideoUrlRes.getTestVideo1());
                    mediaPlayer.prepareAsync();

                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaPlayer.start();
                        }
                    });

                    //Vitamio5.0,需要进行Audio处理，才能对在线视频进行播放！！！
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                        @Override
                        public boolean onInfo(MediaPlayer mp, int what, int extra) {
                            if (what == MediaPlayer.MEDIA_INFO_FILE_OPEN_OK){
                                //进行Audio处理
                                mediaPlayer.audioInitedOk(mediaPlayer.audioTrackInit());
                                return true;
                            }
                            return false;
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });


    }
}
