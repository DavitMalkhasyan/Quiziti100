package com.example.quiziti.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quiziti.R;
import com.example.quiziti.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportActionBar().hide();


        int totalScore = getIntent().getIntExtra("total",0);
        int correctAnsw = getIntent().getIntExtra("score", 0);

        int wrong = totalScore - correctAnsw;

        binding.totalQuestions.setText(String.valueOf(totalScore));
        binding.wrongAnsw.setText(String.valueOf(correctAnsw));
        binding.wrongAnsw.setText(String.valueOf(wrong));

        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ScoreActivity.this,SetsActivity.class);
                startActivity(intent);
                finish();

            }
        });



    }
}