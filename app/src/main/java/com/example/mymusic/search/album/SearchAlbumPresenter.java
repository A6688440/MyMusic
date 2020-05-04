package com.example.mymusic.search.album;

import com.example.mymusic.bean.AlbumInfoBean;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.model.BaseObserver;
import com.example.mymusic.mvp.presenter.BasePresenter;
import com.example.mymusic.search.song.ISearchSong;
import com.example.mymusic.bean.SearchAlbumBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public class SearchAlbumPresenter extends BasePresenter<AlbumResultFragment, SearchAlbumModel, ISearchAlbum.P> {


    @Override
    public SearchAlbumModel getModelInstance() {
        return new SearchAlbumModel(this);
    }

    @Override
    public ISearchAlbum.P getContract() {
        return new ISearchAlbum.P() {
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

            @Override
            public void getAlbumInfo(String albumId) {
                mModel.getContract().getAlbumInfo(albumId, new BaseObserver<AlbumInfoBean>() {
                    @Override
                    public void OnSuccess(AlbumInfoBean infoBean) {
                        mView.getContract().getAlbumInfo(infoBean);
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
