package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "data_peminjaman")
public class Peminjaman {
    @Id
    @Column (name = "id_peminjaman")
    private Integer idpeminjaman;
    @Column (name = "tgl_pinjam")
    private Date tglpinjam;
    @Column (name = "tgl_kembali")
    private Date tglkembali;
    @Column (name = "id_petugas")
    private Integer idpetugas;
    @Column (name = "id_anggota")
    private Integer idanggota;
    @Column (name = "id_buku")
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
