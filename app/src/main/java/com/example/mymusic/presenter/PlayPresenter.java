package com.example.mymusic.presenter;

import com.example.mymusic.base.activity.BaseActivity;
import com.example.mymusic.http.BaseModel;
import com.example.mymusic.model.PlayModel;


/**
 * Created by SJC on 2020/4/19.
 * Describe：
 */
public class PlayPresenter extends BasePresenter {


    @Override
    public BaseModel getmModelInstance() {
        return new PlayModel();
    }
}
