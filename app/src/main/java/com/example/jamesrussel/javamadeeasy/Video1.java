package com.example.jamesrussel.javamadeeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;



public class Video1  extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    public static final String API_KEY ="AIzaSyBu9QalG-8DDJRpxcqTn_-h7UAiI5dt3G8";
    public static final String VIDEO_KEY ="r59xYe3Vyks";
    FloatingActionButton fab_next, fab_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video1);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);


        fab_home = (FloatingActionButton) findViewById(R.id.fab_home);
        fab_next = (FloatingActionButton) findViewById(R.id.fab_next);
        fab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplicationContext(), Video2.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                overridePendingTransition(R.anim.push_out_left, R.anim.pull_in_right);
            }
        });

        fab_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failured to Initialize", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {

        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);


        if (!wasRestored){
            player.cueVideo(VIDEO_KEY);
        }

    }

private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
};

private  PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
    @Override
    public void onLoading() {

    }

    @Override
    public void onLoaded(String s) {

    }

    @Override
    public void onAdStarted() {

    }

    @Override
    public void onVideoStarted() {

    }

    @Override
    public void onVideoEnded() {

    }

    @Override
    public void onError(ErrorReason errorReason) {

    }
};

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(this,VideoTutorialsActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }


}
