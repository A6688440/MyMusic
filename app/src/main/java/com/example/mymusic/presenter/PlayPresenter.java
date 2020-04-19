package com.example.mymusic.presenter;

import com.example.mymusic.base.activity.BaseActivity;
import com.example.mymusic.http.BaseModel;
import com.example.mymusic.http.bean.SingerImgBean;
import com.example.mymusic.model.PlayModel;
import com.example.mymusic.view.IPlayContract;


/**
 * Created by SJC on 2020/4/19.
 * Describe：
 */
public class PlayPresenter extends BasePresenter<PlayModel,BaseActivity> implements IPlayContract.M<SingerImgBean> {

    @Override
    public PlayModel getmModelInstance() {
        return new PlayModel(this);
    }



    @Override
    public void onResponse(SingerImgBean singerImgBean) {
        //处理数据
    }


}
