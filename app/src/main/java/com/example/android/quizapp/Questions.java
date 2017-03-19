package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by leoca on 25/06/2016.
 */
public class Questions extends AppCompatActivity {

    int flag = 0;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    LinearLayout layout_button;
    LinearLayout checkbox_view;
    RadioGroup layout_radio;
    String writtenAnswer = "";
    TextView titleTextView;
    TextView questionTextView;
    EditText editSpace;
    String[] answer = {"EVEREST", "AMAZON", "ASIA", "CHINA", "pacific ocean"};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        editSpace = (EditText) findViewById(R.id.edit_text);
        editSpace.setVisibility(View.GONE);

        layout_button = (LinearLayout)findViewById(R.id.layout_button);
        layout_button.setVisibility(View.VISIBLE);

        layout_radio = (RadioGroup)findViewById(R.id.layout_radio);
        layout_radio.setVisibility(View.GONE);

        checkbox_view = (LinearLayout)findViewById(R.id.checkbox_view);
        checkbox_view.setVisibility(View.GONE);

        buttonA = (Button) findViewById(R.id.button1);
        buttonB = (Button) findViewById(R.id.button2);
        buttonC = (Button) findViewById(R.id.button3);
        buttonD = (Button) findViewById(R.id.button4);

        titleTextView = (TextView) findViewById(R.id.title);
        questionTextView = (TextView) findViewById(R.id.question);


        buttonA.setOnClickListener(onClickListener);
        buttonB.setOnClickListener(onClickListener);
        buttonC.setOnClickListener(onClickListener);
        buttonD.setOnClickListener(onClickListener);

        titleTextView.setText("Question 1");
        questionTextView.setText(R.string.first_question);
        buttonA.setText(R.string.first_a);
        buttonB.setText(R.string.first_b);
        buttonC.setText(R.string.first_c);
        buttonD.setText(R.string.first_d);

        setQuestion();


    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.button1:
                    flag = 1;
                    if (answerChecker()) {
                        Toast toastRightAnswer = Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT);
                        toastRightAnswer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 400);
                        toastRightAnswer.show();
                        setQuestion();
                    }
                    break;
                case R.id.button2:
                    flag = 2;
                    if (answerChecker()) {
                        Toast toastRightAnswer = Toast.makeText(getApplicationContext(), "Nice Job!", Toast.LENGTH_SHORT);
                        toastRightAnswer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 400);
                        toastRightAnswer.show();
                        setQuestion();
                    }
                    break;
                case R.id.button3:
                    flag = 3;
                    if (answerChecker()) {
                        Toast toastRightAnswer = Toast.makeText(getApplicationContext(), "Awesome!", Toast.LENGTH_SHORT);
                        toastRightAnswer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 400);
                        toastRightAnswer.show();
                        setQuestion();
                    }
                    break;
                case R.id.button4:
                    if (MainActivity.mainCounter == 5) {
                        EditText inputText = (EditText) findViewById(R.id.edit_text);
                        writtenAnswer = inputText.getText().toString();
                        if (writtenAnswer.equals(answer[4])) {
                            MainActivity.mainCounter++;
                            MainActivity.rightAnswer++;
                            Toast toastRightAnswer = Toast.makeText(getApplicationContext(), "You rock!", Toast.LENGTH_SHORT);
                            toastRightAnswer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 400);
                            toastRightAnswer.show();
                            setQuestion();
                        } else {
                            MainActivity.mainCounter++;
                            MainActivity.wrongAnswer++;
                            setQuestion();

                        }

                    }
                    flag = 4;
                    if (answerChecker()) {
                        Toast toastRightAnswer = Toast.makeText(getApplicationContext(), "You are a genius!", Toast.LENGTH_SHORT);
                        toastRightAnswer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 400);
                        toastRightAnswer.show();

                        setQuestion();
                    }
                    break;
            }

        }
    };

    //Check if the given answer is correct

    public boolean answerChecker() {
        if (MainActivity.mainCounter == 1 && flag == 1) {
            MainActivity.mainCounter++;
            MainActivity.rightAnswer++;
            return true;
        } else if (MainActivity.mainCounter == 2 && flag == 3) {
            MainActivity.mainCounter++;
            MainActivity.rightAnswer++;
            return true;
        } else if (MainActivity.mainCounter == 3 && flag == 2) {
            MainActivity.mainCounter++;
            MainActivity.rightAnswer++;
            return true;
        } else if (MainActivity.mainCounter == 4 && flag == 3) {
            MainActivity.mainCounter++;
            MainActivity.rightAnswer++;
            return true;
        } else if (MainActivity.mainCounter == 6 && flag == 1) {
            MainActivity.mainCounter++;
            MainActivity.rightAnswer++;
            return true;
        } else {
            MainActivity.wrongAnswer++;
            Toast toastRightAnswer = Toast.makeText(getApplicationContext(), "Try Again!", Toast.LENGTH_SHORT);
            toastRightAnswer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 400);
            toastRightAnswer.show();
            return false;

        }


    }

    // Update the content of the view

    public void setQuestion() {
        if (MainActivity.mainCounter == 1) {
            titleTextView.setText("Question " + MainActivity.mainCounter);
            questionTextView.setText(R.string.first_question);
            buttonA.setText(R.string.first_a);
            buttonB.setText(R.string.first_b);
            buttonC.setText(R.string.first_c);
            buttonD.setText(R.string.first_d);
        } else if (MainActivity.mainCounter == 2) {
            titleTextView.setText("Question " + MainActivity.mainCounter);
            questionTextView.setText(R.string.second_question);
            buttonA.setText(R.string.second_a);
            buttonB.setText(R.string.second_b);
            buttonC.setText(R.string.second_c);
            buttonD.setText(R.string.second_d);
        } else if (MainActivity.mainCounter == 3) {
            titleTextView.setText("Question " + MainActivity.mainCounter);
            questionTextView.setText(R.string.third_question);
            buttonA.setText(R.string.third_a);
            buttonB.setText(R.string.third_b);
            buttonC.setText(R.string.third_c);
            buttonD.setText(R.string.third_d);

        } else if (MainActivity.mainCounter == 4) {
            titleTextView.setText("Question " + MainActivity.mainCounter);
            questionTextView.setText(R.string.fourth_question);
            buttonA.setText(R.string.fourth_a);
            buttonB.setText(R.string.fourth_b);
            buttonC.setText(R.string.fourth_c);
            buttonD.setText(R.string.fourth_d);

        } else if (MainActivity.mainCounter == 5) {
            titleTextView.setText("Question " + MainActivity.mainCounter);
            questionTextView.setText(R.string.fifth_question);
            editSpace.setVisibility(View.VISIBLE);
            buttonA.setVisibility(View.GONE);
            buttonB.setVisibility(View.GONE);
            buttonC.setVisibility(View.GONE);
            buttonD.setText("Submit");
        } else if (MainActivity.mainCounter == 6) {
            titleTextView.setText("Question " + MainActivity.mainCounter);
            questionTextView.setText(R.string.sixth_question);
            editSpace.setVisibility(View.GONE);
            buttonA.setVisibility(View.VISIBLE);
            buttonB.setVisibility(View.VISIBLE);
            buttonC.setVisibility(View.VISIBLE);
            buttonD.setVisibility(View.VISIBLE);
            buttonA.setText(R.string.sixth_a);
            buttonB.setText(R.string.sixth_b);
            buttonC.setText(R.string.sixth_c);
            buttonD.setText(R.string.sixth_d);
        } else if (MainActivity.mainCounter == 7) {
            MainActivity.mainCounter = 0;
            MainActivity.wrongAnswer--;
            MainActivity.score = ((double) MainActivity.rightAnswer / (double) (MainActivity.rightAnswer + MainActivity.wrongAnswer)) * 100;
            Intent openQuestions = new Intent(Questions.this, MainActivity.class);
            startActivity(openQuestions);

        }
    }

}
