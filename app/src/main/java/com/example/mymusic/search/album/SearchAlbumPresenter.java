package com.example.mymusic.search.album;

import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.model.BaseObserver;
import com.example.mymusic.mvp.presenter.BasePresenter;
import com.example.mymusic.search.song.ISearchSong;
import com.example.mymusic.bean.SearchAlbumBean;

import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public class SearchAlbumPresenter extends BasePresenter<AlbumResultFragment, SearchAlbumModel, ISearchSong.P> {


    @Override
    public SearchAlbumModel getModelInstance() {
        return new SearchAlbumModel(this);
    }

    @Override
    public ISearchSong.P getContract() {
        return new ISearchSong.P() {
            @Override
            public void SearchKey(String searchKey) {
                mModel.getContract().getSearchAlbumResult(searchKey, new BaseObserver<SearchAlbumBean>() {
                    @Override
                    public void OnSuccess(SearchAlbumBean searchAlbumBean) {
                        mView.getContract().getResult(searchAlbumBean);
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
