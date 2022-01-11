package com.juwita.sitiluthfahumairah;

import android.content.Context;

import com.juwita.sitiluthfahumairah.genre.Film;
import com.juwita.sitiluthfahumairah.genre.Horror;
import com.juwita.sitiluthfahumairah.genre.Romance;
import com.juwita.sitiluthfahumairah.genre.Comedy;

import java.util.ArrayList;
import java.util.List;
public class DataProvider {

    private static List<Film> films = new ArrayList<>();

    private static List<Horror> inifilmhorror(Context ctx) {
        List<Horror> horrors = new ArrayList<>();
        horrors.add(new Horror(ctx.getString(R.string.theconjuring_nama), ctx.getString(R.string.the_conjuring_genre),
                ctx.getString(R.string.the_conjuring_deskripsi), R.drawable.conjuring));
        horrors.add(new Horror(ctx.getString(R.string.the_nun), ctx.getString(R.string.the_nun_genre),
                ctx.getString(R.string.the_nun_deskripsi), R.drawable.thenun));
        horrors.add(new Horror(ctx.getString(R.string.anabelle_nama), ctx.getString(R.string.anabelle_genre),
                ctx.getString(R.string.anabelle_deskripsi), R.drawable.anabel));
        return horrors;

    }

    private static List<Romance> inifilmromance(Context ctx) {
        List<Romance> romances = new ArrayList<>();
        romances.add(new Romance(ctx.getString(R.string.love_rosie), ctx.getString(R.string.love_rosie_genre),
                ctx.getString(R.string.love_rosie_deskripsi), R.drawable.loverosie));
        romances.add(new Romance(ctx.getString(R.string.before_sunrise), ctx.getString(R.string.before_sunrise_genre),
                ctx.getString(R.string.before_surise_deskripsi), R.drawable.beforesunrise));
        romances.add(new Romance(ctx.getString(R.string.a_walk_to_remember), ctx.getString(R.string.a_walk_to_remember_genre),
                ctx.getString(R.string.a_walk_to_remember_deskripsi), R.drawable.film));
        return romances;
    }

    private static List<Comedy> inifilmcomedy(Context ctx) {
        List<Comedy> comedies = new ArrayList<>();
        comedies.add(new Comedy(ctx.getString(R.string.cek_toko_sebelah), ctx.getString(R.string.cek_toko_sebelah_genre),
                ctx.getString(R.string.cek_toko_sebelah_deskripsi), R.drawable.cektokosebelah));
        comedies.add(new Comedy(ctx.getString(R.string.susah_sinyal), ctx.getString(R.string.susah_sinyal_genre),
                ctx.getString(R.string.susah_sinyal_deskripsi), R.drawable.susahsinyal));
        comedies.add(new Comedy(ctx.getString(R.string.marmut_merah_jambu), ctx.getString(R.string.marmut_merah_jambu_genre),
                ctx.getString(R.string.marmut_merah_jambu_deskripsi), R.drawable.marmutmerah));
        return comedies;
    }

    private static void initAllFilms(Context ctx) {
        films.addAll(inifilmhorror(ctx));
        films.addAll(inifilmromance(ctx));
        films.addAll(inifilmcomedy(ctx));
    }

    public static List<Film> getAllFilm(Context ctx) {
        if (films.size() == 0) {
            initAllFilms(ctx);
        }
        return  films;
    }

    public static List<Film> getFilmsByTipe(Context ctx, String jenis) {
        List<Film> filmsByType = new ArrayList<>();
        if (films.size() == 0) {
            initAllFilms(ctx);
        }
        for (Film f : films) {
            if (f.getJenis().equals(jenis)) {
                filmsByType.add(f);
            }
        }
        return filmsByType;
    }
}
