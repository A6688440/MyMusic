package com.example.mymusic.search.album;

import com.example.mymusic.bean.AlbumInfoBean;
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
        void getAlbumInfo(AlbumInfoBean infoBean);
    }


    interface P {
        void SearchKey(String searchKey);

        void getAlbumInfo(String albumId);
    }

    interface M {
        void getSearchAlbumResult(String search, Observer<SearchAlbumBean> observer);

        void getAlbumInfo(String albumId, Observer<AlbumInfoBean> observer);
    }
}
