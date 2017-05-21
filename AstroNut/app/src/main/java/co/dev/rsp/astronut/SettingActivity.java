package co.dev.rsp.astronut;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SettingActivity extends AppCompatActivity {

    EditText userName;
    SharedPreferences myPrefs;
    private static final String USER_NAME = "key_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        myPrefs = getPreferences(MODE_PRIVATE);
        //this retrieves a default preference file that belong to the activity. Same name as the project name with xml extension.
        init();
    }

    private void init() {
        userName = (EditText) findViewById(R.id.userNameText);
        readPreference();
    }

    private void readPreference() {
        String pref1 = myPrefs.getString(USER_NAME, "You");
        userName.setText(pref1);
    }

    public void onSave(View view) {
        Toast.makeText(getBaseContext(), "The Settings Options Are Now Saved", Toast.LENGTH_LONG).show();

        //retrieve info from both fields
        String nameText = userName.getText().toString();

        //start shared preferences editor
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString(USER_NAME, nameText);
        editor.apply();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    //this method will clear info from shared pref file
    public void onReset(View view) {
        Toast.makeText(getBaseContext(), "The Settings Are Now Reset", Toast.LENGTH_LONG).show();

        SharedPreferences.Editor editor = myPrefs.edit();
        editor.clear();
        editor.apply();

        readPreference();
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, SettingActivity.class);
    }

}
