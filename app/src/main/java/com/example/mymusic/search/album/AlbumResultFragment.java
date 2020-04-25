package com.example.mymusic.search.album;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymusic.R;
import com.example.mymusic.mvp.view.BaseFragment;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.search.view_model.SearchViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class AlbumResultFragment extends BaseFragment<SearchAlbumPresenter, ISearchAlbum.V> {

    private static final String TAG = "AlbumResultFragment";
    private SearchViewModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_result, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(SearchViewModel.class);
        model.getSearchKey().observe(requireActivity(), s -> {
            Log.e(TAG, "onActivityCreated: " + s);
            mPresenter.getContract().SearchKey(s);
        });
    }

    @Override
    protected SearchAlbumPresenter getPresenterInstance() {
        return new SearchAlbumPresenter();
    }

    @Override
    public ISearchAlbum.V getContract() {
        return searchAlbumBean -> {
            Log.e(TAG, "getContract: " + searchAlbumBean.toString());
        };
    }

}
