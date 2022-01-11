package com.juwita.sitiluthfahumairah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
import com.juwita.sitiluthfahumairah.genre.Film;
public class DaftarFilmAdapter extends ArrayAdapter<Film>{

    Context context;

    public DaftarFilmAdapter(Context context, List<Film> films) {
        super(context, R.layout.row_daftar_film, films);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textGenre;
        TextView textNama;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Film film = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_film, parent, false);
            viewHolder.textGenre =  convertView.findViewById(R.id.row_text_genre);
            viewHolder.textNama = (TextView) convertView.findViewById(R.id.row_text_nama_film);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_film);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textGenre.setText(film.getGenre());
        viewHolder.textNama.setText(film.getNama());
        viewHolder.gambar.setImageDrawable(context.getDrawable(film.getDrawableRes()));
        return convertView;
    }
}
