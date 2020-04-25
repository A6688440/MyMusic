package com.example.mymusic.search.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by SJC on 2020/4/25.
 * Describe：
 */
public class SongIdViewModel extends ViewModel {
    private final MutableLiveData<String> songId=new MutableLiveData<>();

    public MutableLiveData<String> getSingId() {
//        if (songId == null) {
//            songId=new MutableLiveData<>();
//            upDataSongId("xx");
//        }
        return songId;
    }

    public void upDataSongId(String songmId) {
        songId.setValue(songmId);
    }
}
