package co.dev.rsp.astronut;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;



public class MainActivity extends AppCompatActivity {

    ImageButton newGameBtn, settingsBtn;
    Intent intent;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicPlay();

        newGameBtn = (ImageButton) findViewById(R.id.game_button);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"New Game Starting",Toast.LENGTH_LONG).show();
                intent = GameActivity.makeIntent(MainActivity.this);
                startActivity(intent);

            }
        });

        settingsBtn = (ImageButton) findViewById(R.id.options_button);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"Settings Starting",Toast.LENGTH_LONG).show();
                intent = SettingActivity.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }

    private void musicPlay() {
        //start playing the media player
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.background_app_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    
}