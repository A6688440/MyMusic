package com.example.mymusic.http;

import com.example.mymusic.presenter.BasePresenter;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public abstract class BaseModel<P extends BasePresenter> {

    public P mPresenter;

    public BaseModel(P mPresenter) {
        this.mPresenter = mPresenter;
    }
    //    public BaseModel(P mPresenter) {
//        this.mPresenter = mPresenter;
//    }
  //  public abstract NetWork getNetWorkInstance();

}
