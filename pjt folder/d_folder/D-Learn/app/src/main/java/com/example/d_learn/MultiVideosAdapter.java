package com.example.d_learn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MultiVideosAdapter extends RecyclerView.Adapter<MultiVideosAdapter.MultiVideoViewHolder> {
    Context ct;
    String myLinks[];
    public MultiVideosAdapter(MultipleVideosActivity multipleVideosActivity, String[] links) {
        ct = multipleVideosActivity;
        myLinks = links;
    }
    @NonNull
    @Override
    public MultiVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MultiVideoViewHolder(LayoutInflater.from(ct).inflate(R.layout.multiple_videos_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MultiVideoViewHolder holder, final int position) {
        holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = myLinks[position];
                youTubePlayer.loadVideo(videoId, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myLinks.length;
    }

    public class MultiVideoViewHolder extends RecyclerView.ViewHolder {
        YouTubePlayerView youTubePlayerView;
        public MultiVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
        }
    }
}
