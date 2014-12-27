package com.arcileslab.arciles.duvarkagidiustasi;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class StartPage extends ActionBarActivity {

    Button araba, ucBoyut, soyut, hayvanlar, sehirler, fantazi, cicek, oyunlar, macro, filmler, muzik, doga, uzay, kaplama, diziler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        araba = (Button) findViewById(R.id.btnArabalar);
        ucBoyut = (Button) findViewById(R.id.btn3boyut);
        soyut = (Button) findViewById(R.id.btnSoyut);
        hayvanlar = (Button) findViewById(R.id.btnHayvanlar);
        sehirler = (Button) findViewById(R.id.btnSehirler);
        fantazi = (Button) findViewById(R.id.btnFantazi);
        cicek = (Button) findViewById(R.id.btnCicekler);
        oyunlar = (Button) findViewById(R.id.btnOyunlar);
        macro = (Button) findViewById(R.id.btnMacro);
        filmler = (Button) findViewById(R.id.btnFilmler);
        muzik = (Button) findViewById(R.id.btnMuzik);
        doga = (Button) findViewById(R.id.btnDoga);
        uzay = (Button) findViewById(R.id.btnUzay);
        kaplama = (Button) findViewById(R.id.btnKaplama);
        diziler = (Button) findViewById(R.id.btnDiziler);

        View.OnClickListener myListener = new View.OnClickListener() {
            Intent in;
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.btnArabalar:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","cars");
                        startActivity(in);
                        break;
                    case R.id.btn3boyut:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","uc_boyut");
                        startActivity(in);
                        break;
                    case R.id.btnSoyut:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","abstract");
                        startActivity(in);
                        break;
                    case R.id.btnHayvanlar:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","animals");
                        startActivity(in);
                        break;
                    case R.id.btnSehirler:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","cities");
                        startActivity(in);
                        break;
                    case R.id.btnFantazi:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","fantasy");
                        startActivity(in);
                        break;
                    case R.id.btnCicekler:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","flowers");
                        startActivity(in);
                        break;
                    case R.id.btnOyunlar:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","games");
                        startActivity(in);
                        break;
                    case R.id.btnMacro:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","macros");
                        startActivity(in);
                        break;
                    case R.id.btnFilmler:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","movies");
                        startActivity(in);
                        break;
                    case R.id.btnMuzik:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","music");
                        startActivity(in);
                        break;
                    case R.id.btnDoga:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","nature");
                        startActivity(in);
                        break;
                    case R.id.btnUzay:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","space");
                        startActivity(in);
                        break;
                    case R.id.btnKaplama:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","textures");
                        startActivity(in);
                        break;
                    case R.id.btnDiziler:
                        in = new Intent(getApplicationContext(),DisplayPage.class);
                        in.putExtra("name","tv_series");
                        startActivity(in);
                        break;
                }
            }
        };


        araba.setOnClickListener(myListener);
        ucBoyut.setOnClickListener(myListener);
        soyut.setOnClickListener(myListener);
        hayvanlar.setOnClickListener(myListener);
        sehirler.setOnClickListener(myListener);
        fantazi.setOnClickListener(myListener);
        cicek.setOnClickListener(myListener);
        oyunlar.setOnClickListener(myListener);
        macro.setOnClickListener(myListener);
        filmler.setOnClickListener(myListener);
        muzik.setOnClickListener(myListener);
        doga.setOnClickListener(myListener);
        uzay.setOnClickListener(myListener);
        kaplama.setOnClickListener(myListener);
        diziler.setOnClickListener(myListener);


    }

}
