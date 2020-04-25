package com.example.mymusic.search.album;

import com.example.mymusic.bean.SearchAlbumBean;
import com.example.mymusic.bean.SearchSongBean;

import io.reactivex.Observer;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public interface ISearchAlbum {

    interface V {
        void getResult(SearchAlbumBean searchAlbumBean);
    }


    interface P {
        void SearchKey(String searchKey);
    }

    interface M {
        void getSearchAlbumResult(String search, Observer<SearchAlbumBean> observer);
    }
}
