package com.example.economicsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends AppCompatActivity {

    private TextView tvQuestion, tvScore, tvQuestionNo, tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;

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


        addQuestions();
        totalQuestions = questionList.size();
        showNextQuestions();

        }

    private void showNextQuestions() {
        if(qCounter < totalQuestions){
            currentQuestion = questionList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            qCounter++;

    }else  {
            finish();
        }

}

    private void addQuestions() {
        questionList.add(new QuestionModel( "A is correct?", "A","B","C", 1));
        questionList.add(new QuestionModel( "B is correct?",  "A",  "B",  "C", 2));
        questionList.add(new QuestionModel( "C is correct?",  "A",  "B",  "C", 3));
        questionList.add(new QuestionModel("A is correct?",  "A",  "B",  "C", 1));
        questionList.add(new QuestionModel("B is correct?",  "A", "B",  "C", 2));

    }
}