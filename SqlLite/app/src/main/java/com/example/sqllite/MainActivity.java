package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper helper = new DBHelper(this);
        helper.addContactm(new Contact("ahmed","010"));
        helper.addContactm(new Contact("mona" ,"011"));
    }
}
