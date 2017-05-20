package calculator.javahelps.com.quicksum;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView ansView;
    String display = "";
    String num1 = "", num2 = "0";
    double result;
    Button b1, b2, b3, bSet, bOther;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ansView = (TextView) findViewById(R.id.ansText);
        ansView.setText(display);

        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);

        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);

        bOther = (Button) findViewById(R.id.bOther);
        bOther.setOnClickListener(this);

        bSet = (Button) findViewById(R.id.bSet);
        bSet.setOnClickListener(this);

        getTopColor();
    }

    private void getTopColor() {
        try{
            String topColor= getIntent().getStringExtra("topColour");
            if (topColor.equals("RED")){
                ansView.setBackgroundColor(Color.RED);}
            else if (topColor.equals("WHITE")){
                ansView.setBackgroundColor(Color.WHITE);}
            else if (topColor.equals("BLUE")){
                ansView.setBackgroundColor(Color.BLUE);}
            else if (topColor.equals("YELLOW")){
                ansView.setBackgroundColor(Color.YELLOW);}
            else if (topColor.equals("BLACK")){
                ansView.setBackgroundColor(Color.BLACK);
                ansView.setTextColor(Color.WHITE);}
            else{
                ansView.setBackgroundColor(Color.GREEN);}

        }catch (Exception e){
                ansView.setBackgroundColor(Color.WHITE);
            }
    }

    private void updateScreen() {
        ansView.setText(display);
    }

    public void onClickNumber(View view) {
        Button b = (Button) view;
        display += b.getText();

        num1 = (String) b.getText();
            if (num1.equals("1/2")){
                num1 = "0.5";
            }else if (num1.equals("1/3")){
                num1 = "0.3333";
            } else if (num1.equals("1/4")){
                num1 = "0.25";
            } else {
                display = "0";
            }
            result = Double.valueOf(num1) + Double.valueOf(num2);
            display = String.valueOf(result);

            num2 = display;

        updateScreen();
        clear();
    }

    private void clear() {
        display = "";
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.b1:
                onClickNumber(v);
                b1.setText("1");
                b2.setText("2");
                b3.setText("3");
                break;

            case R.id.b2:
                onClickNumber(v);
                b1.setText("1");
                b2.setText("2");
                b3.setText("3");
                break;

            case R.id.b3:
                onClickNumber(v);
                b1.setText("1");
                b2.setText("2");
                b3.setText("3");
                break;

            case R.id.bOther:
                b1.setText("1/2");
                b2.setText("1/3");
                b3.setText("1/4");
                break;

            case R.id.bSet:
                //Toast.makeText(this, "button10 is working", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}

