package com.swipemarket.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Kosong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kosong);
        Intent i = new Intent(Kosong.this, MainActivity.class);
        startActivity(i);
        this.finish();
    }
}
