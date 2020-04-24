package com.example.mymusic.mvp.model;

import com.example.mymusic.mvp.presenter.BasePresenter;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public abstract class BaseModel<P extends BasePresenter, CONTRACT> {

    public P mPresenter;

    public BaseModel(P mPresenter) {
        this.mPresenter = mPresenter;
    }

    public abstract CONTRACT getContract();

}
