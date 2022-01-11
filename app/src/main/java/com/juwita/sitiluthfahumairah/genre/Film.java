package com.juwita.sitiluthfahumairah.genre;

import java.io.Serializable;

public class Film implements Serializable {
    private String jenis;
    private String nama;
    private String genre;
    private String deskripsi;
    private int drawableRes;

    public Film(String jenis, String nama, String genre, String deskripsi, int drawableRes) {
        this.jenis = jenis;
        this.nama = nama;
        this.genre = genre;
        this.deskripsi = deskripsi;
        this.drawableRes = drawableRes;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }
}
