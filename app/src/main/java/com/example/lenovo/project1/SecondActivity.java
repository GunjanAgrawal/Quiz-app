package com.example.lenovo.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public final static String a="com.example.lenovo.project1.b";
    Button start;
    TextView uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        uname=(TextView)findViewById(R.id.tv1);
        Intent intent=getIntent();
        String name=intent.getStringExtra(a);
        String n=name;

        uname.setText(n +" your high score is : 0");

        start =(Button)findViewById(R.id.bt1);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this,QuizActivity.class));
            }
        });
    }
}
