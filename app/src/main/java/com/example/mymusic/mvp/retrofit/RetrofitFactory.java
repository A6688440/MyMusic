package com.example.mymusic.mvp.retrofit;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SJC on 2020/4/18.
 * Describe：封装Retrofit，方便外部调用
 */
public class RetrofitFactory {

    private static OkHttpClient sOkHttpClient;
    private static Retrofit sRetrofit;
    private static Retrofit songUrlRetrofit;
    private static Retrofit sSingPicRetrofit;




    //获取接口实例

    //创建网络请求Observable
    public static ApiService createRequest() {
        return getsRetrofit().create(ApiService.class);
    }

    //创建获取歌手照片的网络请求
    public static ApiService createRequestOfSinger() {
        return getRetrofitOfSinger().create(ApiService.class);
    }

    //创建获取歌曲Url的网络请求
    public static ApiService createRequestOfSongUrl() {
        return getRetrofitOfSongUrl().create(ApiService.class);
    }


    //配置OkHttp
    private synchronized static OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> {
                //打印retrofit日志
                Log.i("RetrofitLog","retrofitBack = "+message);
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            sOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100,TimeUnit.SECONDS)
                    .writeTimeout(100,TimeUnit.SECONDS)
                    //.addInterceptor(loggingInterceptor)  日志
                    .build();
        }
        return sOkHttpClient;
    }



    //配置Retrofit 单例模式
    private synchronized static Retrofit getsRetrofit() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Api.SINGER_PIC_BASE_URL) //对用服务器的host
//                    .client(sOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 把Retrofit请求转化成RxJava的Observable
                    .build();
        }
        return sRetrofit;
    }

    //获取歌手照片
    private synchronized static Retrofit getRetrofitOfSinger() {
        if (sSingPicRetrofit == null) {
            sSingPicRetrofit = new Retrofit.Builder()
                    .baseUrl(Api.SINGER_PIC_BASE_URL)
                    .client(sOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sSingPicRetrofit;
    }

    //得到播放地址
    private synchronized static Retrofit getRetrofitOfSongUrl() {
        if (songUrlRetrofit == null) {
            songUrlRetrofit = new Retrofit.Builder()
                    .baseUrl(" ")// 对应服务端的ho
                    .client(sOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())// 这里还结合了Gson
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 把Retrofit请求转化成RxJava的Observable
                    .build();
        }
        return songUrlRetrofit;
    }


}
