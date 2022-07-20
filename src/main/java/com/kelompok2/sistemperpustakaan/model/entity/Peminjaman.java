package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "data_peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column (name = "id_peminjaman")
    private Integer idPeminjaman;
    @Column (name = "tgl_pinjam")
    private Date tglPinjam;
    @Column (name = "tgl_kembali")
    private Date tglKembali;
    @Column (name = "id_pustakawan")
    private Integer idPustakawan;
    @Column (name = "id_anggota")
    private Integer idAnggota;
    @Column (name = "id_buku")
    private String idBuku;

    public Integer getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(Integer idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }

    public Integer getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(Integer idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public Integer getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(Integer idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }
}
