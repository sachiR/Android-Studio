package sachi.example.com.guessthecelebrity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivityFragment extends Fragment implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4;
    ImageView celebImage;

    private Quesions mQuestions = new Quesions();
    private String mAnswer;
    private int mQuestionsLength = mQuestions.images_list.length;
    int num ;
    Random r = new Random();
    int randomNumber;
    public MainActivityFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        btn1 = (Button)view.findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = (Button)view.findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = (Button)view.findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = (Button)view.findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        celebImage= (ImageView) view.findViewById(R.id.celebImage);
        nextQuestion();

        return view;
    }
    private int randomNumberGenerate() {
       randomNumber = r.nextInt(mQuestionsLength);
        while (randomNumber == num){
            randomNumber = r.nextInt(mQuestionsLength);
        }
        num = randomNumber;
        return num;
    }

    private void updateQuestion(int num) {
        int imageSelection = mQuestions.images_list[num];
        celebImage.setImageResource(imageSelection);

        btn1.setText(mQuestions.getChoice1(num));
        btn2.setText(mQuestions.getChoice2(num));
        btn3.setText(mQuestions.getChoice3(num));
        btn4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    private void setColour() {
        try {
            String colour = getArguments().getString("colour");
            if(colour.equals("RED")){
                celebImage.setBackgroundColor(Color.RED);
            }
        }catch (Exception e){

        }
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        if (btn.getText().equals(mAnswer)){
            Toast.makeText(getContext(), "Correct",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "Wrong, The Answer is "+mAnswer,Toast.LENGTH_SHORT).show();
        }
        nextQuestion();
    }

    private void nextQuestion() {
        int randNum = randomNumberGenerate();
        updateQuestion(randNum);
        setColour();
    }
}