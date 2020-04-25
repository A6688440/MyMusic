package com.example.mymusic.search.song;

import com.example.mymusic.bean.SearchSongBean;

import io.reactivex.Observer;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public interface ISearchSong {

    interface V {
        void getResult(SearchSongBean searchSongBean);

    }


    interface P {
        void SearchKey(String searchKey);
    }

    interface M {
        void getSearchSongResult(String search, Observer<SearchSongBean> observer);
    }
}
