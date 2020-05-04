package com.example.mymusic.search.album;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.mymusic.R;
import com.example.mymusic.databinding.FragmentAlbumInfoBinding;
import com.example.mymusic.search.view_model.AlbumInfoViewModel;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlbumInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbumInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private FragmentAlbumInfoBinding binding;
    private AlbumInfoViewModel infoViewModel;

    public AlbumInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlbumInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlbumInfoFragment newInstance(String param1, String param2) {
        AlbumInfoFragment fragment = new AlbumInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAlbumInfoBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialViewPagerHelper.registerScrollView(getActivity(), binding.scrollViewInfo);
        infoViewModel = new ViewModelProvider(requireActivity()).get(AlbumInfoViewModel.class);
        infoViewModel.getData().observe(requireActivity(), dataBean -> {
            binding.tvAlbumName.setText(dataBean.getName());
            binding.tvLanguage.setText(dataBean.getLan());
            binding.tvCompany.setText(dataBean.getCompany());
            binding.tvPublicTime.setText(dataBean.getADate());
            binding.tvAlbumType.setText(dataBean.getGenre());
            binding.tvDesc.setText(dataBean.getDesc());
        });
    }
}
