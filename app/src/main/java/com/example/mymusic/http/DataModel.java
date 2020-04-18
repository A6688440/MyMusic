package com.example.mymusic.http;

import com.example.mymusic.http.bean.SingerImgBean;

import io.reactivex.Observable;

/**
 * Created by SJC on 2020/4/18.
 * Describe：DataModel()-->(NetWorkHelper接口)-->NetWork()
 */
public class DataModel implements NetWorkHelper {

    private NetWork mNetWork;


    public DataModel(NetWork mNetWork) {
        this.mNetWork = mNetWork;
    }

    @Override
    public Observable<SingerImgBean> getSingerImg(String singer) {
        return mNetWork.getSingerImg(singer);
    }
}
