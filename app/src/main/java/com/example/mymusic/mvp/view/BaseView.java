package com.example.mymusic.mvp.view;


import com.example.mymusic.mvp.erroe.ExceptionHandle;

public interface BaseView {

    void onSuccess(Object object);

    void onFail(ExceptionHandle.ResponseThrowable t);

    void OnCompleted();
}
