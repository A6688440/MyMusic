package com.example.mymusic.http.retrofit;

import com.example.mymusic.http.bean.SingerImgBean;

import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/19.
 * Describe：
 */
public interface IPlay<Bean> {

    void onSubscribe(Disposable d);


    void onNext(Bean mBean);


    void onError(Throwable e);


    void onComplete();
}
