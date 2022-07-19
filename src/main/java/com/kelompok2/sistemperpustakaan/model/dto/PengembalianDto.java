package com.kelompok2.sistemperpustakaan.model.dto;

import java.sql.Date;

public class PengembalianDto {
    private Integer idpengembalian;
    private Date tglkembali;
    private Date jatuhtempo;
    private Integer totaldenda;
    private Integer idpustakawan;
    private Integer idanggota;
    private String idbuku;

    public Integer getIdpengembalian() {
        return idpengembalian;
    }

    public void setIdpengembalian(Integer idpengembalian) {
        this.idpengembalian = idpengembalian;
    }

    public Date getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(Date tglkembali) {
        this.tglkembali = tglkembali;
    }

    public Date getJatuhtempo() {
        return jatuhtempo;
    }

    public void setJatuhtempo(Date jatuhtempo) {
        this.jatuhtempo = jatuhtempo;
    }

    public Integer getTotaldenda() {
        return totaldenda;
    }

    public void setTotaldenda(Integer totaldenda) {
        this.totaldenda = totaldenda;
    }

    public Integer getIdpustakawan() {
        return idpustakawan;
    }

    public void setIdpustakawan(Integer idpustakawan) {
        this.idpustakawan = idpustakawan;
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
