package com.example.mymusic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.andexert.library.RippleView;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by SJC on 2020/4/22.
 * Describe：
 */
public class SearchFragment extends Fragment {
    @BindView(R.id.iv_back)
    RippleView ivBack;
    @BindView(R.id.edit_seek)
    EditText editSeek;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        return view;
    }

    @OnClick({R.id.iv_back, R.id.edit_seek})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                EventBus.getDefault().postSticky(new EventMessage(false));
                break;
            case R.id.edit_seek:
                break;
        }
    }
}
