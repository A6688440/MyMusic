package com.example.mymusic.adapter;

import com.example.mymusic.search.album.AlbumInfoFragment;
import com.example.mymusic.search.album.AlbumSongFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by SJC on 2020/5/3.
 * Describe：
 */
public class MaterialViewPagerAdapter extends FragmentStatePagerAdapter {

    public MaterialViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AlbumSongFragment.newInstance("", "");
            case 1:
                return AlbumInfoFragment.newInstance("", "");
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "歌曲列表";
            case 1:
                return "专辑信息";
        }
        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }
}
