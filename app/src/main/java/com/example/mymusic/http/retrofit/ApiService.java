package com.example.mymusic.http.retrofit;

import com.example.mymusic.http.Api;
import com.example.mymusic.http.bean.SingerImgBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by SJC on 2020/4/18.
 * Describe：Retrofit的接口
 */
public interface ApiService {


    /**
     * 得到歌手照片，主要用于本地音乐：http://music.163.com/api/search/get/web?s=刘瑞琦&type=100
     * @param singer 歌手的名字
     * @return
     */

    @Headers(Api.HEADER_USER_AGENT)
    @POST(Api.SINGER_PIC)
    @FormUrlEncoded
    Observable<SingerImgBean> getSingerImg(@Field("s")String singer);


}
