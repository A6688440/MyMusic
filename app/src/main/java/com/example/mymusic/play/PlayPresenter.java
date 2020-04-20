package com.example.mymusic.play;

import com.example.mymusic.bean.SingerImgBean;
import com.example.mymusic.mvp.disposable.SubscriptionManager;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.model.BaseObserver;
import com.example.mymusic.mvp.presenter.BasePresenter;

import io.reactivex.disposables.Disposable;


/**
 * Created by SJC on 2020/4/19.
 * Describe：
 */
public class PlayPresenter extends BasePresenter<MainActivity, PlayModel,IPlayContract.P> implements IPlayContract.P  {

    private final String TAG = "123456";


    @Override
    public PlayModel getmModelInstance() {
        return new PlayModel(this);
    }


    @Override
    public void getSingerImgUrl(String singerName) {

    }


    @Override
    public IPlayContract.P getContract() {
        return singerName -> mModel.getContract().getSingerImgUrl(singerName, new BaseObserver<SingerImgBean>() {
            @Override
            public void OnSuccess(SingerImgBean singerImgBean) {
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
}
