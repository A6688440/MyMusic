package com.example.mymusic.search.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public class SearchHistoryViewModel extends ViewModel {
    private MutableLiveData<Boolean> state;

    public MutableLiveData<Boolean> getState() {
        if (state == null) {
            state = new MutableLiveData<>();
            state.setValue(false);
        }
        return state;
    }

    public void changeState(Boolean aBoolean) {
        state = null;
        state = new MutableLiveData<>();
        state.setValue(aBoolean);
    }
}
