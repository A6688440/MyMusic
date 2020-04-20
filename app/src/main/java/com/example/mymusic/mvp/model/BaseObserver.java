package com.example.mymusic.mvp.model;

import com.example.mymusic.mvp.erroe.ExceptionHandle;

import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/20.
 * Describe：
 */
public abstract class BaseObserver<T> implements io.reactivex.Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        OnDisposable(d);
    }

    @Override
    public void onNext(T t) {
        OnSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        OnFail(ExceptionHandle.handleException(e));
    }

    @Override
    public void onComplete() {
        OnCompleted();
    }

    //子类必须实现的方法
    public abstract void OnSuccess(T t);

    public abstract void OnFail(ExceptionHandle.ResponseThrowable e);

    public abstract void OnCompleted();

    public abstract void OnDisposable(Disposable d);
}
