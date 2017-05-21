package co.dev.rsp.astronut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Questions questionBack = new Questions();
    private TextView currentTotalScoreView;   // view for current total score
    private TextView counddownTimer; // timer
    private ImageView currentQuestionView;  //current question to answer
    private Button buttonChoice1; // multiple choice 1 for mQuestionView
    private Button buttonChoice2; // multiple choice 2 for mQuestionView
    private Button buttonChoice3; // multiple choice 3 for mQuestionView
    private Button buttonChoice4; // multiple choice 4 for mQuestionView

    private int totalScore = 0;  // current total score
    private int currentQuestionNumber = 0; // current question number
    private String correctAnswer; // correct answer for question in mQuestionView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up game screen for the first question and four multiple choice answers
        currentTotalScoreView = (TextView) findViewById(R.id.txtScore);
        currentQuestionView = (ImageView) findViewById(R.id.image_view);
        counddownTimer = (TextView) findViewById(R.id.txtTime);
        buttonChoice1 = (Button) findViewById(R.id.btn1);
        buttonChoice2 = (Button) findViewById(R.id.btn2);
        buttonChoice3 = (Button) findViewById(R.id.btn3);
        buttonChoice4 = (Button) findViewById(R.id.btn4);
        updateQuestion();

        //show current total score for the user
        updateScore(totalScore);
    }

    private void updateQuestion() {
        //check to see if the array bounds are still inside for questions
        if (currentQuestionNumber < questionBack.getLength()) {
            //set the question for new question and new 4 answer buttons
            currentQuestionView.setImageResource(questionBack.get_question(currentQuestionNumber));
            buttonChoice1.setText(questionBack.get_choice(currentQuestionNumber, 1));
            buttonChoice2.setText(questionBack.get_choice(currentQuestionNumber, 2));
            buttonChoice3.setText(questionBack.get_choice(currentQuestionNumber, 3));
            buttonChoice4.setText(questionBack.get_choice(currentQuestionNumber,4));
            correctAnswer = questionBack.get_correct_answer(currentQuestionNumber);
            currentQuestionNumber++;
        }
        else {
            Toast.makeText(MainActivity.this, "You Have Answered All The Questions Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", totalScore); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    //show current total score for the user
    private void updateScore(int totalScore){
        currentTotalScoreView.setText(""+totalScore+"/"+questionBack.getLength());
    }

    public void onClick(View view){
        //all buttons and their logics
        Button answer = (Button) view;

        //if the answer is correct, increase the score
        if (answer.getText() == correctAnswer){
            totalScore = totalScore + 1;
            Toast.makeText(MainActivity.this,"Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Wrong!",Toast.LENGTH_SHORT).show(); }

        //show current total score for the user
        updateScore(totalScore);

        //once user answers the question, move on to the next one, if any questions left
        updateQuestion();
    }
}