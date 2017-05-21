package co.dev.rsp.astronut;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HighestScoreActivity extends AppCompatActivity {

    TextView textScoreView, textHighScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        textScoreView = (TextView) findViewById(R.id.textScore);
        textHighScoreView = (TextView) findViewById(R.id.textHighScore);

        //Use Intent to retrieve the score
        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);

        //display current score
        textScoreView.setText("Your Score: " + score);

        //use Shared preferences to save the best score
        SharedPreferences myPreferences = getPreferences(MODE_PRIVATE);
        int highScore = myPreferences.getInt("highScore",0);
        if(highScore>= score)
            textHighScoreView.setText("High Score: " + highScore);
        else
        {
            textHighScoreView.setText("New High Score: " + score);
            SharedPreferences.Editor editor = myPreferences.edit();
            editor.putInt("highScore", score);
            editor.apply();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonReset:
                Intent intent = new Intent(HighestScoreActivity.this, GameActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonHome:
                Toast.makeText(HighestScoreActivity.this, "This is the home button", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.buttonSettings:
                Toast.makeText(HighestScoreActivity.this, "This is the settings button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

