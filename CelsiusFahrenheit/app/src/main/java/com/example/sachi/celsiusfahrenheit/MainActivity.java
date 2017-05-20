package com.example.sachi.celsiusfahrenheit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    LinearLayout bgLayout;
    float celsius, inputTemperature,fahrenheit;
    RadioButton celsiusRadio, fahrenheitRadio;
    EditText temperatureEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureEditText = (EditText)findViewById(R.id.temperature);

        celsiusRadio = (RadioButton)findViewById(R.id.celsiusRadio);
        fahrenheitRadio = (RadioButton) findViewById(R.id.fahrenheitRadio);

        setupOptionsButton(); // Opens settings activity
        refreshScreen(); // Changes the background colour

    }

    public void convertTempChange(View view) {
        //Button button = (Button) view;
        //Toast.makeText(this, "The button is working", Toast.LENGTH_SHORT).show();

        if(temperatureEditText.getText().length() == 0 ){
            Toast.makeText(this,"Please enter a valid input",Toast.LENGTH_LONG).show();
            return;
        }
        //Toast.makeText(this, "Working ",Toast.LENGTH_LONG).show();
        inputTemperature = Float.parseFloat(temperatureEditText.getText().toString());

        //Check which radio button is checked and act accordingly
        if (fahrenheitRadio.isChecked()){
            //Toast.makeText(this, "Celsius Radio Button is working " + inputTemperature,Toast.LENGTH_LONG).show();

            //Calculate the celsius
            celsius = ((inputTemperature - 32) * 5 / 9);
            temperatureEditText.setText(String.valueOf(celsius));
            celsiusRadio.setChecked(true);
            fahrenheitRadio.setChecked(false);

        } else {
          //Toast.makeText(this, "Fahrenheit Radio Button is working " + inputTemperature,Toast.LENGTH_LONG).show();

            //Calculate the fahrenheit
            fahrenheit = (float) ((inputTemperature * 1.8) +32);
            temperatureEditText.setText(String.valueOf(fahrenheit));
            celsiusRadio.setChecked(false);
            fahrenheitRadio.setChecked(true);
        }
    }

    private void refreshScreen() {
        //TextView textView = (TextView) findViewById(R.id.textView);

        // Access the settings background colour (Shared Preferences)
        String bgColour = SettingsActivity.getBackgroundColour(this);
        bgLayout = (LinearLayout) findViewById(R.id.bgLayout);

       //textView.setText("" + bgColour);

        // Change the background colour to the selected colour
        try{
            if(Objects.equals(bgColour, "Yellow")){
                bgLayout.setBackgroundColor(getColor(R.color.Yellow));
            } else if(Objects.equals(bgColour, "Green")){
                bgLayout.setBackgroundColor(getColor(R.color.Green));
            } else if(Objects.equals(bgColour, "Blue")){
                bgLayout.setBackgroundColor(getColor(R.color.Blue));
            } else {
                bgLayout.setBackgroundColor(getColor(R.color.White));
            }
        }catch (Exception e){
            bgLayout.setBackgroundColor(getColor(R.color.White));
        }
    }

    private void setupOptionsButton() {
        // Settings Button
        Button btn = (Button)findViewById(R.id.setting_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SettingsActivity.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshScreen();
    }
}
