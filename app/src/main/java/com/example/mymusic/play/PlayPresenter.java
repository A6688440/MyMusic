package com.example.mymusic.play;

import android.util.Log;

import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.bean.SingerImgBean;
import com.example.mymusic.bean.SongUrlBean;
import com.example.mymusic.mvp.disposable.SubscriptionManager;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.model.BaseObserver;
import com.example.mymusic.mvp.presenter.BasePresenter;
import com.example.mymusic.mvp.retrofit.Api;

import io.reactivex.disposables.Disposable;


/**
 * Created by SJC on 2020/4/19.
 * Describe：
 */
public class PlayPresenter extends BasePresenter<MainActivity, PlayModel, IPlayContract.P>  {

    private final String TAG = "123456";


    @Override
    public PlayModel getmModelInstance() {
        return new PlayModel(this);
    }


    @Override
    public IPlayContract.P getContract() {
        return new IPlayContract.P() {
            @Override
            public void getSingerImgUrl(String singerName) {
                mModel.getContract().getSingerImgUrl(singerName, new BaseObserver<SingerImgBean>() {
                    @Override
                    public void OnSuccess(SingerImgBean singerImgBean) {
                        Log.e(TAG, "OnSuccess: "+singerImgBean.getResult().getArtists().get(0).getImg1v1Url() );
                        mView.onSuccess(singerImgBean.getResult().getArtists().get(0).getImg1v1Url());
                        mView.getContract().getSingerImgUrl(singerImgBean.getResult().getArtists().get(0).getImg1v1Url());
                    }

                    @Override
                    public void OnFail(ExceptionHandle.ResponseThrowable e) {
                        mView.onFail(e);
                    }

                    @Override
                    public void OnCompleted() {
                        mView.OnCompleted();
                    }

                    @Override
                    public void OnDisposable(Disposable d) {
                        SubscriptionManager.getInstance().add(d);
                    }

                });
            }

            @Override
            public void getSearch(String search) {
                mModel.getContract().getSearchResult(search, new BaseObserver<SearchSongBean>() {
                    @Override
                    public void OnSuccess(SearchSongBean searchSongBean) {
                        int SongTime=searchSongBean.getData().getSong().getList().get(0).getInterval();
                        String  SongId=searchSongBean.getData().getSong().getList().get(0).getSongmid();
                        getSongId(SongId,SongTime);
                    }

                    @Override
                    public void OnFail(ExceptionHandle.ResponseThrowable e) {

                    }

                    @Override
                    public void OnCompleted() {

                    }

                    @Override
                    public void OnDisposable(Disposable d) {
                        SubscriptionManager.getInstance().add(d);
                    }
                });
            }

            @Override
            public void getSongId(String SongId, int SongTime) {
                mModel.getContract().getSongUrl(SongId, new BaseObserver<SongUrlBean>() {
                    @Override
                    public void OnSuccess(SongUrlBean songUrlBean) {
                        String url= songUrlBean.getReq_0().getData().getSip().get(0)
                                +songUrlBean.getReq_0().getData().getMidurlinfo().get(0).getPurl();

                        mView.getContract().getSongUrl(url,SongTime);
                    }

                    @Override
                    public void OnFail(ExceptionHandle.ResponseThrowable e) {

                    }

                    @Override
                    public void OnCompleted() {

                    }

                    @Override
                    public void OnDisposable(Disposable d) {
                        SubscriptionManager.getInstance().add(d);
                    }
                });

            }


        };
    }
}
