package com.example.mymusic.http.retrofit.nouse;

import com.example.mymusic.http.bean.SingerImgBean;

import io.reactivex.Observable;

/**
 * Created by SJC on 2020/4/18.
 * Describe：DataModel()-->NetWork()-->RetrofitService()的接口
 */
public interface NetWorkHelper {

    //获取歌手的照片
    Observable<SingerImgBean> getSingerImg(String singer);


}
