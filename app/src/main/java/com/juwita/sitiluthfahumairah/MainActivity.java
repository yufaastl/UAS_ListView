package com.juwita.sitiluthfahumairah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnhorror, btnromance, btncomedy;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnhorror = findViewById(R.id.btn_buka_horror);
        btnromance = findViewById(R.id.btn_buka_romance);
        btncomedy = findViewById(R.id.btn_buka_comedy);

        btnhorror.setOnClickListener(view -> bukaGaleri("Horror"));
        btnromance.setOnClickListener(view -> bukaGaleri("Romance"));
        btncomedy.setOnClickListener(view -> bukaGaleri("Comedy"));
    }

    private void bukaGaleri(String jenisFilm) {
        Log.d("MAIN","Buka activity horror");
        Intent intent = new Intent(this, DaftarActivityFilm.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisFilm);
        startActivity(intent);
    }
    public void Pindahbiodata(View view) {
        Intent intent = new Intent(MainActivity.this, Profile.class);
        startActivity(intent);
    }
}