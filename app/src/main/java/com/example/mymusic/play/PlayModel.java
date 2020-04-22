package com.example.mymusic.play;

import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.bean.SingerImgBean;
import com.example.mymusic.bean.SongUrlBean;
import com.example.mymusic.mvp.model.BaseModel;
import com.example.mymusic.mvp.retrofit.Api;
import com.example.mymusic.mvp.retrofit.ApiRetrofit;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SJC on 2020/4/19.
 * Describe：model 实现网络请求
 */
public  class PlayModel extends BaseModel<PlayPresenter, IPlayContract.M> {

    private final String TAG = "123456";

    public PlayModel(PlayPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public IPlayContract.M getContract() {
        return new IPlayContract.M() {
            @Override
            public void getSingerImgUrl(String singerName, Observer<SingerImgBean> observer) {
                    Observable<SingerImgBean> getSingerImgUrl = ApiRetrofit
                            .getInstance()
                            .getApiService()
                            .getSingerImg(singerName);
                    getSingerImgUrl
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(observer);

            }

            @Override
            public void getSearchResult(String search, Observer<SearchSongBean> observer) {
                Observable<SearchSongBean> getSingerImgUrl = ApiRetrofit
                        .getInstanceSearch()
                        .getApiServiceSearch()
                        .getSearch(search,2);

                getSingerImgUrl
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);
            }

            @Override
            public void getSongUrl(String songId, Observer<SongUrlBean> observer) {
                Observable<SongUrlBean> getSingerImgUrl = ApiRetrofit
                        .getInstanceSong()
                        .getApiServiceSong()
                        .getSongUrl(Api.SONG_URL_DATA_LEFT+songId+Api.SONG_URL_DATA_RIGHT);

                getSingerImgUrl
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);

            }
        };
    }

}
