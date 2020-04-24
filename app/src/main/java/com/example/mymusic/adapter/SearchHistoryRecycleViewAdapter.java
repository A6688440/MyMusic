package com.example.mymusic.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.example.mymusic.R;
import com.example.mymusic.bean.SearchHistoryBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by SJC on 2020/4/24.
 * Describe：
 */
public class SearchHistoryRecycleViewAdapter extends RecyclerView.Adapter {


    //切换布局的标识符
    private static final int mHistoryType = 0;
    private static final int mFootType = 1;
    private List<SearchHistoryBean> list;
    private MyCallBack myCallBack;

    //把list传进来
    public SearchHistoryRecycleViewAdapter(List<SearchHistoryBean> list, MyCallBack myCallBack) {
        this.list = list;
        this.myCallBack = myCallBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == mHistoryType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_search_history,
                    parent, false);
            return new HistoryHolder(view);

        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_search_history_2,
                    parent, false);
            return new FootHolder(view);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HistoryHolder) {
            HistoryHolder historyHolder = (HistoryHolder) holder;

            historyHolder.historyTv.setText(list.get(position).getSearch());

            historyHolder.deleteIv.setOnClickListener(view -> {
                myCallBack.clearOnlyHistory(position, view);
            });

            historyHolder.mItemView.setOnClickListener(view -> {
                myCallBack.addSearchKey(position,view);
            });

        } else {
            FootHolder footHolder = (FootHolder) holder;
            footHolder.deleteView.setOnClickListener(view -> {
                myCallBack.clearAllHistory(view);
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position + 1 == getItemCount() ? mFootType : mHistoryType;
    }

    private class HistoryHolder extends RecyclerView.ViewHolder {

        TextView historyTv;
        ImageView deleteIv;
        RelativeLayout mItemView;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            historyTv = itemView.findViewById(R.id.search_history_tv_list_item);
            deleteIv = itemView.findViewById(R.id.iv_history_delete);
            mItemView = itemView.findViewById(R.id.search_key_history);

        }
    }

    private class FootHolder extends RecyclerView.ViewHolder {
        View deleteView;

        public FootHolder(@NonNull View itemView) {
            super(itemView);
            deleteView = itemView;
        }
    }


    public interface MyCallBack {
        void clearAllHistory(View view);

        void clearOnlyHistory(int position, View view);

        void addSearchKey(int position, View view);

    }
}
