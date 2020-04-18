package com.example.mymusic.base.view;



public  interface BaseView {
    //显示正常的View
    void  showNormalView();
    //显示错误的View
    void showErrorView();
    //重新加载
    void reload();
    //显示Toast
    void showToast(String message);

}
