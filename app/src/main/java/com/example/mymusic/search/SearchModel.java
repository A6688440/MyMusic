package com.example.mymusic.search;

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
public class SearchModel extends BaseModel<SearchPresenter,ISearch.M> {

    public SearchModel(SearchPresenter mPresenter) {
        super(mPresenter);
    }


    @Override
    public ISearch.M getContract() {
        return new ISearch.M() {
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
        };
    }

}
