package com.example.mymusic.mvp.presenter;

import com.example.mymusic.mvp.model.BaseModel;
import com.example.mymusic.mvp.view.BaseView;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public abstract class BasePresenter<V extends BaseView,M extends BaseModel,CONTRACT>  {

    public M mModel;

    public V mView;

    private final String TAG = "BasePresenter";


    //让子类去实现 具体的mModel
    public abstract M getModelInstance();

    public abstract  CONTRACT getContract();

    public BasePresenter() {
        this.mModel = getModelInstance();
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
