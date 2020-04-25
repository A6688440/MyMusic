package com.example.mymusic.search.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by SJC on 2020/4/23.
 * Describe：
 */
public class SearchViewModel extends ViewModel {

    private final MutableLiveData<String> searchKey=new MutableLiveData<>();

    public MutableLiveData<String> getSearchKey() {
        return searchKey;
    }

    public void addSearchKey(String s) {
        searchKey.setValue(s);
    }


}
