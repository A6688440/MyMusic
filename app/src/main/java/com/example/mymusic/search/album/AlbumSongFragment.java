package com.example.mymusic.search.album;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.example.mymusic.R;
import com.example.mymusic.adapter.SongResultRecycleViewAdapter;
import com.example.mymusic.bean.AlbumInfoBean;
import com.example.mymusic.bean.SearchAlbumBean;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.databinding.FragmentAlbumSongBinding;
import com.example.mymusic.event.EventMessage;
import com.example.mymusic.search.view_model.AlbumInfoViewModel;
import com.example.mymusic.search.view_model.SongIdViewModel;
import com.example.mymusic.utils.CommonUtil;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlbumSongFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbumSongFragment extends Fragment {

    private static final String TAG = "AlbumSongFragment";
    private FragmentAlbumSongBinding binding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String songId;
    private SongResultRecycleViewAdapter adapter;
    private List<AlbumInfoBean.DataBean.ListBean> list;

    private AlbumInfoViewModel infoViewModel;
    private SongIdViewModel songIdViewModel;
    private String songId1;

    public AlbumSongFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlbumSongFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlbumSongFragment newInstance(String param1, String param2) {
        AlbumSongFragment fragment = new AlbumSongFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAlbumSongBinding.inflate(getLayoutInflater());

        infoViewModel = new ViewModelProvider(requireActivity()).get(AlbumInfoViewModel.class);
        songIdViewModel = new ViewModelProvider(requireActivity()).get(SongIdViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        infoViewModel.getData().observe(requireActivity(), dataBean -> {
            Log.e(TAG, "onViewCreated: "+dataBean.getList().size() );
            adapter = new SongResultRecycleViewAdapter(dataBean.getList(), CommonUtil.AlbumInfoType, songId, (songmId, albumId, songName, singers, position) -> EventBus.getDefault().postSticky(new EventMessage(songmId, albumId, songName, singers)));
            binding.albumSongRecycleView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
            binding.albumSongRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.albumSongRecycleView.setAdapter(adapter);
        });


        songIdViewModel.getSingId().observe(requireActivity(), s -> {
            songId = s;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        });
    }
}
