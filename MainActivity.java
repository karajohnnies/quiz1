package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toast correctToast;
    private Toast wrongToast;
    private RadioButton question1Radiogroup;
    private RadioButton question2Radiogroup;
    private RadioButton question3Radiogroup;
    private RadioButton question4Radiogroup;
    private RadioGroup radioGroup;
    private TextView textQuestion;
    private TextView scoreText;
    private TextView questionNumber;
    private Button submitButton;
    private Button resetButton;

    private int score = 0;
    private int question = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submitButton);
        resetButton = (Button) findViewById(R.id.ResetButton);
        radioGroup = (RadioGroup) findViewById(R.id.radiogrp);
        question1Radiogroup = (RadioButton) findViewById(R.id.question1RadioGroup);
        question2Radiogroup = (RadioButton) findViewById(R.id.question2RadioGroup);
        question3Radiogroup = (RadioButton) findViewById(R.id.question3RadioGroup);
        question4Radiogroup = (RadioButton) findViewById(R.id.question4RadioGroup);
        questionNumber = (TextView) findViewById(R.id.questionNumber);
        scoreText = (TextView) findViewById(R.id.scoreText);


    }

    public void checkRadioButton(View view) {


        if (question1Radiogroup.isChecked() || question2Radiogroup.isChecked() || question3Radiogroup.isChecked() || question4Radiogroup.isChecked() || question == 0) {
            nextQuestion();
        }
    }

    public void reset(View view) {
        score = 0;
        question = 0;
        textQuestion.setVisibility(View.VISIBLE);
        questionNumber.setVisibility(View.VISIBLE);
        submitButton.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.INVISIBLE);

        nextQuestion();
    }

    public void sum() {

        radioGroup.setVisibility(View.INVISIBLE);
        question1Radiogroup.setVisibility(View.INVISIBLE);
        question2Radiogroup.setVisibility(View.INVISIBLE);
        question3Radiogroup.setVisibility(View.INVISIBLE);
        question4Radiogroup.setVisibility(View.INVISIBLE);
        textQuestion.setVisibility(View.INVISIBLE);
        scoreText.setVisibility(View.VISIBLE);
        questionNumber.setVisibility(View.INVISIBLE);
        submitButton.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.VISIBLE);

        if (score < 2)
            scoreText.setText(getString(R.string.notgood) + score + getString(R.string.maxvalue));
        if (score >= 2 && score <= 3)
            scoreText.setText(getString(R.string.good) + score + getString(R.string.maxvalue));
        if (score == 4)
            scoreText.setText(getString(R.string.verygood) + score + getString(R.string.maxvalue));
        if (score == 5)
            scoreText.setText(getString(R.string.excellent) + score + getString(R.string.maxvalue));

    }

    public void nextQuestion() {


        if (question <= 5) {

            radioGroup.setVisibility(View.VISIBLE);

            submitButton.setText(R.string.nextquestion);

            correctToast = Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT);
            wrongToast = Toast.makeText(MainActivity.this, R.string.wrong, Toast.LENGTH_SHORT);

            if (question == 1 && question1Radiogroup.isChecked()) {
                score++;
                correctToast.show();

            } else if (question == 2 && question3Radiogroup.isChecked()) {
                score++;
                correctToast.show();

            } else if (question == 3 && question2Radiogroup.isChecked()) {
                score++;
                correctToast.show();
            } else if (question == 4 && question2Radiogroup.isChecked()) {
                score++;
                correctToast.show();
            } else if (question == 5 && question4Radiogroup.isChecked()) {
                score++;
                correctToast.show();

            } else if (question > 0) wrongToast.show();

            question++;

            radioGroup.clearCheck();

            questionNumber.setText(getString(R.string.question) + question + getString(R.string.maxvalue));

            textQuestion = (TextView) findViewById(R.id.questionText);
            textQuestion.setText(R.string.question01);
            if (question == 2)
                textQuestion.setText(R.string.question02);
            if (question == 3)
                textQuestion.setText(R.string.question03);
            if (question == 4)
                textQuestion.setText(R.string.question04);
            if (question == 5)
                textQuestion.setText(R.string.question05);


            question1Radiogroup.setVisibility(View.VISIBLE);
            question1Radiogroup.setText(R.string.answer01);

            if (question == 2)
                question1Radiogroup.setText(R.string.answer02);
            if (question == 3)
                question1Radiogroup.setText(R.string.answer03);
            if (question == 4)
                question1Radiogroup.setText(R.string.answer04);
            if (question == 5)
                question1Radiogroup.setText(R.string.answer05);

            question2Radiogroup.setVisibility(View.VISIBLE);
            question2Radiogroup.setText(R.string.answer11);
            if (question == 2)
                question2Radiogroup.setText(R.string.answer12);
            if (question == 3)
                question2Radiogroup.setText(R.string.answer13);
            if (question == 4)
                question2Radiogroup.setText(R.string.answer14);
            if (question == 5)
                question2Radiogroup.setText(R.string.answer15);


            question3Radiogroup.setVisibility(View.VISIBLE);
            question3Radiogroup.setText(R.string.answer21);
            if (question == 2)
                question3Radiogroup.setText(R.string.answer22);
            if (question == 3)
                question3Radiogroup.setText(R.string.answer23);
            if (question == 4)
                question3Radiogroup.setText(R.string.answer24);
            if (question == 5)
                question3Radiogroup.setText(R.string.answer25);


            question4Radiogroup.setVisibility(View.VISIBLE);
            question4Radiogroup.setText(R.string.answer31);
            if (question == 2)
                question4Radiogroup.setText(R.string.answer32);
            if (question == 3)
                question4Radiogroup.setText(R.string.answer33);
            if (question == 4)
                question4Radiogroup.setText(R.string.answer34);
            if (question == 5)
                question4Radiogroup.setText(R.string.answer35);


            scoreText.setText(getString(R.string.score) + score + getString(R.string.maxvalue));
            scoreText.setVisibility(View.VISIBLE);
            questionNumber.setVisibility(View.VISIBLE);
            textQuestion.setVisibility(View.VISIBLE);

            if (question == 6) {
                sum();
            }


        }

    }


}
