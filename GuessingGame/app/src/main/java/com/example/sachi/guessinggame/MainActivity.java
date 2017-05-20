package com.example.sachi.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView statusText, minView, maxView, textView;
    private EditText guessText;
    private SeekBar minBar, maxBar;
    private Button btnSet, btnBack;
    int minProgess, maxProgess;

    Random random = new Random();
    private int secretNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = (TextView)findViewById(R.id.statusText);
        guessText = (EditText)findViewById(R.id.guessText);
        textView = (TextView)findViewById(R.id.textView);

        secretNum = random.nextInt(9) + 1;
      //  textView.setText(String.valueOf(secretNum));

        minView = (TextView) findViewById(R.id.minView);
        minBar = (SeekBar)findViewById(R.id.minBar);

        maxView = (TextView) findViewById(R.id.maxView);
        maxBar = (SeekBar)findViewById(R.id.maxBar);

        btnSet = (Button) findViewById(R.id.btnSet);
        btnSet.setOnClickListener(this);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);



        guessText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    int value = Integer.parseInt(s.toString());

                    if (value == secretNum){
                        statusText.setText("You Guessed It");
                    } else if (value > secretNum) {
                        statusText.setText("Try Smaller");
                    } else {
                        statusText.setText("Try Bigger");
                    }

                } catch (Exception e) {
                    statusText.setText(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void changeMinBar(){
        minBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        minProgess = progress;
                        minView.setText("Min: "+ minProgess );
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        minView.setText("Min: "+ minProgess );
                    }
                });
    }

    public void changeMaxBar(){
        maxBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        maxProgess = progress;

                        if (maxProgess < minProgess) {
                            maxView.setText("Max: invalid" );
                        }
                        maxView.setText("Max: "+ maxProgess );
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        if (maxProgess < minProgess) {
                            maxView.setText("Max: invalid" );
                        }else {
                            maxView.setText("Max: " + maxProgess);
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSet:
                minView.setVisibility(v.VISIBLE);
                minBar.setVisibility(v.VISIBLE);

                maxView.setVisibility(v.VISIBLE);
                maxBar.setVisibility(v.VISIBLE);

                btnBack.setVisibility(v.VISIBLE);
                changeMinBar();
                changeMaxBar();
                break;

            case R.id.btnBack:
                minView.setVisibility(v.INVISIBLE);
                minBar.setVisibility(v.INVISIBLE);

                maxView.setVisibility(v.INVISIBLE);
                maxBar.setVisibility(v.INVISIBLE);

                btnBack.setVisibility(v.INVISIBLE);

                if (minProgess > maxProgess) {
                    Toast.makeText(this, "Invalid, The maximum has to be greater than minimum", Toast.LENGTH_SHORT).show();
                } else {
                    secretNum = random.nextInt(maxProgess) + minProgess;
                    //  textView.setText(String.valueOf(secretNum));
                }
                break;
        }
    }
}
