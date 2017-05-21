package co.dev.rsp.astronut;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;


public class SplashActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //start playing the media player
        mediaPlayer = MediaPlayer.create(this, R.raw.splash_screen_night_crickets);
        mediaPlayer.start();

        //Handler will run the method after 5 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //After 5 seconds the methods will run and go to the main activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        },4000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //check to if the media player is working, if yes the media player is stopped
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        this.finish();
    }
}
