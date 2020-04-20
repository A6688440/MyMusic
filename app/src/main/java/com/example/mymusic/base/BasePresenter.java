package com.example.mymusic.base;

import com.example.mymusic.http.retrofit.ApiRetrofit;
import com.example.mymusic.http.retrofit.ApiService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {

    public M mModel;

    public V mView;

    private final String TAG = "BasePresenter";


    //让子类去实现 具体的mModel
    public abstract M getmModelInstance();


    public BasePresenter() {
        this.mModel = getmModelInstance();
    }


    //绑定mView
    public void bingView(V mView) {
        this.mView = mView;
    }

    /**
     * 解除绑定
     */
    public void unBindView() {
        mView = null;

    }







}
