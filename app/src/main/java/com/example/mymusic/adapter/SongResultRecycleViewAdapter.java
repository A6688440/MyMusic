package com.example.mymusic.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymusic.R;
import com.example.mymusic.bean.AlbumInfoBean;
import com.example.mymusic.bean.SearchAlbumBean;
import com.example.mymusic.bean.SearchSongBean;
import com.example.mymusic.utils.CommonUtil;

import java.util.ArrayList;
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

//    private final int songType = 1;
//    private final int albumType = 2;

    private List<SearchSongBean.DataBean.SongBean.ListBean> list;
    private List<SearchAlbumBean.DataBean.AlbumBean.ListBean> albumList;
    private List<AlbumInfoBean.DataBean.ListBean> albumInfoList;

    private String searchKey;
    private String songId;
    private String albumId;
    private int mType;
    private Context context;

    private MySongItemCallBack callBack;
    private MyAlbumItemCallBack albumItemCallBack;
    private MyAlbumSongCallBack albumSongCallBack;


    public SongResultRecycleViewAdapter(List<AlbumInfoBean.DataBean.ListBean> list, int mType, String songId, MyAlbumSongCallBack albumSongCallBack) {
        this.albumInfoList = list;
        this.songId = songId;
        this.albumSongCallBack = albumSongCallBack;
        this.mType = mType;

    }

    public SongResultRecycleViewAdapter(List<SearchSongBean.DataBean.SongBean.ListBean> list, int mType, String searchKey, String songId, MySongItemCallBack callBack) {
        this.list = list;
        this.songId = songId;
        this.callBack = callBack;
        this.searchKey = searchKey;
        this.mType = mType;

    }

    public SongResultRecycleViewAdapter(List<SearchAlbumBean.DataBean.AlbumBean.ListBean> albumList, String searchKey, int mType, Context context, MyAlbumItemCallBack albumItemCallBack) {
        this.albumList = albumList;
        this.searchKey = searchKey;
        this.albumId = albumId;
        this.albumItemCallBack = albumItemCallBack;
        this.mType = mType;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == CommonUtil.SongResultType) {
            view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.recycler_item_song_result, parent, false);
            SongHolder songHolder = new SongHolder(view);
            return songHolder;
        } else if (viewType == CommonUtil.AlbumResultType) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item_album_result, parent, false);
            AlbumHolder albumHolder = new AlbumHolder(view);
            return albumHolder;
        } else if (viewType == CommonUtil.AlbumInfoType) {
            view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.recycler_item_song_result, parent, false);
            AlbumInfoHolder infoHolder = new AlbumInfoHolder(view);
            return infoHolder;
        }
        return null;
    }


    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof SongHolder) {
            SongHolder holder = (SongHolder) viewHolder;
            StringBuilder singer = new StringBuilder(list.get(position).getSinger().get(0).getName());
            for (int i = 1; i < list.get(position).getSinger().size(); i++) {
                singer.append("、").append(list.get(position).getSinger().get(i).getName());
            }

            CommonUtil.showStringColor(searchKey, singer.toString(), holder.songAuthor);
            CommonUtil.showStringColor(searchKey, list.get(position).getSongname(), holder.songTitle);

            if (list.get(position).getSongmid().equals(songId)) {
                holder.playLine.setVisibility(View.VISIBLE);
                holder.mItemView.setBackgroundResource(R.color.translucent);
            } else {
                holder.playLine.setVisibility(View.INVISIBLE);
                holder.mItemView.setBackgroundResource(R.color.transparent);
            }

            holder.mItemView.setOnClickListener(view -> {
                List<String> stringList = new ArrayList<>();
                for (SearchSongBean.DataBean.SongBean.ListBean.SingerBean singerBean : list.get(position).getSinger()) {
                    stringList.add(singerBean.getName());
                }

                callBack.ItemOnClickListener(list.get(position).getSongmid(),
                        list.get(position).getAlbummid(),
                        list.get(position).getSongname(),
                        stringList,
                        position);
                songId = list.get(position).getSongmid();
            });

        } else if (viewHolder instanceof AlbumHolder) {
            AlbumHolder albumHolder = (AlbumHolder) viewHolder;
            Glide.with(context).load(albumList.get(position).getAlbumPic())
                    .apply(RequestOptions.errorOf(R.drawable.background)).into(albumHolder.albumIv);
            albumHolder.albumName.setText(albumList.get(position).getAlbumName());
            albumHolder.singerName.setText(albumList.get(position).getSingerName());
            albumHolder.publicTime.setText(albumList.get(position).getPublicTime());
            CommonUtil.showStringColor(searchKey, albumList.get(position).getAlbumName(), albumHolder.albumName);
            CommonUtil.showStringColor(searchKey, albumList.get(position).getSingerName(), albumHolder.singerName);
            CommonUtil.showStringColor(searchKey, albumList.get(position).getPublicTime(), albumHolder.publicTime);
            albumHolder.item.setOnRippleCompleteListener(rippleView -> {
                albumItemCallBack.ItemOnClickListener(albumList.get(position).getAlbumMID(), rippleView);
            });
        } else if (viewHolder instanceof AlbumInfoHolder) {
            AlbumInfoHolder holder = (AlbumInfoHolder) viewHolder;

            StringBuilder singer = new StringBuilder(albumInfoList.get(position).getSinger().get(0).getName());

            for (int i = 1; i < albumInfoList.get(position).getSinger().size(); i++) {
                singer.append("、").append(albumInfoList.get(position).getSinger().get(i).getName());
            }

            if (albumInfoList.get(position).getSongmid().equals(songId)) {
                holder.playLine.setVisibility(View.VISIBLE);
                holder.mItemView.setBackgroundResource(R.color.translucent);
            } else {
                holder.playLine.setVisibility(View.INVISIBLE);
                holder.mItemView.setBackgroundResource(R.color.transparent);
            }

            holder.mItemView.setOnClickListener(view -> {
                List<String> albumStringList = new ArrayList<>();
                for (AlbumInfoBean.DataBean.ListBean.SingerBean singerBean : albumInfoList.get(position).getSinger()) {
                    albumStringList.add(singerBean.getName());
                }
                songId = albumInfoList.get(position).getSongmid();

                albumSongCallBack.ItemOnClickListener(albumInfoList.get(position).getSongmid(),
                        albumInfoList.get(position).getAlbummid(),
                        albumInfoList.get(position).getSongname(),
                        albumStringList,
                        position);
            });

            holder.songTitle.setText(albumInfoList.get(position).getSongname());
            holder.songAuthor.setText(singer);
        }
    }


    @Override
    public int getItemCount() {
        if (mType == CommonUtil.SongResultType) {
            return list.size();
        } else if (mType == CommonUtil.AlbumResultType) {
            return albumList.size();
        } else if (mType == CommonUtil.AlbumInfoType) {
            return albumInfoList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mType;
    }

    static class SongHolder extends RecyclerView.ViewHolder {

        TextView songTitle, songAuthor;
        RippleView mItemView;
        View playLine;

        public SongHolder(@NonNull View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.item_song_title);
            songAuthor = itemView.findViewById(R.id.item_song_author);
            playLine = itemView.findViewById(R.id.line_play);
            mItemView = itemView.findViewById(R.id.ripple_song_result);
        }
    }

    static class AlbumHolder extends RecyclerView.ViewHolder {
        ImageView albumIv;
        TextView singerName;
        TextView albumName;
        TextView publicTime;
        RippleView item;

        public AlbumHolder(@NonNull View itemView) {
            super(itemView);
            albumIv = itemView.findViewById(R.id.iv_album);
            singerName = itemView.findViewById(R.id.tv_singer_name);
            albumName = itemView.findViewById(R.id.tv_album_name);
            publicTime = itemView.findViewById(R.id.tv_public_time);
            item = itemView.findViewById(R.id.ripple);
        }
    }

    static class AlbumInfoHolder extends RecyclerView.ViewHolder {

        TextView songTitle, songAuthor;
        RippleView mItemView;
        View playLine;

        public AlbumInfoHolder(@NonNull View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.item_song_title);
            songAuthor = itemView.findViewById(R.id.item_song_author);
            playLine = itemView.findViewById(R.id.line_play);
            mItemView = itemView.findViewById(R.id.ripple_song_result);
        }
    }

    public interface MySongItemCallBack {
        void ItemOnClickListener(String songId, String albumId, String songName, List<String> singers, int position);
    }

    public interface MyAlbumItemCallBack {
        void ItemOnClickListener(String albumId, RippleView rippleView);
    }


    public interface MyAlbumSongCallBack {
        void ItemOnClickListener(String songId, String albumId, String songName, List<String> singers, int position);
    }
}
