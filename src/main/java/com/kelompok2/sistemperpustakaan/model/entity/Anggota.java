package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.*;

@Entity
@Table(name="data_anggota")

public class Anggota {
    @Id
    @Column(name = "id_Anggota", length  = 5)
    private Integer idanggota;
    @Column(name = "user_Name")
    private String username;
    @Column(name = "nama_Anggota")
    private String namaanggota;
    @Column(name = "jk_Anggota")
    private String jkanggota;
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Column(name = "alamat_Anggota")
    private String alamatanggota;
    @Column(name = "no_Hp_Anggota")
    private Integer nohpanggota;
    @Column(name = "password_Anggota")
    private String passwordanggota;
    @Column(name = "status_Anggota")
    private String statusanggota;

    @OneToOne
    @JoinColumn(name = "detailid", insertable = false, updatable = false)
    private Peminjaman peminjaman;


    public Integer getIdanggota() {
        return idanggota;
    }

    public void setIdanggota(Integer idanggota) {
        this.idanggota = idanggota;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamaanggota() {
        return namaanggota;
    }

    public void setNamaanggota(String namaanggota) {
        this.namaanggota = namaanggota;
    }

    public String getJkanggota() {
        return jkanggota;
    }

    public void setJkanggota(String jkanggota) {
        this.jkanggota = jkanggota;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamatanggota() {
        return alamatanggota;
    }

    public void setAlamatanggota(String alamatanggota) {
        this.alamatanggota = alamatanggota;
    }

    public Integer getNohpanggota() {
        return nohpanggota;
    }

    public void setNohpanggota(Integer nohpanggota) {
        this.nohpanggota = nohpanggota;
    }

    public String getPasswordanggota() {
        return passwordanggota;
    }

    public void setPasswordanggota(String passwordanggota) {
        this.passwordanggota = passwordanggota;
    }

    public String getStatusanggota() {
        return statusanggota;
    }

    public void setStatusanggota(String statusanggota) {
        this.statusanggota = statusanggota;
    }

    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }
}


