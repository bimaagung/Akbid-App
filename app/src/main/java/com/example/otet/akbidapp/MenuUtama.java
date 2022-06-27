package com.example.otet.akbidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuUtama extends Activity implements View.OnClickListener {

    Button btnmateri, btnquiz, btnkeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        btnmateri = (Button)findViewById(R.id.btnmateri);
        btnmateri.setOnClickListener(this);

        btnquiz = (Button)findViewById(R.id.btnquiz);
        btnquiz.setOnClickListener(this);

        btnkeluar = (Button)findViewById(R.id.btnkeluar);
        btnkeluar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if( v == btnmateri) {
            Intent Materi = new Intent(MenuUtama.this, Materi.class);
            startActivity(Materi);
        }

        if( v == btnquiz) {
            Intent Quiz = new Intent(MenuUtama.this, Quiz.class);
            startActivity(Quiz);
        }

        if( v == btnkeluar) {
            finish();
        }
    }
}
