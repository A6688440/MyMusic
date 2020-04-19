package com.example.mymusic.presenter;

import com.example.mymusic.base.view.BaseView;
import com.example.mymusic.http.BaseModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {

    private V mView;
    private M mModel;
    private CompositeDisposable mCompositeDisposable;

    //让子类去实现 具体的mModel
    public abstract M getmModelInstance();


    //绑定mView
    public void bingView(V mView) {
        this.mView = mView;
    }

    //解除绑定mView
    public void unBingView() {
        if (this.mModel != null) {
            this.mModel = null;
        }

    }


    public boolean isAttachView() {
        return mView != null;
    }

    //添加订阅者
    //网络请求时将订阅事件添加到容器中
    public void addRxSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }


}
