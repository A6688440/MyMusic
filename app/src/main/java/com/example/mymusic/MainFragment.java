package com.example.mymusic;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mymusic.event.EventMessage;

import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by SJC on 2020/4/19.
 * Describe：
 */
public class MainFragment extends Fragment {

    private static final String TAG = "123456";
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.tv_listen)
    TextView tvListen;
    @BindView(R.id.tv_look)
    TextView tvLook;
    @BindView(R.id.tv_seek)
    TextView tvSeek;
    @BindView(R.id.cv_jay)
    CircleImageView cvJay;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_local_music_num)
    TextView tvLocalMusicNum;
    @BindView(R.id.linear_local)
    LinearLayout linearLocal;
    @BindView(R.id.tv_collection_num)
    TextView tvCollectionNum;
    @BindView(R.id.linear_collection)
    LinearLayout linearCollection;
    @BindView(R.id.tv_download_num)
    TextView tvDownloadNum;
    @BindView(R.id.linear_download)
    LinearLayout linearDownload;
    @BindView(R.id.tv_history_num)
    TextView tvHistoryNum;
    @BindView(R.id.linear_history)
    LinearLayout linearHistory;
    @BindView(R.id.expand_list_view_song_list)
    ExpandableListView expandListViewSongList;
    private Unbinder unbinder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
       // tvSeek.setOnClickListener(view1 ->EventBus.getDefault().postSticky(new EventMessage(true)) );
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @OnClick({R.id.tv_me, R.id.tv_listen, R.id.tv_look, R.id.tv_seek, R.id.tv_local_music_num, R.id.linear_local, R.id.tv_collection_num, R.id.linear_collection, R.id.tv_download_num, R.id.linear_download, R.id.tv_history_num, R.id.linear_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_me:
                break;
            case R.id.tv_listen:
                break;
            case R.id.tv_look:
                break;
            case R.id.tv_seek:
                NavController controller= Navigation.findNavController(view);
                controller.navigate(R.id.action_mainFragment_to_searchFragment);
                break;
            case R.id.linear_local:
                break;
            case R.id.linear_collection:
                break;
            case R.id.linear_download:
                break;
            case R.id.linear_history:
                break;

            case R.id.tv_collection_num:
                break;
            case R.id.tv_local_music_num:
                break;
            case R.id.tv_download_num:
                break;
            case R.id.tv_history_num:
                break;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
