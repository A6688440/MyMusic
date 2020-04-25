package com.example.mymusic.search.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public class SearchHistoryViewModel extends ViewModel {
    private final MutableLiveData<Boolean> state=new MutableLiveData<>();

    public MutableLiveData<Boolean> getState() {
//        if (state == null) {
//            state = new MutableLiveData<>();
//            changeState(false);
//        }
        return state;
    }

    public void changeState(Boolean aBoolean) {
//        if (state == null) {
//            state = new MutableLiveData<>();
//            changeState(false);
//        }
        state.setValue(aBoolean);
    }
}
