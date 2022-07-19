package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="data_anggota")

public class Anggota {
    @Id
    @Column(name = "id_Anggota")
    private Integer idAnggota;
    @Column(name = "user_Name")
    private String userName;
    @Column(name = "nama_Anggota")
    private String namaAnggota;
    @Column(name = "jk_Anggota")
    private String jkAnggota;
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Column(name = "alamat_Anggota")
    private String alamatAnggota;
    @Column(name = "no_Hp_Anggota")
    private Integer noHpAnggota;
    @Column(name = "password_Anggota")
    private String passwordAnggota;
    @Column(name = "status_Anggota")
    private String statusAnggota;


    public Integer getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(Integer idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNamaAnggota(Integer idAnggota) {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getJkAnggota(String jkAnggota) {
        return this.jkAnggota;
    }

    public void setJkAnggota(String jkAnggota) {
        this.jkAnggota = jkAnggota;
    }

    public String getPekerjaan(String pekerjaan) {
        return this.pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamatAnggota(String alamatAnggota) {
        return this.alamatAnggota;
    }

    public void setAlamatAnggota(String alamatAnggota) {
        this.alamatAnggota = alamatAnggota;
    }

    public Integer getNoHpAnggota() {
        return noHpAnggota;
    }

    public void setNoHpAnggota(Integer noHpAnggota) {
        this.noHpAnggota = noHpAnggota;
    }

    public String getPasswordAnggota(String passwordAnggota) {
        return this.passwordAnggota;
    }

    public void setPasswordAnggota(String passwordAnggota) {
        this.passwordAnggota = passwordAnggota;
    }

    public String getStatusAnggota() {
        return statusAnggota;
    }

    public void setStatusAnggota(String statusAnggota) {
        this.statusAnggota = statusAnggota;
    }
}


