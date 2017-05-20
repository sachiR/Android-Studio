package sachi.example.com.guessthecelebrity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondaryFragment extends Fragment implements View.OnClickListener{
    static String colour;
    TextView textView;
    Button btRed,btWhite,btBlue,btYellow,btGreen,btBlack;
    public SecondaryFragment(){
    }

    public static SecondaryFragment newInstance(int index) {
        SecondaryFragment f = new SecondaryFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putString("colour", colour);
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secondary, container, false);
        textView = (TextView)view.findViewById(R.id.textView);

        btRed = (Button)view.findViewById(R.id.btRed);
        btRed.setOnClickListener(this);

        btWhite = (Button)view.findViewById(R.id.btWhite);
        btWhite.setOnClickListener(this);

        btBlue = (Button)view.findViewById(R.id.btBlue);
        btBlue.setOnClickListener(this);

        btYellow = (Button)view.findViewById(R.id.btYellow);
        btYellow.setOnClickListener(this);

        btGreen = (Button)view.findViewById(R.id.btGreen);
        btGreen.setOnClickListener(this);

        btBlack = (Button)view.findViewById(R.id.btBlack);
        btBlack.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        btRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Colour is "+btRed.getText(),Toast.LENGTH_SHORT).show();
                colour = "RED";
                textView.setBackgroundColor(Color.RED);
            }
        });

        btWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Colour is "+btWhite.getText(),Toast.LENGTH_SHORT).show();
                colour = "WHITE";
                textView.setBackgroundColor(Color.WHITE);
            }
        });

        btBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Colour is "+btBlue.getText(),Toast.LENGTH_SHORT).show();
                colour = "BLUE";
                textView.setBackgroundColor(Color.BLUE);
            }
        });

        btYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Colour is "+btYellow.getText(),Toast.LENGTH_SHORT).show();
                colour = "YELLOW";
                textView.setBackgroundColor(Color.YELLOW);
            }
        });

        btGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Colour is "+btGreen.getText(),Toast.LENGTH_SHORT).show();
                colour = "GREEN";
                textView.setBackgroundColor(Color.GREEN);
            }
        });

        btBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Colour is "+btBlack.getText(),Toast.LENGTH_SHORT).show();
                colour = "BLACK";
                textView.setBackgroundColor(Color.BLACK);
            }
        });
    }


}

