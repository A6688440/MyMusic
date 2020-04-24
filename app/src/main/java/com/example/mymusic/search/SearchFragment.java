package com.example.mymusic.search;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.andexert.library.RippleView;
import com.example.mymusic.R;
import com.example.mymusic.SearchViewModel;
import com.example.mymusic.bean.SearchHistoryBean;
import com.example.mymusic.event.EventMessage;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class SearchFragment extends Fragment {
    @BindView(R.id.iv_back)
    RippleView ivBack;
    @BindView(R.id.edit_seek)
    EditText editSeek;
    @BindView(R.id.tv_search)
    RippleView tvSearch;

    private Unbinder unbinder;
    private NavController controller = null;
    private SearchViewModel model;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(SearchViewModel.class);

    }


    @OnClick({R.id.iv_back, R.id.edit_seek, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onDestroyView();
                break;
            case R.id.tv_search:
                //进行搜索
                String searchKey = editSeek.getText().toString();
                if (searchKey.equals("")) {
                    searchKey = "邓紫棋";
                }
                model.addSearchKey(searchKey);

                SearchHistoryBean searchHistoryBean = new SearchHistoryBean();
                searchHistoryBean.setSearchHistory(searchKey);
                searchHistoryBean.save();


                if (controller == null) {
                    controller = Navigation.findNavController(getActivity(), R.id.fragment_nav_search_result);
                    controller.navigate(R.id.action_searchHistoryFragment_to_searchResultFragment);
                }
                //进行网络请求

                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
