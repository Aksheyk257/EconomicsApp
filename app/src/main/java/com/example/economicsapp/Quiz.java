package com.example.economicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountAuthenticatorResponse;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends AppCompatActivity {

    private TextView tvQuestion, tvScore, tvQuestionNo, tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;
    int score;

    ColorStateList dfRbColor;
    boolean answered;

    CountDownTimer countDownTimer;


    private QuestionModel currentQuestion;



    private List<QuestionModel> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionList = new ArrayList<>();
        tvQuestion = findViewById(R.id.textQuestion);
        tvScore = findViewById(R.id.textScore);
        tvQuestionNo = findViewById(R.id.textQuestionsNo);
        tvTimer = findViewById(R.id.textTimer);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btnNext = findViewById(R.id.btnNext);

        dfRbColor = rb1.getTextColors();



        addQuestions();
        totalQuestions = questionList.size();
        showNextQuestions();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered == false){
                    if(rb1.isChecked()  || rb2.isChecked() || rb3.isChecked()){
                        checkAnswer();
                        checkAnswer();
                        countDownTimer.cancel();
                    }else {
                        Toast.makeText(Quiz.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextQuestions();

                }
            }
        });

        }

    private void checkAnswer() {
        answered = true;
            RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
            int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
            if(answerNo == currentQuestion.getCorrectAnsNo()){
                score++;
                tvScore.setText("score: "+score);


            }
            rb1.setTextColor(Color.RED);
            rb2.setTextColor(Color.RED);
            rb3.setTextColor(Color.RED);
            switch (currentQuestion.getCorrectAnsNo()){
                case 1:
                    rb1.setTextColor(Color.GREEN);
                    break;
                case 2:
                    rb2.setTextColor(Color.GREEN);
                    break;
                case 3:
                    rb3.setTextColor(Color.GREEN);
                    break;
            }
            if(qCounter < totalQuestions){
                btnNext.setText("Next");
            }else {
                btnNext.setText("Finsih");
            }

    }

    private void showNextQuestions() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);


        if(qCounter < totalQuestions){
            timer();
            currentQuestion = questionList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            qCounter++;
            btnNext.setText("Submit");
            tvQuestionNo.setText("Question: "+qCounter+"/"+totalQuestions);
            answered = false;


    }else  {
            finish();
        }


    }

    private void timer() {
        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Time: 00:"+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                showNextQuestions();

            }
        }.start();
    }



    private void addQuestions() {
        questionList.add(new QuestionModel( "What is the Law of demand?", "Higher price, consumers will demand lower quantity","Price goes up, consumers will demand more","Price goes down, consumers will demand less", 1));
        questionList.add(new QuestionModel( "Subsidies shift which curve?",  "Demand",  "market equilibrium",  "supply", 3));
        questionList.add(new QuestionModel( "What is the Law of supply?",  "Lower price, consmers will demand more",  "The price of a good or service increases, the quantity of goods or service that suppliers offer will increase",  "Demand curve", 2));
        questionList.add(new QuestionModel("What causes a market to fail?",  "Failing any of the 5 conditions",  "Less supply in the economy",  "Increase in price", 1));
        questionList.add(new QuestionModel("What can reduce consumption of a good or service?",  "Lower prices", "Increase in tax",  "Subsidise the economy", 2));

    }
}