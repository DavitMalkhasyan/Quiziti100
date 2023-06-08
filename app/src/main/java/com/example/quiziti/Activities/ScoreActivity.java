package com.example.quiziti.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiziti.databinding.ActivityScoreBinding;

import java.util.Objects;

public class ScoreActivity extends AppCompatActivity {

    ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Objects.requireNonNull(getSupportActionBar()).hide();


        int totalScore = getIntent().getIntExtra("total",0);
        int correctAnsw = getIntent().getIntExtra("score", 0);

        int wrong = totalScore - correctAnsw;

        binding.totalQuestions.setText(String.valueOf(totalScore));
        binding.wrongAnsw.setText(String.valueOf(correctAnsw));
        binding.wrongAnsw.setText(String.valueOf(wrong));

        binding.btnRetry.setOnClickListener(view -> {

            Intent intent = new Intent(ScoreActivity.this,SetsActivity.class);
            startActivity(intent);
            finish();

        });



    }
}