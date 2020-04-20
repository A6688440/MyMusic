package com.example.mymusic.model;

import android.util.Log;

import com.example.mymusic.base.BaseModel;
import com.example.mymusic.http.bean.SingerImgBean;
import com.example.mymusic.http.retrofit.ApiRetrofit;
import com.example.mymusic.http.retrofit.ApiService;
import com.example.mymusic.presenter.PlayPresenter;
import com.example.mymusic.view.IPlayContract;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

/**
 * Created by SJC on 2020/4/19.
 * Describe：model 实现网络请求
 */
public class PlayModel extends BaseModel<PlayPresenter, SingerImgBean> implements IPlayContract.M {

    private final String TAG = "123456";

    public PlayModel(PlayPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public void onRequest(String SingerName) {
        ApiService service = ApiRetrofit.getInstance().getApiService();
        service.getSingerImg(SingerName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SingerImgBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SingerImgBean singerImgBean) {
                        mPresenter.onNext(singerImgBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}
