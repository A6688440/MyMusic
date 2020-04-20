package com.example.mymusic.base;


public interface BaseView {
    //显示正常的View
    void showNormalView();

    //显示错误的View
    void showErrorView();

    //重新加载
    void reload();

    //显示Toast
    void showToast(String message);

    //显示dialog
    void showLoading();

    /*  *//**
     * 隐藏 dialog
     *//*

    void hideLoading();

    *//**
     * 显示错误信息
     *
     * @param msg
     *//*
    void showError(String msg);

    *//**
     * 错误码
     *//*
    void onErrorCode(BaseModel model);*/
}
