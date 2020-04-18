package com.example.mymusic.http.retrofit;

import android.util.Log;

import com.example.mymusic.http.Api;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
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
    public static RetrofitService createRequest() {
        return getsRetrofit().create(RetrofitService.class);
    }

    //创建获取歌手照片的网络请求
    public static RetrofitService createRequestOfSinger() {
        return getRetrofitOfSinger().create(RetrofitService.class);
    }

    //创建获取歌曲Url的网络请求
    public static RetrofitService createRequestOfSongUrl() {
        return getRetrofitOfSongUrl().create(RetrofitService.class);
    }



    //配置OkHttp
    private synchronized static OkHttpClient getsOkHttpClient() {
        if (sOkHttpClient == null) {
            //消息拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                    message -> Log.i("RetrofitLog", "retrofit" + message)
            );
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            sOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    //.addInterceptor(loggingInterceptor)
                    .build();
        }
        return getsOkHttpClient();
    }

    //配置Retrofit 单例模式
    private synchronized static Retrofit getsRetrofit() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl("") //对用服务器的host
                    .client(getsOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 把Retrofit请求转化成RxJava的Observable
                    .build();
        }
        return sRetrofit;
    }

    //获取歌手照片
    private synchronized static Retrofit getRetrofitOfSinger() {
        if (sSingPicRetrofit == null) {
            sSingPicRetrofit = new Retrofit.Builder()
                    .baseUrl(Api.SINGER_PIC_BASE_URL)
                    .client(getsOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return sSingPicRetrofit;
    }

    //得到播放地址
    private synchronized static Retrofit getRetrofitOfSongUrl() {
        if (songUrlRetrofit == null) {
            songUrlRetrofit = new Retrofit.Builder()
                    .baseUrl(" ")// 对应服务端的ho
                    .client(getsOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())// 这里还结合了Gson
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 把Retrofit请求转化成RxJava的Observable
                    .build();
        }
        return songUrlRetrofit;
    }


}
