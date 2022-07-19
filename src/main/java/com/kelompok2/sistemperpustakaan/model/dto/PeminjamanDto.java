package com.kelompok2.sistemperpustakaan.model.dto;

import java.util.Date;

public class PeminjamanDto {
    private Integer idpeminjaman;
    private Date tglpinjam;
    private Date tglkembali;
    private Integer idpetugas;
    private Integer idanggota;
    private String idbuku;

    public Integer getIdpeminjaman() {
        return idpeminjaman;
    }
    public void setIdpeminjaman(Integer idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }
    public Date getTglpinjam() {
        return tglpinjam;
    }
    public void setTglpinjam(Date tglpinjam) {
        this.tglpinjam = tglpinjam;
    }
    public Date getTglkembali() {
        return tglkembali;
    }
    public void setTglkembali(Date tglkembali) {
        this.tglkembali = tglkembali;
    }
    public Integer getIdpetugas() {
        return idpetugas;
    }
    public void setIdpetugas(Integer idpetugas) {
        this.idpetugas = idpetugas;
    }
    public Integer getIdanggota() {
        return idanggota;
    }
    public void setIdanggota(Integer idanggota) {
        this.idanggota = idanggota;
    }
    public String getIdbuku() {
        return idbuku;
    }
    public void setIdbuku(String idbuku) {
        this.idbuku = idbuku;
    }
}
