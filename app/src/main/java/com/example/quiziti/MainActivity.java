package com.example.quiziti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quiziti.Activities.SetsActivity;

public class MainActivity extends AppCompatActivity {

    CardView math, history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        math = findViewById(R.id.math);
        history = findViewById(R.id.history);

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                startActivity(intent);

            }
        });

    }
}