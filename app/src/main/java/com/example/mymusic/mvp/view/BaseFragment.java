package com.example.mymusic.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymusic.mvp.disposable.SubscriptionManager;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.presenter.BasePresenter;
import com.example.mymusic.mvp.view.BaseView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public abstract class BaseFragment<P extends BasePresenter, CONTRACT> extends Fragment implements BaseView {

    protected P mPresenter;

    protected abstract P getPresenterInstance();

    public abstract CONTRACT getContract();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = getPresenterInstance();
        mPresenter.bingView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unBindView();
        //View消除时取消订阅关系
        SubscriptionManager.getInstance().cancelAll();
    }

    @Override
    public void onSuccess(Object object) {

    }

    @Override
    public void onFail(ExceptionHandle.ResponseThrowable t) {

    }

    @Override
    public void OnCompleted() {

    }

}
