package com.example.mymusic.http;

import com.example.mymusic.http.bean.SingerImgBean;
import com.example.mymusic.http.retrofit.RetrofitService;

import io.reactivex.Observable;

/**
 * Created by SJC on 2020/4/18.
 * Describe：网络请求操作的实现类
 * NetWork()-->(NetWorkHelper接口)-->RetrofitService()
 */
public class NetWork implements NetWorkHelper {

    private RetrofitService mRetrofitService;

    public NetWork(RetrofitService mRetrofitService) {
        this.mRetrofitService = mRetrofitService;
    }

    @Override
    public Observable<SingerImgBean> getSingerImg(String singer) {
        return mRetrofitService.getSingImg(singer);
    }
}
