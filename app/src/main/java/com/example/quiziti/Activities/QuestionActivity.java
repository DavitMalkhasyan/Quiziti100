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
            
        } else if (setName.equals("SET-3")) {
            setThree();

        } else if (setName.equals("SET-4")) {
            setFour();

        } else if (setName.equals ("SET-5")) {
            setFive();

        } else if (setName.equals("SET-6")) {
            setSix();

        } else if (setName.equals("SET-7")) {
            setSeven();

        } else if (setName.equals("SET-8")) {
            setEight();

        } else if (setName.equals("SET-9")) {
            setNine();

        } else if (setName.equals("SET-10")) {
            setTen();

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

    private void setTen() {

        list.add(new QuestionModel("4.7 < ? < 4.8?"
                , "4.82", "4.73", "4.69", "4.98", "4.73"));

        list.add(new QuestionModel("Which number is divided by 2, 3 and 7 without any remainder?"
                , "36", "18", "21", "42", "42"));

        list.add(new QuestionModel("What is the average of the following numbers 5 , 15 , 40 ?"
                , "15", "20", "25", "30", "20"));

        list.add(new QuestionModel("Which of the following mathematical statements is true?"
                , "27 ÷ 3 = 9", "27 ÷ 7 = 3", "24 ÷ 4 = 5", "27 ÷ 9 = 4", "27 ÷ 3 = 9"));

        list.add(new QuestionModel("0.016 x 100 = ?"
                , "160", "16", "1.6", "0.16", "1.6"));

    }

    private void setNine() {

        list.add(new QuestionModel("If ‘+’ means ‘×’, ‘-‘ means ‘+’, ‘×’ means ‘÷’ and ‘÷’ means ‘-‘ then find the value of:  6 – 9 + 8 × 3 ÷ 20 = …… ."
                , "6", "10", "-2", "12", "10"));

        list.add(new QuestionModel(". A car covers a distance of 200km in 2 hours 40 minutes, whereas a jeep covers the same distance in 2 hours. What is the ratio of their speed?"
                , "3:4", "4:3", "4:5", "5:4", "3:4"));

        list.add(new QuestionModel("10001 – 101 = ?"
                , "1001", "990", "9900", "9990", "9900"));

        list.add(new QuestionModel("The sum of squares of two numbers is 80 and the square of difference between the two numbers is 36. Find the product of two numbers."
                , "26", "33", "22", "11", "22"));

        list.add(new QuestionModel(" The value of 1.07 × 65 + 1.07 × 26 + 1.07 × 9 is;"
                , "10.73", "10.7", "10.70", "107", "107"));

    }

    private void setEight() {

        list.add(new QuestionModel("5.2 * 3.7 = ?"
                , "20.35", "19.24", "15.14", "18.63", "19.24"));

        list.add(new QuestionModel("What is the average of the following numbers 100, 180, 440 , 80?"
                , "180", "100", "200", "120", "200"));

        list.add(new QuestionModel("How much is 55% of 400 = ?"
                , "220", "180", "195", "210", "220"));

        list.add(new QuestionModel("If you had 185 bottles and you lost 67, how many bottles left?"
                , "112", "118", "121", "98", "118"));

        list.add(new QuestionModel("Which number is divided by 2 and 7 with a remainder of 1?"
                , "10", "17", "21", "15", "15"));

    }

    private void setSeven() {

        list.add(new QuestionModel("2,150 - 100 = ? + 950"
                , "900", "1100", "1000", "1050", "1100"));

        list.add(new QuestionModel("Complete the series: 1 , 4 , 16 , ? , 256"
                , "16", "36", "64", "84", "64"));

        list.add(new QuestionModel("Find x=?, when: 7x + 10 < 50"
                , "10", "6", "7", "5", "5"));

        list.add(new QuestionModel("How much is 32% of 500 = ?"
                , "160", "362", "154", "320", "160"));

        list.add(new QuestionModel("What is the sum of angles in a triangle?"
                , "120", "90", "360", "180", "180"));
    }

    private void setSix() {

        list.add(new QuestionModel("What is the value of the expression ½ (q-7)  if q=13?"
                , "6", "7", "3", "4", "3"));

        list.add(new QuestionModel("Solve 2(z + 3) = 10"
                , "5", "10", "3,5", "2", "2"));

        list.add(new QuestionModel("What is the value of 5 - ½ p when p = 12"
                , "-1", "0", "-2", "3", "-1"));

        list.add(new QuestionModel("2 * 1/14 = ?"
                , "1/28", "2/7", "1/14", "1/7", "1/7"));

        list.add(new QuestionModel("4 * 2 - 10 + 3 * 3 = ?"
                , "10", "7", "8", "11", "7"));

    }

    private void setFive() {

        list.add(new QuestionModel("Which is the correct expression for 'multiply b by 3 and then subtract 5'?"
                , "5 - 3b", "3b - 5", "5b - 3", "3(b - 5)", "3b - 5"));

        list.add(new QuestionModel("What is the value of 3(d - 5) when d = 2?"
                , "7", "-9", "-6", "9", "-9"));

        list.add(new QuestionModel("Find the value of n if 10 - 2n = 0"
                , "n = 10", "n = 8", "n = 5", "n = 0", "n = 5"));

        list.add(new QuestionModel("What is the correct expression for 'add 5 to f and double the result'."
                , "2(f + 5)", "f + 5", "f + 10", "2f + 5", "2(f + 5)"));

        list.add(new QuestionModel("What is the value of t if 3t - 1 = 20."
                , "7", " 8", "5", "6", "7"));

    }

    private void setFour() {

        list.add(new QuestionModel("Which of these numbers is two thousand and sixty?"
                , "2060", "2016", "2600", "2006", "2060"));

        list.add(new QuestionModel("What is the value of the digit 7 in the number 2876?"
                , "7", "70", "700", "7000", "70"));

        list.add(new QuestionModel("Which of these is number six thousand seventeen?"
                , "6070", "6170", "617", "6017", "6017"));

        list.add(new QuestionModel("What is 9 thousands + 5 hundreds + 6 tens?"
                , "9560", "9506", "9056", "956", "9560"));

        list.add(new QuestionModel("What is the missing number: 4000 + ____ + 53 = 4953?"
                , "875", " 800", "915", "900", "900"));
        



    }

    private void setThree() {
        list.add(new QuestionModel("Without using a calculator, find the value of 3/8 * 4/5"
                , "7/13", "15/32", "3/5", "3/10", "3/10"));

        list.add(new QuestionModel("Choose the expression that does not simplify to p."
                , "5p − 4p", "p ÷ p + p − p", "p − p + q + p − q", "pq + 2p − p − pq", "p ÷ p + p − p"));

        list.add(new QuestionModel("Which of the following is the expression for the nth term of the sequence 3, 5, 7, 9, ... ?"
                , "2n", "2n + 1", "3n + 2", "n + 2", "2n + 1"));

        list.add(new QuestionModel("2/7 of the sweets in a jar are red. What is the ratio of sweets that are red to sweets that are not red?"
                , "3/7", "5/7", "5/2", "2/5", "2/5"));

        list.add(new QuestionModel("The variables v and d are in inverse proportion. Which of the following equations relates v and d?"
                , "v = k/d", " v = kd", "v = d/k", "v = ‑kd", "v = k/d"));
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

 //               dialog.show();

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