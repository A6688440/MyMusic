package com.example.mymusic.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mymusic.R;
import com.example.mymusic.bean.SearchHistoryBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SJC on 2020/4/23.
 * Describe：
 */
public class SearchHistoryListViewAdapter extends BaseAdapter {

    private Context context;
    private List<SearchHistoryBean> list;

    public SearchHistoryListViewAdapter(Context context, List<SearchHistoryBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.search_history_list_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.searchHistorytvListItem.setText(list.get(i).getSearchHistory());
        return view;
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    static
    class ViewHolder {
        @BindView(R.id.search_historytv_list_item)
        TextView searchHistorytvListItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
