package com.example.mymusic.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.example.mymusic.R;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.utils.CommonUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by SJC on 2020/4/25.
 * Describe：
 */
public class SongResultRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "SongResultRecycleViewAdapter";
    private int mLastPosition = -1;

    private final int songType = 1;
    private final int footerType = 2;

    private List<SearchSongBean.DataBean.SongBean.ListBean> list;
    private String searchKey;
    private String songId;
    private MySongItemCallBack callBack;

    @SuppressLint("LongLogTag")
    public SongResultRecycleViewAdapter(List<SearchSongBean.DataBean.SongBean.ListBean> list, String searchKey, String songId, MySongItemCallBack callBack) {
        this.list = list;
        this.songId = songId;
        this.callBack = callBack;
        this.searchKey = searchKey;
        Log.e(TAG, "SongResultRecycleViewAdapter: " + songId);

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == songType) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.recycler_item_song_result, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.footer_view_player_height, parent, false);
            FooterHolder footerHolder = new FooterHolder(view);
            return footerHolder;
        }
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ViewHolder) {
            ViewHolder holder = (ViewHolder) viewHolder;

            StringBuilder singer = new StringBuilder(list.get(position).getSinger().get(0).getName());
            for (int i = 1; i < list.get(position).getSinger().size(); i++) {
                singer.append("、").append(list.get(position).getSinger().get(i).getName());
            }

            CommonUtil.showStringColor(searchKey, singer.toString(), holder.songAuthor);
            CommonUtil.showStringColor(searchKey, list.get(position).getSongname(), holder.songTitle);
            Log.e(TAG, "onBindViewHolder: " + position);
            if (list.get(position).getSongmid().equals(songId)) {
                holder.playLine.setVisibility(View.VISIBLE);
                holder.mItemView.setBackgroundResource(R.color.translucent);
            } else {
                holder.playLine.setVisibility(View.INVISIBLE);
                holder.mItemView.setBackgroundResource(R.color.transparent);
            }
            holder.mItemView.setOnClickListener(view -> {
                callBack.ItemOnClickListener(view, list.get(position).getSongmid(), position);
                songId=list.get(position).getSongmid();
            });

        }
    }


    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position + 1 == getItemCount() ? footerType : songType;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView songTitle, songAuthor;
        RippleView mItemView;
        View playLine;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.item_song_title);
            songAuthor = itemView.findViewById(R.id.item_song_author);
            playLine = itemView.findViewById(R.id.line_play);
            mItemView = itemView.findViewById(R.id.ripple_song_result);
        }
    }

    static class FooterHolder extends RecyclerView.ViewHolder {

        public FooterHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    //判断点击的是否为上一个点击的项目
    private void equalPosition(int position) {
        if (position != mLastPosition) {
            if (mLastPosition != -1) notifyItemChanged(mLastPosition);
            mLastPosition = position;
        }

    }

    public interface MySongItemCallBack {
        void ItemOnClickListener(View view, String songId, int position);
    }
}
