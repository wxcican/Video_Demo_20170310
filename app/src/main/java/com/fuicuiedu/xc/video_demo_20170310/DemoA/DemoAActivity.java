package com.fuicuiedu.xc.video_demo_20170310.DemoA;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;

import com.fuicuiedu.xc.video_demo_20170310.R;
import com.fuicuiedu.xc.video_demo_20170310.VideoUrlRes;

import java.io.IOException;


public class DemoAActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    private TextureView textureView;
    private Surface mySurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_a);


        //拿到textureView控件
        textureView = (TextureView) findViewById(R.id.demo_a_ttv);

        //添加监听
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                //当SurfaceTexture创建好时触发
                try {
                    mediaPlayer = new MediaPlayer();
                    mySurface = new Surface(surface);//拿到Surface实例
                    mediaPlayer.setSurface(mySurface);//将Surface绑定到mediaplayer身上
                    mediaPlayer.setDataSource(VideoUrlRes.getTestVideo1());
                    mediaPlayer.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                    }
                });
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
                //SurfaceTexture缓冲区大小发生改变时触发
            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                //SurfaceTexture即将销毁时触发此方法
                mediaPlayer.stop();
                mySurface.release();//释放相关资源
                mySurface = null;
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
                //SurfaceTexture更新时触发此方法
            }
        });

        textureView.setAlpha(0.5f);//透明度
        textureView.setRotation(50.0f);//旋转角度














//        surfaceView = (SurfaceView) findViewById(R.id.demo_a_sv);
//        //surfaceView中内嵌了一个专门用于绘制的Surface，为我们做视频画面的处理。
//        //如何拿到Surface？
//        //SurfaceView提供了SurfaceHolder接口访问这个surface，getHolder()方法可以得到这个接口。
//        surfaceHolder = surfaceView.getHolder();
//        //我们怎么知道Surface有没有创建好呢？有没有变化？有没有销毁？
//        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//                //surface创建成功时触发
//                try {
//                    //拿到Mediaplayer实例
//                    mediaPlayer = new MediaPlayer();
//                    //绑定SurfaceHolder
//                    mediaPlayer.setDisplay(surfaceHolder);
//                    //设置数据源
//                    mediaPlayer.setDataSource(VideoUrlRes.getTestVideo1());
//                    //准备播放
//                    mediaPlayer.prepareAsync();
//
//                    //监听是否准备好
//                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                        @Override
//                        public void onPrepared(MediaPlayer mp) {
//                            //准备好后，播放视频
//                            mediaPlayer.start();
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//                //surface大小改变时触发
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//                //surface销毁时触发
//                mediaPlayer.stop();//停止播放
//                mediaPlayer.release();//释放相关资源
//            }
//        });
    }
}
