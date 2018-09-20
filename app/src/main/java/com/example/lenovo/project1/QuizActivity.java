package com.example.lenovo.project1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
 RadioButton r1,r2,r3;
    int num=0;
    Questions q=new Questions();
    TextView t1,t2;
    int score=0;
    String answer;
    RadioGroup radioGroup;
    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        r1=(RadioButton)findViewById(R.id.rb1);
        r2=(RadioButton)findViewById(R.id.rb2);
        r3=(RadioButton)findViewById(R.id.rb3);
        t1=(TextView)findViewById(R.id.tv4);
        t2=(TextView)findViewById(R.id.tv1);
        radioGroup=(RadioGroup)findViewById(R.id.rg1);
        check = (Button)findViewById(R.id.bt1);

        nextQuestion();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rbid=radioGroup.getCheckedRadioButtonId();
               View radiobutton=radioGroup.findViewById(rbid);
                int index=radioGroup.indexOfChild(radiobutton);
                RadioButton r = (RadioButton)  radioGroup.getChildAt(index);
                String selectedtext = r.getText().toString();
                if(selectedtext==answer)
                {
                    Toast.makeText(QuizActivity.this,"correct answer",Toast.LENGTH_LONG).show();
                    score++;
                    t2.setText("Score:"+score);
                    nextQuestion();

                }
                else{
                    gameOver();
                    score=0;
                }
            }
        });


    }
    public void nextQuestion()
    {
        if(num<=4)
        {
            t1.setText(q.getquestion(num));
            r1.setText(q.getchoice1(num));
            r2.setText(q.getchoice2(num));
            r3.setText(q.getchoice3(num));
            answer=q.correctans(num);
            num++;
        }
    }
    public void gameOver()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(QuizActivity.this);
        builder.setMessage("Game Over").setCancelable(false).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(QuizActivity.this,SecondActivity.class));
            }
        }).setNegativeButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(QuizActivity.this,MainActivity.class));
            }
        });
        builder.show();
    }
}
