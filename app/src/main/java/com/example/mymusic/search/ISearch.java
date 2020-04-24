package com.example.mymusic.search;

import com.example.mymusic.bean.SearchSongBean;

import io.reactivex.Observer;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public interface ISearch {

    interface V {
        void getResult(SearchSongBean SearchSongBean);
    }


    interface P {
        void SearchKey(String searchKey);
    }

    interface M {
        void getSearchResult(String search, Observer<SearchSongBean> observer);
    }
}
