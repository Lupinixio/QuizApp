package com.example.android.quizapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int mainCounter = 0;
    public static int wrongAnswer = 0;
    public static int rightAnswer = 0;
    protected static double score;
    public static Button button;
    TextView text;


//    //Context context = getApplicationContext();
//    CharSequence rightToast = "Great!! You guess!!";
//    CharSequence wrongToast = "Sorry, but you wrong!";
//    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        text = (TextView) findViewById(R.id.title);
        if (wrongAnswer == 0 && rightAnswer == 0) {
            text.setText("Test Your Knowledge about Earth!");
        } else {
            text.setText(String.format("Your final score is: %.2f", score));
            rightAnswer = 0;
            wrongAnswer = 0;
        }

        button = (Button) findViewById(R.id.buttonStartReset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainCounter++;
                Intent openQuestions = new Intent(MainActivity.this, Questions.class);
                startActivity(openQuestions);


            }
        });


    }


}
