package com.example.mymusic.mvp.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mymusic.mvp.disposable.SubscriptionManager;
import com.example.mymusic.mvp.erroe.ExceptionHandle;
import com.example.mymusic.mvp.presenter.BasePresenter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter,CONTRACT> extends AppCompatActivity implements BaseView {

    private Unbinder mBinder;
    public P mPresenter;
    private ProgressDialog dialog;
    public Context context;
    public Toast toast;



    //获取布局的ID
    protected abstract int getContentView();

    //初始化布局
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //让子类实例化Presenter
    protected abstract P getmPresenterInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        //黄油刀注册
        ButterKnife.bind(this);

        //关联
        mPresenter = getmPresenterInstance();

        //绑定View 和 Presenter
        mPresenter.bingView(this);

        context = this;
        initView();
        initData();
    }


    public abstract CONTRACT getContract();

    @Override
    protected void onDestroy() {
        super.onDestroy();


        if (mPresenter != null) {
            mPresenter.unBindView();
        }


        //View消除时取消订阅关系
        SubscriptionManager.getInstance().cancelAll();



        //黄油刀解绑
        if (mBinder != null) {
            mBinder.unbind();
            mBinder = null;
        }
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
