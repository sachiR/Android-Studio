package com.example.sachi.celsiusfahrenheit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    public static Intent makeIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        createColourRadioGroup();

        String savedValue = getBackgroundColour(this);
        //Toast.makeText(this, "saved Value "+savedValue,Toast.LENGTH_LONG).show();
    }

    private void createColourRadioGroup() {
        RadioGroup colourGroup = (RadioGroup) findViewById(R.id.radio_group_colour);
        String [] backgroundColours = getResources().getStringArray(R.array.background_colour);

        //Create a button
        for(int i = 0; i < backgroundColours.length;i++){
            final String backgroundColour = backgroundColours[i];

            RadioButton button = new RadioButton(this);
            button.setText(backgroundColour);

            //Set on click callbacks
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SettingsActivity.this,backgroundColour + " is selected",Toast.LENGTH_LONG).show();

                    saveColourChange(backgroundColour);
                }
            });

            //Add to radio group
            colourGroup.addView(button);

            //Select default button
            if(Objects.equals(backgroundColour, getBackgroundColour(this))){
                button.setChecked(true);

            }
        }
    }

    private void saveColourChange(String backgroundColour) {
        //Saving Colour Changes
        SharedPreferences preferences = this.getSharedPreferences("AppPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Background Colour",backgroundColour);
        editor.apply();
    }

    static public String getBackgroundColour(Context context){
        //Share the preferences with MainActivity
        SharedPreferences preferences = context.getSharedPreferences("AppPrefs",MODE_PRIVATE);
        String defaultColour = context.getResources().getString(R.string.default_colour);

        //Set default colour
        return preferences.getString("Background Colour",defaultColour);
    }
}
