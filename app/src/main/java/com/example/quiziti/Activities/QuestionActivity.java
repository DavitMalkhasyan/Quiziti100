package com.example.quiziti.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.quiziti.Models.QuestionModel;
import com.example.quiziti.R;
import com.example.quiziti.databinding.ActivityQuestionBinding;

import java.util.ArrayList;
import java.util.Objects;

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

        Objects.requireNonNull(getSupportActionBar()).hide();

        resetTimer();
        timer.start();


        String setName = getIntent().getStringExtra("set");

        if (setName.equals("SET-1")){

             setOne();
        } else if (setName.equals("SET-2")) {

            setTwo();
            
        }

        for (int i = 0; i<4; i++){

            binding.optionContainer.getChildAt(i).setOnClickListener(view -> checkAnswer((Button) view));
        }

        playAnimation(binding.question, 0, list.get(position).getQuestion());

        binding.btnNext.setOnClickListener(view -> {

            if (timer != null){
                timer.cancel();
            }

            assert timer != null;
            timer.start();
            binding.btnNext.setEnabled(false);
            binding.btnNext.setAlpha((float) 0.3);
            enableOption();
            position ++;
            if (position==list.size()){


                    Intent intent = new Intent(QuestionActivity.this,ScoreActivity.class);
                    intent.putExtra("score",score);
                    intent.putExtra("total",list.size());
                    startActivity(intent);
                    finish();
                    return;
                }

            count = 0;
            playAnimation(binding.question,0,list.get(position).getQuestion());

        });



    }

    private void resetTimer() {

        timer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                binding.timer.setText(String.valueOf(l/1000));

            }

            @Override
            public void onFinish() {

                Dialog dialog = new Dialog(QuestionActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.timeout_dialog);
                dialog.findViewById(R.id.tryAgain).setOnClickListener(view -> {

                    Intent intent = new Intent(QuestionActivity.this, SetsActivity.class);
                    startActivity(intent);
                    finish();

                });

                dialog.show();

            }
        };

    }

    private void playAnimation(View view, int value, String data) {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {

                        if (value == 0 && count <4){

                            String option = "";

                            if (count == 0){

                                option = list.get(position).getOptionA();
                            } else if (count == 1) {

                                option = list.get(position).getOptionB();
                            }
                            else if (count == 2) {

                                option = list.get(position).getOptionC();
                            }
                            else if (count == 3) {

                                option = list.get(position).getOptionD();
                            }
                            playAnimation(binding.optionContainer.getChildAt(count),0,option);
                            count ++;
                        }

                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {

                        if (value == 0){


                            try {
                                ((TextView)view).setText(data);
                                
                            } catch (Exception e) {
                                binding.totalQuestions.setText(position+1+"/"+list.size());
                                ((Button)view).setText(data);
                            }

                            view.setTag(data);
                            playAnimation(view,1,data);


                        }

                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                });

    }

    private void enableOption() {

        for(int  i = 0; i<4; i++){

            binding.optionContainer.getChildAt(i).setEnabled(true);

            binding.optionContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opt);
        }

    }

    private void checkAnswer(Button selectedOption) {

        if (timer != null){

            timer.cancel();

        }

        binding.btnNext.setEnabled(true);
        binding.btnNext.setAlpha(1);

        if (selectedOption.getText().toString().equals(list.get(position).getCorrectAnswer())){


            score ++;
            selectedOption.setBackgroundResource(R.drawable.right_answ);
        }
        else {

            selectedOption.setBackgroundResource(R.drawable.wrong_answ);

            Button correctOption = binding.optionContainer.findViewWithTag(list.get(position).getCorrectAnswer());
            correctOption.setBackgroundResource(R.drawable.right_answ);


        }

    }

    private void setTwo() {

        list.add(new QuestionModel("Solve : 200 – (96 ÷ 4)"
                , "105", "176", "156", "139", "176"));

        list.add(new QuestionModel("Simplify : 3 + 6 x (5 + 4) ÷ 3 - 7"
                , "11", "12", "14", "16", "14"));

        list.add(new QuestionModel("Complete the sequence 13, 16, ……, 22."
                , "18", "19", "17", "20", "19"));

        list.add(new QuestionModel("Which is the largest number in 15/17, 15/18, 15/19, 15/21?"
                , "15/17", "15/18", "15/19", "15/21", "15/17"));

        list.add(new QuestionModel("What are the integer solutions of the inequality |x| < 2?"
                , "1, 0, and –1", " 2, 1, 0, –1, and –2", "2", "2 and -2", "1, 0, and –1"));
    }


    private void setOne() {

        list.add(new QuestionModel("If a person has 440 pens and 560 pencils, how many more pencils does he have?"
                ,"110","120","130","140", "120"));

        list.add(new QuestionModel("Complete the series: 1000, 500, 250, ?"
                ,"120","200","125","135", "125"));

        list.add(new QuestionModel("What is the value of x if x2 = 169?"
                ,"13","12","19","16", "13"));

        list.add(new QuestionModel("A car can cover a distance of 522 km on 36 liters of petrol. How far can it travel on 14 liters of petrol?"
                ,"213","223","203","302", "203"));
        list.add(new QuestionModel("78 ÷ 5 ÷ 0.5 = ?"
                , "15.6", "31.2", "7.8", "20.4", "31.2"));

    }
}