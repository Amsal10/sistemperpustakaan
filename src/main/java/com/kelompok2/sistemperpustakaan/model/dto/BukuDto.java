package com.kelompok2.sistemperpustakaan.model.dto;

import javax.persistence.Column;

public class BukuDto {
    private String idbuku;
    private String judulbuku;
    private String penulisbuku;
    private String penerbitbuku;
    private Integer tahunterbit;
    private String lokasirak;
    private Integer jmlbuku;

    public String getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(String idbuku) {
        this.idbuku = idbuku;
    }

    public String getJudulbuku() {
        return judulbuku;
    }

    public void setJudulbuku(String judulbuku) {
        this.judulbuku = judulbuku;
    }

    public String getPenulisbuku() {
        return penulisbuku;
    }

    public void setPenulisbuku(String penulisbuku) {
        this.penulisbuku = penulisbuku;
    }

    public String getPenerbitbuku() {
        return penerbitbuku;
    }

    public void setPenerbitbuku(String penerbitbuku) {
        this.penerbitbuku = penerbitbuku;
    }

    public Integer getTahunterbit() {
        return tahunterbit;
    }

    public void setTahunterbit(Integer tahunterbit) {
        this.tahunterbit = tahunterbit;
    }

    public String getLokasirak() {
        return lokasirak;
    }

    public void setLokasirak(String lokasirak) {
        this.lokasirak = lokasirak;
    }

    public Integer getJmlbuku() {
        return jmlbuku;
    }

    public void setJmlbuku(Integer jmlbuku) {
        this.jmlbuku = jmlbuku;
    }
}
