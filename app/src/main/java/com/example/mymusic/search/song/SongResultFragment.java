package com.example.mymusic.search.song;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymusic.R;
import com.example.mymusic.adapter.SongResultRecycleViewAdapter;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.databinding.FragmentSearchResultBinding;
import com.example.mymusic.databinding.FragmentSongResultBinding;
import com.example.mymusic.event.EventMessage;
import com.example.mymusic.mvp.view.BaseFragment;
import com.example.mymusic.search.view_model.SearchViewModel;
import com.example.mymusic.search.view_model.SongIdViewModel;
import com.example.mymusic.utils.CommonUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class SongResultFragment extends BaseFragment<SearchSongPresenter, ISearchSong.V> {

    private static final String TAG = "SongResultFragment";

    private FragmentSongResultBinding binding;

    private SearchViewModel model;
    private SongIdViewModel songIdViewModel;

    private String searchKey;
    private String songId;
    private SongResultRecycleViewAdapter adapter;
    private SongIdViewModel setSongId;
    private LinearLayoutManager manager;
    private List<SearchSongBean.DataBean.SongBean.ListBean> list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_song_result, container, false);
        binding = FragmentSongResultBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    protected SearchSongPresenter getPresenterInstance() {
        return new SearchSongPresenter();
    }

    @Override
    public ISearchSong.V getContract() {
        return searchSongBean -> {
            list = searchSongBean.getData().getSong().getList();
            adapter = new
                    SongResultRecycleViewAdapter(list,CommonUtil.SongResultType,
                    searchKey, songId,  new SongResultRecycleViewAdapter.MySongItemCallBack() {
                @Override
                public void ItemOnClickListener(String songmId, String albumId, String songName, List<String> singers, int position) {
                    EventBus.getDefault().postSticky(new EventMessage(songmId, albumId, songName, singers));
                }
            });

            manager = new LinearLayoutManager(getContext());
            binding.songResultRecycleView.setLayoutManager(manager);
            binding.songResultRecycleView.setAdapter(adapter);

        };
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(SearchViewModel.class);
        model.getSearchKey().observe(requireActivity(), s -> {
            Log.e(TAG, "onActivityCreated: " + s);
            searchKey = s;
            mPresenter.getContract().SearchKey(s);

        });

        songIdViewModel = new ViewModelProvider(requireActivity()).get(SongIdViewModel.class);
        songIdViewModel.getSingId().observe(requireActivity(), s -> {
            songId = s;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
