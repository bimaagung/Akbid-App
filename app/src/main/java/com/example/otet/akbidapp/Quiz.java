package com.example.otet.akbidapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends Activity implements View.OnClickListener {

    Button selesaiquiz, lihathasil, login;
    RadioButton jawabanpilihan;
    RadioButton nomor1,nomor2,nomor3,nomor4,nomor5,nomor6;
    TextView soal,timer,nilai,pilihana,pilihanb,pilihanc,pilihand, test, jawabansoal, jawabananda;
    EditText user;
    ImageView bgquiz;
    ScrollView scrollView2;
    RadioGroup pilihansoal1,pilihansoal2,pilihansoal3,pilihansoal4,pilihansoal5,pilihansoal6;
    RelativeLayout layouttimer,pjawaban,scenehasil;
    String cekhasil=null;

    String [] pertanyaan = {"1. Cara mencegah nyamuk","2.lebih baik mencegah atau megobati",
            "3. Apakah yang menyebabkan seseorang diare", "4. Obat penawar pereda sakit",
            "5.Penyebab Tyfus", "6. bakteri pada diare"};


    String [] jawab_a = {"A.Menbuang sampah sembarangan","A.Mencegah","A.Makan berlebihan","A. Obat Herbal","A.Telat Makan","A. Sanitice"};
    String [] jawab_b = {"B.Menghindari nyamuk","B.Mengobati","B.Malas BAB","B.Daun Jambu","B.Merokok","B.E Coli"};
    String [] jawab_c = {"C.Hidup bersih","C.Semua salah","C.Hidup tidak bersih","C.Anti Biotik","C.Tidur Berlebihan","C.Bertohius"};
    String [] jawab_d = {"D.Melakukan reboisasi","D.Semua Benar","D.Malas Makan","D.Pereda Sakit","D.Kecapaian","D.Tidak di ketahui"};


    String [] jawaban = {"C","A","C","D","A","B"};


    int benar = 0;
    int menit = 1, detik = 59;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        nomor1 = (RadioButton) findViewById(R.id.nomor1);
        nomor1.setOnClickListener(this);
        nomor2= (RadioButton)findViewById(R.id.nomor2);
        nomor2.setOnClickListener(this);
        nomor3 = (RadioButton)findViewById(R.id.nomor3);
        nomor3.setOnClickListener(this);
        nomor4= (RadioButton)findViewById(R.id.nomor4);
        nomor4.setOnClickListener(this);
        nomor5 = (RadioButton)findViewById(R.id.nomor5);
        nomor5.setOnClickListener(this);
        nomor6= (RadioButton)findViewById(R.id.nomor6);
        nomor6.setOnClickListener(this);

        selesaiquiz = (Button)findViewById(R.id.selesaiquiz);
        selesaiquiz.setOnClickListener(this);
        lihathasil = (Button)findViewById(R.id.lihathasil);
        lihathasil.setOnClickListener(this);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        login.setVisibility(View.VISIBLE);

        soal = (TextView) findViewById(R.id.soal);
        soal.setText(pertanyaan[0]);
        soal.setVisibility(View.INVISIBLE);
        jawabansoal = (TextView) findViewById(R.id.jawabansoal);
        jawabansoal.setVisibility(View.INVISIBLE);
        jawabananda = (TextView) findViewById(R.id.jawabananda);
        jawabananda.setVisibility(View.INVISIBLE);

        timer = (TextView) findViewById(R.id.timer);
        nilai = (TextView) findViewById(R.id.nilai);
        pilihana = (TextView) findViewById(R.id.pilihana);
        pilihana.setText(jawab_a[0]);
        pilihanb = (TextView) findViewById(R.id.pilihanb);
        pilihanb.setText(jawab_b[0]);
        pilihanc = (TextView) findViewById(R.id.pilihanc);
        pilihanc.setText(jawab_c[0]);
        pilihand = (TextView) findViewById(R.id.pilihand);
        pilihand.setText(jawab_d[0]);

        user = (EditText) findViewById(R.id.user);
        user.setVisibility(View.VISIBLE);

        bgquiz = (ImageView) findViewById(R.id.bgquiz);
        bgquiz.setVisibility(View.INVISIBLE);

        scrollView2 = (ScrollView) findViewById(R.id.scrollView2);
        scrollView2.setVisibility(View.INVISIBLE);

        test = (TextView) findViewById(R.id.test);
        
        pilihansoal1 = (RadioGroup) findViewById(R.id.pilihansoal1);
        pilihansoal1.setVisibility(View.INVISIBLE);
        pilihansoal2 = (RadioGroup) findViewById(R.id.pilihansoal2);
        pilihansoal2.setVisibility(View.INVISIBLE);
        pilihansoal3 = (RadioGroup) findViewById(R.id.pilihansoal3);
        pilihansoal3.setVisibility(View.INVISIBLE);
        pilihansoal4 = (RadioGroup) findViewById(R.id.pilihansoal4);
        pilihansoal4.setVisibility(View.INVISIBLE);
        pilihansoal5 = (RadioGroup) findViewById(R.id.pilihansoal5);
        pilihansoal5.setVisibility(View.INVISIBLE);
        pilihansoal6 = (RadioGroup) findViewById(R.id.pilihansoal6);
        pilihansoal6.setVisibility(View.INVISIBLE);


        layouttimer = (RelativeLayout) findViewById(R.id.layouttimer);
        layouttimer.setVisibility(View.INVISIBLE);
        pjawaban = (RelativeLayout) findViewById(R.id.pjawaban);
        pjawaban.setVisibility(View.INVISIBLE);
        scenehasil = (RelativeLayout) findViewById(R.id.scenehasil);
        scenehasil.setVisibility(View.INVISIBLE);

        new CountDownTimer(100000000, 1000){

            public void onTick(long millisUntilFinished){
                detik -= 1;

                timer.setText((menit+" : "+detik));
                if(menit == 0 && detik == 0){
                    nilai.setText("Skor Anda "+ String.valueOf(benar));
                    nilai.setVisibility(View.VISIBLE);
                    lihathasil.setVisibility(View.VISIBLE);
                    selesaiquiz.setVisibility(View.VISIBLE);

                    user.setVisibility(View.INVISIBLE);
                    login.setVisibility(View.INVISIBLE);
                    bgquiz.setVisibility(View.INVISIBLE);
                    scrollView2.setVisibility(View.INVISIBLE);
                    pilihansoal1.setVisibility(View.INVISIBLE);
                    soal.setVisibility(View.INVISIBLE);
                    layouttimer.setVisibility(View.INVISIBLE);
                    pjawaban.setVisibility(View.INVISIBLE);
                    pilihansoal1.setVisibility(View.INVISIBLE);
                    pilihansoal2.setVisibility(View.INVISIBLE);
                    pilihansoal3.setVisibility(View.INVISIBLE);
                    pilihansoal4.setVisibility(View.INVISIBLE);
                    pilihansoal5.setVisibility(View.INVISIBLE);
                    pilihansoal6.setVisibility(View.INVISIBLE);

                }

                if(detik == -1){
                    menit-=1;
                    detik+=60;
                    timer.setText((menit+" : "+detik));
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();


    }

    @Override
    public void onClick(View v) {
        
        String hasiljawab1=null, hasiljawab2=null, hasiljawab3=null, hasiljawab4=null, hasiljawab5=null, hasiljawab6=null;
        int selected1 = pilihansoal1.getCheckedRadioButtonId();
        int selected2 = pilihansoal2.getCheckedRadioButtonId();
        int selected3 = pilihansoal3.getCheckedRadioButtonId();
        int selected4 = pilihansoal4.getCheckedRadioButtonId();
        int selected5 = pilihansoal5.getCheckedRadioButtonId();
        int selected6 = pilihansoal6.getCheckedRadioButtonId();


        if(v == nomor1) {
            soal.setText(pertanyaan[0]);
            pilihana.setText(jawab_a[0]);
            pilihanb.setText(jawab_b[0]);
            pilihanc.setText(jawab_c[0]);
            pilihand.setText(jawab_d[0]);
            if (cekhasil == "Y") {
                tampilkanPilihan();
                jawabansoal.setText(jawaban[0]);
                jawabananda.setText(hasiljawab1);
            }else{
                test.setVisibility(View.VISIBLE);
                pilihansoal1.setVisibility(View.VISIBLE);
                pilihansoal2.setVisibility(View.INVISIBLE);
                pilihansoal3.setVisibility(View.INVISIBLE);
                pilihansoal4.setVisibility(View.INVISIBLE);
                pilihansoal5.setVisibility(View.INVISIBLE);
                pilihansoal6.setVisibility(View.INVISIBLE);

                jawabanpilihan = (RadioButton) findViewById(selected1);
                if (selected1 != -1) {
                    hasiljawab1 = jawabanpilihan.getText().toString();
                    if (jawaban[0].equals(hasiljawab1)) {
                        benar++;
                    }
                }
                test.setText(hasiljawab1);
            }
        }

        if(v == nomor2) {
            soal.setText(pertanyaan[1]);
            pilihana.setText(jawab_a[1]);
            pilihanb.setText(jawab_b[1]);
            pilihanc.setText(jawab_c[1]);
            pilihand.setText(jawab_d[1]);
            if (cekhasil == "Y") {
                tampilkanPilihan();
                jawabansoal.setText(jawaban[1]);
                jawabananda.setText(hasiljawab2);
            }else{
                test.setVisibility(View.VISIBLE);
                pilihansoal1.setVisibility(View.INVISIBLE);
                pilihansoal2.setVisibility(View.VISIBLE);
                pilihansoal3.setVisibility(View.INVISIBLE);
                pilihansoal4.setVisibility(View.INVISIBLE);
                pilihansoal5.setVisibility(View.INVISIBLE);
                pilihansoal6.setVisibility(View.INVISIBLE);

                jawabanpilihan = (RadioButton) findViewById(selected2);
                if (selected2 != -1) {
                    hasiljawab2 = jawabanpilihan.getText().toString();
                    if (jawaban[1].equals(hasiljawab2)) {
                        benar++;
                    }
                }
                test.setText(hasiljawab2);
            }
        }

        if(v == nomor3) {
            soal.setText(pertanyaan[2]);
            pilihana.setText(jawab_a[2]);
            pilihanb.setText(jawab_b[2]);
            pilihanc.setText(jawab_c[2]);
            pilihand.setText(jawab_d[2]);
            test.setVisibility(View.VISIBLE);
            pilihansoal1.setVisibility(View.INVISIBLE);
            pilihansoal2.setVisibility(View.INVISIBLE);
            pilihansoal3.setVisibility(View.VISIBLE);
            pilihansoal4.setVisibility(View.INVISIBLE);
            pilihansoal5.setVisibility(View.INVISIBLE);
            pilihansoal6.setVisibility(View.INVISIBLE);

            jawabanpilihan = (RadioButton)findViewById(selected3);
            if(selected3 != -1) {
                hasiljawab3 = jawabanpilihan.getText().toString();
                if(jawaban[2].equals(hasiljawab3)){
                    benar++;
                }
            }
            test.setText(hasiljawab3);
        }

        if(v == nomor4) {
            soal.setText(pertanyaan[3]);
            pilihana.setText(jawab_a[3]);
            pilihanb.setText(jawab_b[3]);
            pilihanc.setText(jawab_c[3]);
            pilihand.setText(jawab_d[3]);
            test.setVisibility(View.VISIBLE);
            pilihansoal1.setVisibility(View.INVISIBLE);
            pilihansoal2.setVisibility(View.INVISIBLE);
            pilihansoal3.setVisibility(View.INVISIBLE);
            pilihansoal4.setVisibility(View.VISIBLE);
            pilihansoal5.setVisibility(View.INVISIBLE);
            pilihansoal6.setVisibility(View.INVISIBLE);

            jawabanpilihan = (RadioButton)findViewById(selected4);
            if(selected4 != -1) {
                hasiljawab4 = jawabanpilihan.getText().toString();
                if(jawaban[3].equals(hasiljawab4)){
                    benar++;
                }
            }
            test.setText(hasiljawab4);
        }

        if(v == nomor5) {
            soal.setText(pertanyaan[4]);
            pilihana.setText(jawab_a[4]);
            pilihanb.setText(jawab_b[4]);
            pilihanc.setText(jawab_c[4]);
            pilihand.setText(jawab_d[4]);
            test.setVisibility(View.VISIBLE);
            pilihansoal1.setVisibility(View.INVISIBLE);
            pilihansoal2.setVisibility(View.INVISIBLE);
            pilihansoal3.setVisibility(View.INVISIBLE);
            pilihansoal4.setVisibility(View.INVISIBLE);
            pilihansoal5.setVisibility(View.VISIBLE);
            pilihansoal6.setVisibility(View.INVISIBLE);

            jawabanpilihan = (RadioButton)findViewById(selected5);
            if(selected5 != -1) {
                hasiljawab5 = jawabanpilihan.getText().toString();
                if(jawaban[4].equals(hasiljawab5)){
                    benar++;
                }
            }
            test.setText(hasiljawab5);
        }

        if(v == nomor6) {
            soal.setText(pertanyaan[5]);
            pilihana.setText(jawab_a[5]);
            pilihanb.setText(jawab_b[5]);
            pilihanc.setText(jawab_c[5]);
            pilihand.setText(jawab_d[5]);
            test.setVisibility(View.VISIBLE);
            pilihansoal1.setVisibility(View.INVISIBLE);
            pilihansoal2.setVisibility(View.INVISIBLE);
            pilihansoal3.setVisibility(View.INVISIBLE);
            pilihansoal4.setVisibility(View.INVISIBLE);
            pilihansoal5.setVisibility(View.INVISIBLE);
            pilihansoal6.setVisibility(View.VISIBLE);

            jawabanpilihan = (RadioButton)findViewById(selected6);
            if(selected6 != -1) {
                hasiljawab6 = jawabanpilihan.getText().toString();
                if(jawaban[5].equals(hasiljawab6)){
                    benar++;
                }
            }
            test.setText(hasiljawab6);
        }

        if(v == login){
            user.setVisibility(View.INVISIBLE);
            login.setVisibility(View.INVISIBLE);
            bgquiz.setVisibility(View.VISIBLE);
            scrollView2.setVisibility(View.VISIBLE);
            pilihansoal1.setVisibility(View.VISIBLE);
            soal.setVisibility(View.VISIBLE);
            layouttimer.setVisibility(View.VISIBLE);
            pjawaban.setVisibility(View.VISIBLE);
        }

        if(v == selesaiquiz){
            finish();
        }

        if(v == lihathasil){
            cekhasil = "Y";
            tampilkanPilihan();
            bgquiz.setVisibility(View.VISIBLE);
            scrollView2.setVisibility(View.VISIBLE);
            pilihansoal1.setVisibility(View.VISIBLE);
            soal.setVisibility(View.VISIBLE);
            pjawaban.setVisibility(View.VISIBLE);
            jawabansoal.setVisibility(View.VISIBLE);
            jawabananda.setVisibility(View.VISIBLE);

            nilai.setVisibility(View.INVISIBLE);
            lihathasil.setVisibility(View.INVISIBLE);
            selesaiquiz.setVisibility(View.INVISIBLE);


            soal.setText(pertanyaan[0]);
            pilihana.setText(jawab_a[0]);
            pilihanb.setText(jawab_b[0]);
            pilihanc.setText(jawab_c[0]);
            pilihand.setText(jawab_d[0]);
            jawabansoal.setText(jawaban[0]);
            jawabananda.setText(hasiljawab1);
        }
    }

    private void tampilkanPilihan(){

        scenehasil.setVisibility(View.VISIBLE);

        pilihansoal1.setVisibility(View.INVISIBLE);
        pilihansoal2.setVisibility(View.INVISIBLE);
        pilihansoal3.setVisibility(View.INVISIBLE);
        pilihansoal4.setVisibility(View.INVISIBLE);
        pilihansoal5.setVisibility(View.INVISIBLE);
        pilihansoal6.setVisibility(View.INVISIBLE);
    }

}
