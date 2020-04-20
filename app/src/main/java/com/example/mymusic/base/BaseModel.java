package com.example.mymusic.base;

import java.io.Serializable;

/**
 * Created by SJC on 2020/4/18.
 * Describe：
 */
public abstract class BaseModel<P extends BasePresenter,Bean>{

    public P mPresenter;


    public BaseModel(P mPresenter) {
        this.mPresenter = mPresenter;
    }

}
