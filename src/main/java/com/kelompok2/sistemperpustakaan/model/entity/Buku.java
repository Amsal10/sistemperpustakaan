package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_buku")
public class Buku {
    @Id
    @Column (name = "id_buku")
    private String idbuku;
    @Column (name = "judul_buku")
    private String judulbuku;
    @Column (name = "penulis_buku")
    private String penulisbuku;
    @Column (name = "penerbit_buku")
    private String penerbitbuku;
    @Column (name = "tahun_terbit")
    private String tahunterbit;
    @Column (name = "lokasi_rak")
    private String lokasirak;
    @Column (name = "jml_buku")
    private String jmlbuku;

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

    public String getTahunterbit() {
        return tahunterbit;
    }

    public void setTahunterbit(String tahunterbit) {
        this.tahunterbit = tahunterbit;
    }

    public String getLokasirak() {
        return lokasirak;
    }

    public void setLokasirak(String lokasirak) {
        this.lokasirak = lokasirak;
    }

    public String getJmlbuku() {
        return jmlbuku;
    }

    public void setJmlbuku(String jmlbuku) {
        this.jmlbuku = jmlbuku;
    }
}
