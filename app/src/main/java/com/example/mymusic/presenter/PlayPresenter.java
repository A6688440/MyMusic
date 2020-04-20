package com.example.mymusic.presenter;

import android.util.Log;

import com.example.mymusic.base.BasePresenter;
import com.example.mymusic.http.bean.SingerImgBean;
import com.example.mymusic.model.PlayModel;
import com.example.mymusic.view.IPlayContract;
import com.example.mymusic.view.MainActivity;


/**
 * Created by SJC on 2020/4/19.
 * Describe：
 */
public class PlayPresenter extends BasePresenter<MainActivity, PlayModel> implements IPlayContract.P<SingerImgBean> {

    private final String TAG = "123456";


    @Override
    public PlayModel getmModelInstance() {
        return new PlayModel(this);
    }



    @Override
    public void onRequest(String SingerName) {
        mModel.onRequest(SingerName);
    }

    @Override
    public void onNext(SingerImgBean singerImgBean) {
        Log.e(TAG, "onResponse: "+singerImgBean.getResult().getArtists().get(0).getImg1v1Url() );
        mView.getSingerImg(singerImgBean.getResult().getArtists().get(0).getImg1v1Url());
    }

    @Override
    public void onError(Throwable e) {

    }


}
