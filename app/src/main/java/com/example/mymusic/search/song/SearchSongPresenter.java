package com.example.mymusic.search.song;

import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.model.BaseObserver;
import com.example.mymusic.mvp.presenter.BasePresenter;

import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public class SearchSongPresenter extends BasePresenter<SongResultFragment, SearchSongModel, ISearchSong.P> {

    @Override
    public SearchSongModel getModelInstance() {
        return new SearchSongModel(this);
    }

    @Override
    public ISearchSong.P getContract() {
        return new ISearchSong.P() {
            @Override
            public void SearchKey(String searchKey) {
                mModel.getContract().getSearchSongResult(searchKey, new BaseObserver<SearchSongBean>() {
                    @Override
                    public void OnSuccess(SearchSongBean searchSongBean) {
                        mView.getContract().getResult(searchSongBean);
                    }

                    @Override
                    public void OnFail(ExceptionHandle.ResponseThrowable e) {

                    }

                    @Override
                    public void OnCompleted() {

                    }

                    @Override
                    public void OnDisposable(Disposable d) {

                    }
                });
            }
        };
    }


}
