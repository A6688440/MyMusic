package com.example.mymusic.search.view_model;

import com.example.mymusic.bean.AlbumInfoBean;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by SJC on 2020/5/5.
 * Describe：
 */
public class AlbumInfoViewModel extends ViewModel {
    private final MutableLiveData<AlbumInfoBean.DataBean> data = new MutableLiveData<>();

    public MutableLiveData<AlbumInfoBean.DataBean> getData() {
        return data;

    }

    public void addModel(AlbumInfoBean.DataBean dataBean) {
       data.setValue(dataBean);
    }
}
