package com.example.mymusic.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.example.mymusic.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.play_seek_bar)
    SeekBar playSeekBar;
    @BindView(R.id.song_name)
    TextView songName;
    @BindView(R.id.btn_player)
    Button btnPlayer;
    @BindView(R.id.song_next)
    RippleView songNext;
    @BindView(R.id.circle_singer_image)
    CircleImageView circleSingerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,new MainFragment())
                .commit();

    }
}
