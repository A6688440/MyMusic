package com.example.mymusic.search;

import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.model.BaseModel;
import com.example.mymusic.mvp.model.BaseObserver;
import com.example.mymusic.mvp.presenter.BasePresenter;

import io.reactivex.disposables.Disposable;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public class SearchPresenter extends BasePresenter<SearchResultFragment, SearchModel, ISearch.P> {

    @Override
    public SearchModel getModelInstance() {
        return new SearchModel(this);
    }

    @Override
    public ISearch.P getContract() {
        return new ISearch.P() {
            @Override
            public void SearchKey(String searchKey) {
                mModel.getContract().getSearchResult(searchKey, new BaseObserver<SearchSongBean>() {
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
