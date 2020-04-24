package com.example.mymusic.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.mymusic.R;
import com.example.mymusic.SearchViewModel;
import com.example.mymusic.adapter.SearchHistoryListViewAdapter;
import com.example.mymusic.bean.SearchHistoryBean;
import com.example.mymusic.databinding.FragmentSearchHistoryBinding;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchHistoryFragment extends Fragment {


    private FragmentSearchHistoryBinding binding;
    private SearchHistoryListViewAdapter searchHistoryListViewAdapter;
    private List<SearchHistoryBean> list;
    private SearchViewModel model;

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

        //按搜索时间顺序重新排列  每次都重新加载一次，所以，每次都要在这界面显示的时候，做更新数据和UI
        list = LitePal.findAll(SearchHistoryBean.class);
        if (!list.isEmpty()) {
            list.size();
            searchHistoryListViewAdapter = new SearchHistoryListViewAdapter(getActivity(), list);
            binding.searchHistoryListView.setAdapter(searchHistoryListViewAdapter);
            binding.searchHistoryListView.setOnItemClickListener((adapterView, view1, i, l) -> {
                model = new ViewModelProvider(requireActivity()).get(SearchViewModel.class);

                model.addSearchKey(list.get(i).getSearchHistory());
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_searchHistoryFragment_to_searchResultFragment);
            });
        }

//        binding.clearSearchHistory.setOnClickListener(view1 -> {
//            LitePal.deleteAll(SearchHistoryBean.class);
//            binding.searchHistoryListView.setVisibility(View.GONE);
//        });

    }
}
