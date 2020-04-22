package com.example.mymusic.mvp.retrofit;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SJC on 2020/4/20.
 * Describe：
 */
public class ApiRetrofit {
    private static ApiRetrofit apiRetrofit;
    private OkHttpClient client;
    private Retrofit retrofit;
    private Retrofit retrofitSong;
    private Retrofit retrofitSearch;
    private ApiService apiService;
    private ApiService apiServiceSong;
    private ApiService apiServiceSearch;

    private String TAG = "ApiRetrofit";


    /**
     * 请求访问quest
     * response拦截器
     */
    private Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            Response response = chain.proceed(chain.request());
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Log.e(TAG, "----------Request Start----------------");
            Log.e(TAG, "| " + request.toString() + request.headers().toString());
            Log.e(TAG, "| Response:" + content);
            Log.e(TAG, "----------Request End:" + duration + "毫秒----------");

            return response.newBuilder().body(ResponseBody.create(mediaType, content)).build();
        }
    };


    public ApiRetrofit() {

        client = new OkHttpClient.Builder()
                //添加拦截器
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.SINGER_PIC_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

                //添加Rx支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        retrofitSearch = new Retrofit.Builder()
                .baseUrl(Api.FIDDLER_BASE_QQ_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //添加Rx支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        retrofitSong = new Retrofit.Builder()
                .baseUrl(Api.FIDDLER_BASE_SONG_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //添加Rx支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();



        apiService = retrofit.create(ApiService.class);
        apiServiceSearch = retrofitSearch.create(ApiService.class);
        apiServiceSong = retrofitSong.create(ApiService.class);
    }

    public static ApiRetrofit getInstance() {
        if (apiRetrofit == null) {
            synchronized (Object.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new ApiRetrofit();
                }
            }
        }

        return apiRetrofit;
    }

    public static ApiRetrofit getInstanceSong() {
        if (apiRetrofit == null) {
            synchronized (Object.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new ApiRetrofit();
                }
            }
        }

        return apiRetrofit;
    }

    public static ApiRetrofit getInstanceSearch() {
        if (apiRetrofit == null) {
            synchronized (Object.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new ApiRetrofit();
                }
            }
        }

        return apiRetrofit;
    }



    public ApiService getApiService() {
        return apiService;
    }
    public ApiService getApiServiceSearch() {
        return apiServiceSearch;
    }
    public ApiService getApiServiceSong() {
        return apiServiceSong;
    }
}
