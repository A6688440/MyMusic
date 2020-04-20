package com.example.mymusic.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/20.
 * Describe：
 */
public abstract class BaseObserver<BaseBean> implements Observer<BaseBean> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseBean bean) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

}
