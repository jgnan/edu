package org.shenit.tutorial.android.media;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import org.shenit.tutorial.android.R;

public class LocalMediaExampleActivity extends AppCompatActivity
        implements MediaPlayer.OnCompletionListener,SeekBar.OnSeekBarChangeListener {
    private Button playButton;
    private Button stopButton;
    private SeekBar progressBar;
    private MediaPlayer player;
    private boolean playing = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_media_player_example);
        playButton = (Button) findViewById(R.id.play_btn);
        stopButton = (Button) findViewById(R.id.stop_btn);
        progressBar = (SeekBar) findViewById(R.id.progress_bar);

        player = MediaPlayer.create(this,R.raw.sample_sound);
        //完结时调用的接口
        player.setOnCompletionListener(this);

        //如果拖动进度条可以调整经度
        progressBar.setOnSeekBarChangeListener(this);
        progressBar.setEnabled(false);
        progressBar.setProgress(0);

        progressTask.execute();
    }

    public void onPlayClick(View view){
        if(! player.isPlaying()) {
            player.start();
            playButton.setText("Pause");
            stopButton.setEnabled(true);    //Enable stop button
            progressBar.setEnabled(true);
            playing = true;
        } else {
            player.pause();
            playButton.setText("Resume");
            playing = false;
        }
    }

    public void onStopClick(View view){
        if(!player.isPlaying()) return;
        player.stop();
        onCompletion(player);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(player.isPlaying()) player.stop();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        playButton.setText("Play");
        progressBar.setProgress(0);
        progressBar.setEnabled(false);
        stopButton.setEnabled(false);
        playing = false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        player.seekTo(player.getDuration() * progress / 100);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    private AsyncTask<Integer,Integer,Integer> progressTask = new AsyncTask<Integer, Integer, Integer>(){

        @Override
        protected Integer doInBackground(Integer[] params) {
            do {
                float duration = player.getDuration();
                float pos = player.getCurrentPosition();
                publishProgress((int) (pos * 100  / duration));
            }while(true);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if(playing) progressBar.setProgress(values[0]);
        }
    };
}
