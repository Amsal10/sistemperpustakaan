package com.kelompok2.sistemperpustakaan.model.dto;

import javax.persistence.Column;

public class PustakawanDto {
    private Integer idpustakawan;
    private String namapustakawan;
    private String jkpustakawan;
    private String alamatpustakawan;
    private String nohppustakawan;
    private String usernamepustakawan;
    private String passwordpustakawan;
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
