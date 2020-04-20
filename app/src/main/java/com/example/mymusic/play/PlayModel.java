package com.example.mymusic.play;

import com.example.mymusic.bean.SingerImgBean;
import com.example.mymusic.mvp.model.BaseModel;
import com.example.mymusic.mvp.retrofit.ApiRetrofit;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SJC on 2020/4/19.
 * Describe：model 实现网络请求
 */
public  class PlayModel extends BaseModel<PlayPresenter, IPlayContract.M> {

    private final String TAG = "123456";

    public PlayModel(PlayPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IPlayContract.M getContract() {
        return (singerName, observer) -> {
            Observable<SingerImgBean> getSingerImgUrl = ApiRetrofit
                    .getInstance()
                    .getApiService()
                    .getSingerImg(singerName);
            getSingerImgUrl
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        };
    }

}
