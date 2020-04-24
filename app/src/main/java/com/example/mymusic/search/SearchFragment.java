package com.example.mymusic.search;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.andexert.library.RippleView;
import com.example.mymusic.R;
import com.example.mymusic.bean.SearchHistoryBean;
import com.example.mymusic.search.view_model.SearchHistoryViewModel;
import com.example.mymusic.search.view_model.SearchViewModel;

import org.litepal.LitePal;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class SearchFragment extends Fragment {
    private static final String TAG = "SearchFragment";
    @BindView(R.id.iv_back)
    RippleView ivBack;
    @BindView(R.id.edit_seek)
    EditText editSeek;
    @BindView(R.id.tv_search)
    RippleView tvSearch;

    private Unbinder unbinder;
    private NavController controller = null;

    private SearchViewModel model;
    private SearchHistoryBean searchHistoryBean;
    private SearchHistoryViewModel stateModel;
    private String searchKey;

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
        stateModel = new ViewModelProvider(requireActivity()).get(SearchHistoryViewModel.class);

    }


    @SuppressLint("ResourceType")
    @OnClick({R.id.iv_back, R.id.edit_seek, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                if (stateModel.getState().getValue()) {
                    controller.popBackStack();
                } else {
                    getActivity().onBackPressed();
                }
                break;
            case R.id.tv_search:
                //进行搜索
                searchKey = editSeek.getText().toString();
                if (searchKey.equals("")) {
                    searchKey = "邓紫棋";
                }


                List<SearchHistoryBean> beanList = LitePal.where("search=?", searchKey).
                        find(SearchHistoryBean.class);
                if (beanList != null || beanList.size() != 0) {
                    for (SearchHistoryBean bean : beanList) {
                        bean.delete();
                    }
                }
                searchHistoryBean = new SearchHistoryBean();
                searchHistoryBean.setSearch(searchKey);
                searchHistoryBean.save();

                if (!stateModel.getState().getValue()) {
                    model.addSearchKey(searchKey);


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
        controller = null;
        unbinder.unbind();
    }
}
