package com.example.d_learn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;


import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
/*import com.google.android.youtube.player.YouTubePlayerView;*/
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class CourseOneMateral extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_player);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "3QNW3guTYU8";
                youTubePlayer.loadVideo(videoId, 1);
            }
        });


    }

    public void showMoreVideos(View view) {
        Intent intent=new Intent(this,MultipleVideosActivity.class);
        startActivity(intent);
    }
}