package calculator.javahelps.com.quicksum;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends MainActivity implements View.OnClickListener{
    Button bBack, btn;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bBack = (Button)findViewById(R.id.bBack);
        bBack.setOnClickListener(this);

        intent = new Intent(SecondActivity.this, MainActivity.class);
    }

    public void onClickTopColour(View view) {
        btn = (Button)view;
        switch (view.getId()){
            case R.id.btRed:
               // ansText.setBackgroundColor(Color.RED);
                intent.putExtra("topColour","RED");
                Toast.makeText(this, "Turning the answer box background to "+ btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;

            case R.id.btWhite:
                //ansText.setBackgroundColor(Color.WHITE);
                intent.putExtra("topColour","WHITE");
                Toast.makeText(this, "Turning the answer box background to "+ btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;

            case R.id.btBlue:
               // ansText.setBackgroundColor(Color.BLUE);
                intent.putExtra("topColour","BLUE");
                Toast.makeText(this, "Turning the answer box background to "+ btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.btYellow:
               // ansText.setBackgroundColor(Color.YELLOW);
                intent.putExtra("topColour","YELLOW");
                Toast.makeText(this, "Turning the answer box background to "+ btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;

            case R.id.btBlack:
               // ansText.setBackgroundColor(Color.BLACK);
                intent.putExtra("topColour","BLACK");
                Toast.makeText(this, "Turning the answer box background to "+ btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;

            case R.id.btGreen:
               // ansText.setBackgroundColor(Color.GREEN);
                intent.putExtra("topColour","GREEN");
                Toast.makeText(this, "Turning the answer box background to "+ btn.getText(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bBack:
                startActivity(intent);
        }
    }
}
