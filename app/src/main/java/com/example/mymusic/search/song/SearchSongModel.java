package com.example.mymusic.search.song;

import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.mvp.model.BaseModel;
import com.example.mymusic.mvp.retrofit.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public class SearchSongModel extends BaseModel<SearchSongPresenter, ISearchSong.M> {

    public SearchSongModel(SearchSongPresenter mPresenter) {
        super(mPresenter);
    }


    @Override
    public ISearchSong.M getContract() {
        return new ISearchSong.M() {
            @Override
            public void getSearchSongResult(String search, Observer<SearchSongBean> observer) {
                Observable<SearchSongBean> getSingerImgUrl = ApiRetrofit
                        .getInstanceSearch()
                        .getApiServiceSearch()
                        .getSearch(search, 2);

                getSingerImgUrl
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);
            }

        };
    }

}
