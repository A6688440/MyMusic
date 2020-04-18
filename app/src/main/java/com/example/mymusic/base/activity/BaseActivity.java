package com.example.mymusic.base.activity;

import android.os.Bundle;

import com.example.mymusic.base.view.BaseView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder mBinder;


    //获取布局的ID
    protected abstract int getContentView();

    //初始化布局
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //点击事件
    protected abstract void onClick();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        //黄油刀注册
        ButterKnife.bind(this);

        initView();
        initData();
        onClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //黄油刀解绑
        if (mBinder != null) {
            mBinder.unbind();
            mBinder = null;
        }
    }


    @Override
    public void showToast(String message) {

    }

    @Override
    public void showNormalView() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void reload() {

    }


}
