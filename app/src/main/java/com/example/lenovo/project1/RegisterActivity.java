package com.example.lenovo.project1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
   EditText  name,email,password;
    Button register;
    TextView login;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        openHelper=new DatabaseHelper(this);

        name=(EditText)findViewById(R.id.et1);
        email=(EditText)findViewById(R.id.et2);
        password=(EditText)findViewById(R.id.et3);
        register=(Button)findViewById(R.id.bt1);
        login=(TextView)findViewById(R.id.tv1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dbh=openHelper.getWritableDatabase();
                String username=name.getText().toString();
                String usermail=email.getText().toString();
                String userpassword=password.getText().toString();
                insertdata(username,usermail,userpassword);
                Toast.makeText(RegisterActivity.this,"Registration successful",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void insertdata(String uname,String umail,String upassword)
    {
        ContentValues cv=new ContentValues();
        cv.put(DatabaseHelper.COL_2,uname);
        cv.put(DatabaseHelper.COL_3,umail);
        cv.put(DatabaseHelper.COL_4,upassword);
        long i=dbh.insert(DatabaseHelper.TABLE_NAME,null,cv);

  }
}
