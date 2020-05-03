package com.example.mymusic.play;

import android.util.Log;

import com.example.mymusic.bean.AlbumInfoBean;
import com.example.mymusic.bean.SearchAlbumBean;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.bean.SingerImgBean;
import com.example.mymusic.bean.SongUrlBean;
import com.example.mymusic.mvp.disposable.SubscriptionManager;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.model.BaseObserver;
import com.example.mymusic.mvp.presenter.BasePresenter;

import io.reactivex.disposables.Disposable;


/**
 * Created by SJC on 2020/4/19.
 * Describe：
 */
public class PlayPresenter extends BasePresenter<MainActivity, PlayModel, IPlayContract.P> {

    private final String TAG = "123456";


    @Override
    public PlayModel getModelInstance() {
        return new PlayModel(this);
    }


    @Override
    public IPlayContract.P getContract() {
        return new IPlayContract.P() {

            @Override
            public void getSongUrl(String songId) {
                mModel.getContract().getSongUrl(songId, new BaseObserver<SongUrlBean>() {
                    @Override
                    public void OnSuccess(SongUrlBean songUrlBean) {
                        //得到网络请求的结果，进行拼接SongUrl
                        String url = songUrlBean.getReq_0().getData().getSip().get(0)
                                + songUrlBean.getReq_0().getData().getMidurlinfo().get(0).getPurl();
                        if (songUrlBean.getReq_0().getData().getMidurlinfo().get(0).getPurl().equals("")) {
                            mView.getContract().getSongUrlFail("没版权");
                        }else {
                            mView.getContract().getSongUrlFail("");
                            mView.getContract().getSongUrl(url);
                        }

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
