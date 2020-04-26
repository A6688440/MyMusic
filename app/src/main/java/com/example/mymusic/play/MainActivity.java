package com.example.mymusic.play;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mymusic.R;
import com.example.mymusic.event.EventMessage;
import com.example.mymusic.mvp.view.BaseActivity;
import com.example.mymusic.search.view_model.SongIdViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity<PlayPresenter, IPlayContract.V> {

    private final String TAG="MainActivity";

    @BindView(R.id.play_seek_bar)
    SeekBar playSeekBar;
    @BindView(R.id.song_name)
    TextView songName;
    @BindView(R.id.btn_player)
    Button btnPlayer;
    @BindView(R.id.song_next)
    RippleView songNext;
    @BindView(R.id.circle_singer_image)
    CircleImageView circleSingerImage;
    @BindView(R.id.main_play)
    RelativeLayout mainPlay;

    private MediaPlayer mMediaPlayer;
    private Timer timer;


    private SongIdViewModel songIdViewModel;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        songIdViewModel=new ViewModelProvider(this).get(SongIdViewModel.class);
    }

    @Override
    protected void initData() {
        songIdViewModel.getSingId().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChanged: "+s );

            }
        });
    }


    @Override
    protected PlayPresenter getmPresenterInstance() {
        return new PlayPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

//        Glide.with(MainActivity.this)
//                .load("http://p1.music.126.net/R5fsMgpLHC9mJbLLA6EKLA==/109951164561120345.jpg")
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(circleSingerImage);
//        mPresenter.getContract().getSingerImgUrl("邓紫棋");
//        mPresenter.getContract().getSearch("艾热");



    }

    @Override
    public IPlayContract.V getContract() {
        return new IPlayContract.V() {
            @Override
            public void getSingerImgUrl(String SingerImgUrl) {
                Glide.with(MainActivity.this)
                        .load(SingerImgUrl)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(circleSingerImage);
            }

            @Override
            public void getSongUrl(String songUrl) {
               // int SongTime=0;
                mMediaPlayer = new MediaPlayer();
                try {
                    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mMediaPlayer.setDataSource(songUrl);
                    mMediaPlayer.prepare();
                    mMediaPlayer.setVolume(1f, 1f);
                    mMediaPlayer.start();
                    btnPlayer.setSelected(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                playSeekBar.setMax(mMediaPlayer.getDuration());//设置最长的进度条
                getProgress();
            }

        };
    }


    private void getProgress() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //获取歌曲的进度
                int p = mMediaPlayer.getCurrentPosition();
                //将获取歌曲的进度赋值给seekbar
                playSeekBar.setProgress(p);
            }
        }, 500);

        playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //获取进度条的进度
                int p = seekBar.getProgress();
                //将进度条的进度赋值给歌曲
                mMediaPlayer.seekTo(p);
                //开始音乐继续获取歌曲的进度
                getProgress();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //取消timer任务
                stopTimer();
            }

            private void stopTimer() {
                if (timer != null) {
                    timer.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @OnClick({R.id.btn_player, R.id.song_next, R.id.main_play})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_player:
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    btnPlayer.setSelected(false);
                } else {
                    mMediaPlayer.start();
                    btnPlayer.setSelected(true);
                }
                break;

            case R.id.song_next:
                break;

            case R.id.main_play:
                break;
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void SetFragmentEventMessage(EventMessage message) {

    }

    @Override
    public void onBackPressed() {
//        if (isShowView) {
//            isShowView = false;
//
//            fragmentSearch.setVisibility(View.GONE);
//            fragmentMain.setVisibility(View.VISIBLE);
//            return;
//
//        } else {
            super.onBackPressed();
//        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
