package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_pustakawan")
public class Pustakawan {
    @Id
    @Column (name = "id_pustakawan", length = 8)
    private Integer idpustakawan;
    @Column (name = "nama_pustakawan")
    private String namapustakawan;
    @Column (name = "jk_pustakawan")
    private String jkpustakawan;
    @Column (name = "alamat_pustakawan")
    private String alamatpustakawan;
    @Column (name = "no_hp_pustakawan")
    private String nohppustakawan;
    @Column (name = "username_pustakawan")
    private String usernamepustakawan;
    @Column (name = "password_pustakawan")
    private String passwordpustakawan;
    @Column (name = "status_pustakawan")
    private String statuspustakawan;

    public Integer getIdpustakawan() {
        return idpustakawan;
    }

    public void setIdpustakawan(Integer idpustakawan) {
        this.idpustakawan = idpustakawan;
    }

    public String getNamapustakawan() {
        return namapustakawan;
    }

    public void setNamapustakawan(String namapustakawan) {
        this.namapustakawan = namapustakawan;
    }

    public String getJkpustakawan() {
        return jkpustakawan;
    }

    public void setJkpustakawan(String jkpustakawan) {
        this.jkpustakawan = jkpustakawan;
    }

    public String getAlamatpustakawan() {
        return alamatpustakawan;
    }

    public void setAlamatpustakawan(String alamatpustakawan) {
        this.alamatpustakawan = alamatpustakawan;
    }

    public String getNohppustakawan() {
        return nohppustakawan;
    }

    public void setNohppustakawan(String nohppustakawan) {
        this.nohppustakawan = nohppustakawan;
    }

    public String getUsernamepustakawan() {
        return usernamepustakawan;
    }

    public void setUsernamepustakawan(String usernamepustakawan) {
        this.usernamepustakawan = usernamepustakawan;
    }

    public String getPasswordpustakawan() {
        return passwordpustakawan;
    }

    public void setPasswordpustakawan(String passwordpustakawan) {
        this.passwordpustakawan = passwordpustakawan;
    }

    public String getStatuspustakawan() {
        return statuspustakawan;
    }

    public void setStatuspustakawan(String statuspustakawan) {
        this.statuspustakawan = statuspustakawan;
    }
}
