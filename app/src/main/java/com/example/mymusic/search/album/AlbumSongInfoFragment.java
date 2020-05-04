package com.example.mymusic.search.album;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.mymusic.R;
import com.example.mymusic.adapter.MaterialViewPagerAdapter;
import com.example.mymusic.databinding.FragmentAlbumSongInfoBinding;
import com.example.mymusic.search.view_model.AlbumInfoViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumSongInfoFragment extends Fragment {

    private FragmentAlbumSongInfoBinding binding;

    private RelativeLayout mAlbumBackground;
    private TextView mSingerNameTv;
    private TextView mPublicTimeTv;
    private ImageView mAlbumPicIv;
    private MenuItem mLoveBtn;
    private boolean mLove;
    private Toolbar toolbar;

    private AlbumInfoViewModel infoViewModel;

    public AlbumSongInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAlbumSongInfoBinding.inflate(getLayoutInflater());


        mAlbumBackground = binding.materialViewPager.getHeaderBackgroundContainer().findViewById(R.id.relative_album);
        mAlbumPicIv = binding.materialViewPager.getHeaderBackgroundContainer().findViewById(R.id.iv_album);
        mSingerNameTv = binding.materialViewPager.getHeaderBackgroundContainer().findViewById(R.id.tv_singer_name);
        mPublicTimeTv = binding.materialViewPager.getHeaderBackgroundContainer().findViewById(R.id.tv_public_time);

        infoViewModel=new ViewModelProvider(requireActivity()).get(AlbumInfoViewModel.class);

        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.materialViewPager.setMaterialViewPagerListener(page -> {
            switch (page) {
                case 1:
                    break;
                case 2:
                    break;
            }
            return null;
        });


        binding.materialViewPager.getViewPager().setAdapter(
                new MaterialViewPagerAdapter(getActivity().getSupportFragmentManager(),
                        FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));

        binding.materialViewPager.getViewPager().setOffscreenPageLimit(binding.materialViewPager.getViewPager().getAdapter().getCount());
        binding.materialViewPager.getPagerTitleStrip().setViewPager(binding.materialViewPager.getViewPager());
        binding.materialViewPager.getPagerTitleStrip().setIndicatorColorResource(R.color.yellow);
        binding.materialViewPager.getPagerTitleStrip().setTabBackground(R.color.tab);
        binding.materialViewPager.getPagerTitleStrip().setTextColorStateListResource(R.color.white);

        toolbar = binding.materialViewPager.getToolbar();

        toolbar.setTitleTextColor(getActivity().getResources().getColor(R.color.white));
        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        infoViewModel.getData().observe(requireActivity(),dataBean -> {

        });
    }
}
