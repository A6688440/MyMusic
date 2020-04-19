package com.example.mymusic.model;

import com.example.mymusic.http.BaseModel;
import com.example.mymusic.http.bean.Bean;
import com.example.mymusic.http.bean.SingerImgBean;
import com.example.mymusic.http.retrofit.IPlay;
import com.example.mymusic.http.retrofit.RetrofitFactory;
import com.example.mymusic.http.retrofit.RetrofitService;
import com.example.mymusic.presenter.BasePresenter;
import com.example.mymusic.presenter.PlayPresenter;
import com.example.mymusic.view.IPlayContract;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by SJC on 2020/4/19.
 * Describe：model 实现网络请求
 */
public class PlayModel extends BaseModel<PlayPresenter> implements IPlayContract.P {


    public PlayModel(PlayPresenter mPresenter) {
        super(mPresenter);
    }


    @Override
    public void onRequest(String singer) {
        RetrofitFactory.createRequest()
                .getSingImg(singer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SingerImgBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SingerImgBean singerImgBean) {
                        mPresenter.onResponse(singerImgBean);
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
