package com.example.mymusic.search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymusic.adapter.SearchViewPager2Adapter;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.databinding.FragmentSearchResultBinding;
import com.example.mymusic.mvp.view.BaseFragment;
import com.example.mymusic.search.result.AlbumResultFragment;
import com.example.mymusic.search.result.SongResultFragment;
import com.example.mymusic.search.view_model.SearchHistoryViewModel;
import com.example.mymusic.search.view_model.SearchViewModel;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultFragment extends BaseFragment<SearchPresenter, ISearch.V> {

    private String searchKey;
    private final String TAG = "SearchResultFragment";
    private SearchViewModel model;
    private SearchHistoryViewModel stateModel;

    public SearchResultFragment() {
        // Required empty public constructor
    }

    private FragmentSearchResultBinding binding;
    private List<Fragment> fragments;

    @Override
    protected SearchPresenter getPresenterInstance() {
        return new SearchPresenter();
    }

    @Override
    public ISearch.V getContract() {
        return new ISearch.V() {

            @Override
            public void getResult(SearchSongBean SearchSongBean) {
                Log.e(TAG, "getResult: " + SearchSongBean.toString());
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentSearchResultBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        stateModel = new ViewModelProvider(requireActivity()).get(SearchHistoryViewModel.class);
        stateModel.changeState(true);

        model = new ViewModelProvider(requireActivity()).get(SearchViewModel.class);
        model.getSearchKey().observe(requireActivity(), s -> {
           searchKey=s;
        });



        fragments = new ArrayList<>();
        fragments.add(new SongResultFragment());
        fragments.add(new AlbumResultFragment());

        SearchViewPager2Adapter searchViewPagerAdapter = new SearchViewPager2Adapter((FragmentActivity) getContext(), fragments);
        binding.searchResultViewPager.setAdapter(searchViewPagerAdapter);

        new TabLayoutMediator(binding.searchResultTab, binding.searchResultViewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("歌曲");
                    break;
                case 1:
                    tab.setText("专辑");
                    break;
            }
        }).attach();

        //实质性去恩网络请求的地方
        Log.e(TAG, "onActivityCreated: "+searchKey );
        mPresenter.getContract().SearchKey(searchKey);
    }
}
