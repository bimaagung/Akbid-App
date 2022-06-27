package com.example.otet.akbidapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Thread(){
            @Override
            public void run(){
                Intent MenuUtama = new Intent(MainActivity.this, MenuUtama.class);
                MainActivity.this.startActivity(MenuUtama);
                MainActivity.this.finish();
                overridePendingTransition(R.layout.fadeout);
            }

            
        }, 3000);
    }

    private void overridePendingTransition(int fadeout) {
    }
