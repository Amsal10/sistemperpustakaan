package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name = "data_pengembalian")
public class Pengembalian {
    @Id
    @Column (name = "id_pengembalian")
    private Integer idpengembalian;
    @Column (name = "tgl_kembali")
    private Date tglkembali;
    @Column (name = "jatuh_tempo")
    private Date jatuhtempo;
    @Column (name = "total_denda")
    private Integer totaldenda;
    @Column (name = "id_petugas")
    private Integer idpetugas;
    @Column (name = "id_anggota")
    private Integer idanggota;
    @Column (name = "id_buku")
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
