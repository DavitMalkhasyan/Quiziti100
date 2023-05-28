package com.example.quiziti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.example.quiziti.Models.QuestionModel;
import com.example.quiziti.R;
import com.example.quiziti.databinding.ActivityQuestionBinding;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    ArrayList<QuestionModel> list = new ArrayList<>();
    private int count = 0;
    private int position = 0;
    private int score = 0;
    CountDownTimer timer;

    ActivityQuestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        String setName = getIntent().getStringExtra("set");

        if (setName.equals("SET-1")){

             setOne();
        } else if (setName.equals("SET-2")) {

            setTwo();
            
        }
        int i;
        for (i = 0;i<4; i++){

            binding.optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    
                    checkAnswer((Button) view);

                }
            });
        }

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.btnNext.setEnabled(false);
                binding.btnNext.setAlpha((float) 0.3);
                enableOption(true);

            }
        });



    }

    private void enableOption(boolean b) {



    }

    private void checkAnswer(Button selectedOption) {

        binding.btnNext.setEnabled(true);
        binding.btnNext.setAlpha(1);

        if (selectedOption.getText().toString().equals(list.get(position).getCorrectAnswer())){


            score ++;
            selectedOption.setBackgroundResource(R.drawable.right_answ);
        }
        else {

            selectedOption.setBackgroundResource(R.drawable.wrong_answ);

            Button correctOption = (Button) binding.optionContainer.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundResource(R.drawable.right_answ);


        }

    }

    private void setTwo() {

        list.add(new QuestionModel("Complete the series: 1000, 500, 250, ?"
                ,"120","200","125","135", "125"));

        list.add(new QuestionModel("If a person has 440 pens and 560 pencils, how many more pencils does he have?"
                ,"110","120","130","140", "120"));

        list.add(new QuestionModel("Complete the series: 1000, 500, 250, ?"
                ,"120","200","125","135", "125"));

        list.add(new QuestionModel("If a person has 440 pens and 560 pencils, how many more pencils does he have?"
                ,"110","120","130","140", "120"));

        list.add(new QuestionModel("Complete the series: 1000, 500, 250, ?"
                ,"120","200","125","135", "125"));

    }

    private void setOne() {

        list.add(new QuestionModel("If a person has 440 pens and 560 pencils, how many more pencils does he have?"
                ,"110","120","130","140", "120"));

        list.add(new QuestionModel("Complete the series: 1000, 500, 250, ?"
                ,"120","200","125","135", "125"));

        list.add(new QuestionModel("If a person has 440 pens and 560 pencils, how many more pencils does he have?"
                ,"110","120","130","140", "120"));

        list.add(new QuestionModel("Complete the series: 1000, 500, 250, ?"
                ,"120","200","125","135", "125"));

    }
}