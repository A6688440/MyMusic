package com.example.mymusic.search.album;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymusic.R;
import com.example.mymusic.adapter.SongResultRecycleViewAdapter;
import com.example.mymusic.databinding.FragmentAlbumResultBinding;
import com.example.mymusic.mvp.view.BaseFragment;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.search.view_model.SearchViewModel;
import com.example.mymusic.utils.CommonUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class AlbumResultFragment extends BaseFragment<SearchAlbumPresenter, ISearchAlbum.V> {

    private FragmentAlbumResultBinding binding;

    private static final String TAG = "AlbumResultFragment";
    private SearchViewModel model;
    private SongResultRecycleViewAdapter adapter;
    private String searchKey;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAlbumResultBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(SearchViewModel.class);
        model.getSearchKey().observe(requireActivity(), s -> {
            searchKey = s;
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
            adapter = new SongResultRecycleViewAdapter(searchAlbumBean.getData().getAlbum().getList(),
                    searchKey, CommonUtil.AlbumResultType, getContext(), (albumId, rippleView) -> {
                NavController controller= Navigation.findNavController(requireActivity(),R.id.fragment2);
                controller.navigate(R.id.action_searchFragment_to_albumInfoFragment);
            });
            LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
            binding.albumResultRecycleView.setLayoutManager(layoutManager);
            binding.albumResultRecycleView.setAdapter(adapter);
        };
    }

}
