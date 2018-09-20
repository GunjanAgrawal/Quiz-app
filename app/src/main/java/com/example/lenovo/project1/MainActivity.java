package com.example.lenovo.project1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    Button login;
    TextView register;
   SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    public final static String a="com.example.lenovo.project1.b";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();

        name = (EditText) findViewById(R.id.et1);
        password = (EditText) findViewById(R.id.et2);
        login = (Button) findViewById(R.id.bt1);
        register = (TextView) findViewById(R.id.tv1);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String email=name.getText().toString();
                String pass=password.getText().toString();
                Cursor cursor=db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_3 + "=? AND " + DatabaseHelper.COL_4 + "=?" ,new String[]{email,pass});

                if(cursor!=null){
                    if(cursor.getCount()>0)
                    {
                        cursor.moveToNext();
                        Cursor c = db.rawQuery("SELECT " + DatabaseHelper.COL_2 + " FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_3 + "=?", new String[] {email });
                            cursor.moveToFirst();
                            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2));
                        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra(a,name);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Login unsuccessful",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    }

}
