package com.example.mymusic.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymusic.R;
//import com.example.mymusic.adapter.SearchHistoryListViewAdapter;
import com.example.mymusic.adapter.SearchHistoryRecycleViewAdapter;
import com.example.mymusic.bean.SearchHistoryBean;
import com.example.mymusic.databinding.FragmentSearchHistoryBinding;
import com.example.mymusic.search.view_model.SearchHistoryViewModel;
import com.example.mymusic.search.view_model.SearchViewModel;

import org.litepal.LitePal;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchHistoryFragment extends Fragment {


    private static final String TAG = "SearchHistoryFragment";
    private FragmentSearchHistoryBinding binding;
    //    private SearchHistoryListViewAdapter searchHistoryListViewAdapter;
    private List<SearchHistoryBean> list;
    private SearchViewModel model;
    private SearchHistoryRecycleViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private SearchHistoryViewModel stateModel;

    public SearchHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //这里试用了ViewBing的用法，感觉还好，挺舒服的，但是在Adapter中，感觉不是太友好
        binding = FragmentSearchHistoryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stateModel = new ViewModelProvider(requireActivity()).get(SearchHistoryViewModel.class);
        stateModel.changeState(false);

        //按搜索时间顺序重新排列  每次都重新加载一次，所以，每次都要在这界面显示的时候，做更新数据和UI
        list = LitePal.findAll(SearchHistoryBean.class);
        Collections.reverse(list);

        adapter = new SearchHistoryRecycleViewAdapter(list,
                new SearchHistoryRecycleViewAdapter.MyCallBack() {

                    private NavController controller;

                    @Override
                    public void clearAllHistory(View view) {
                        //删除全部数据
                        LitePal.deleteAll(SearchHistoryBean.class);
                        list.clear();
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void clearOnlyHistory(int position, View view) {
                        //删除特定数据

                        LitePal.deleteAll(SearchHistoryBean.class, "search=?", list.get(position).getSearch());
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                    }


                    @Override
                    public void addSearchKey(int position, View view) {
                        //传参数和跳转
                        model = new ViewModelProvider(requireActivity()).get(SearchViewModel.class);
                        model.addSearchKey(list.get(position).getSearch());
                        controller = Navigation.findNavController(view);
                        controller.navigate(R.id.action_searchHistoryFragment_to_searchResultFragment);
                    }
                });
        linearLayoutManager = new LinearLayoutManager(getContext());
        binding.searchHistoryRecycleView.setLayoutManager(linearLayoutManager);
        binding.searchHistoryRecycleView.setAdapter(adapter);
    }
}
