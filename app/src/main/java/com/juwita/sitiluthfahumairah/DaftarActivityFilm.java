package com.juwita.sitiluthfahumairah;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

import com.juwita.sitiluthfahumairah.genre.Comedy;
import com.juwita.sitiluthfahumairah.genre.Film;
import com.juwita.sitiluthfahumairah.genre.Horror;
import com.juwita.sitiluthfahumairah.genre.Romance;

public class DaftarActivityFilm extends AppCompatActivity{

    public final static String FILM_TERPILIH ="film_obj_key";
    List<Film> films;
    ListView listView;
    String genreFilm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarfilm);
        Intent intent = getIntent();
        genreFilm = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        films = DataProvider.getFilmsByTipe(this,genreFilm);
        TextView txJudul = findViewById(R.id.text_title_daftar_film);
        String judul = "";
        if (films.get(0) instanceof Horror) {
           judul  = getString(R.string.horror);
        }  else if (films.get(0) instanceof Romance) {
            judul = getString(R.string.romance);
        } else if (films.get(0) instanceof Comedy) {
            judul = getString(R.string.comedy);
        }
        txJudul.setText(judul);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_film);
        DaftarFilmAdapter adapter = new DaftarFilmAdapter(this,films);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Film terpilih = films.get(position);
            bukaGaleriFilm(terpilih);
        }
    };

    private void bukaGaleriFilm(Film filmTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent inten1 = new Intent(getApplicationContext(), ProfileActivity.class);
        inten1.putExtra(FILM_TERPILIH, filmTerpilih);
        startActivity(inten1);
    }
}
