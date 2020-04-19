package com.example.mymusic.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mymusic.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.skip_welcome)
    TextView skipWelcome;

    private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        service.scheduleAtFixedRate(() -> {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }, 3000, 3000, TimeUnit.MILLISECONDS);
    }

    @OnClick(R.id.skip_welcome)
    public void onViewClicked() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        service.shutdownNow();
    }
}
