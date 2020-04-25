package com.example.mymusic.search.album;

import com.example.mymusic.mvp.model.BaseModel;
import com.example.mymusic.mvp.retrofit.ApiRetrofit;
import com.example.mymusic.bean.SearchAlbumBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SJC on 2020/4/25.
 * Describe：
 */
public class SearchAlbumModel extends BaseModel<SearchAlbumPresenter,ISearchAlbum.M> {
    public SearchAlbumModel(SearchAlbumPresenter mPresenter) {
        super(mPresenter);
    }

    @Override
    public ISearchAlbum.M getContract() {
        return new ISearchAlbum.M() {
            @Override
            public void getSearchAlbumResult(String search, Observer<SearchAlbumBean> observer) {
                    Observable<SearchAlbumBean> getAlbumResult = ApiRetrofit
                            .getInstanceSearch()
                            .getApiServiceSearch()
                            .searchAlbum(search, 2);

                    getAlbumResult
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(observer);
            }
        };
    }
}
