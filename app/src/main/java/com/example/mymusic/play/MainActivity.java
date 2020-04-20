package com.example.mymusic.play;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.bumptech.glide.Glide;
import com.example.mymusic.MainFragment;
import com.example.mymusic.R;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.view.BaseActivity;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity<PlayPresenter,IPlayContract.V> {


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



    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onClick() {

    }

    @Override
    protected PlayPresenter getmPresenterInstance() {
        return new PlayPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new MainFragment())
                .commit();

        mPresenter.getContract().getSingerImgUrl("邓紫棋");

    }

    @Override
    public IPlayContract.V getContract() {
        return SingerImgUrl -> Glide.with(MainActivity.this).load(SingerImgUrl).into(circleSingerImage);
    }


    @Override
    public void onSuccess(Object object) {
       // String url = object.toString();

    }


    @Override
    public void onFail(ExceptionHandle.ResponseThrowable t) {

    }

    @Override
    public void OnCompleted() {

    }
}
