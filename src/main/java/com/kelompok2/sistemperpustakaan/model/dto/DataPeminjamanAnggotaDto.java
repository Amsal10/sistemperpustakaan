package com.kelompok2.sistemperpustakaan.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DataPeminjamanAnggotaDto {
    private String namaAnggota;
    private String pekerjaan;
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date tglPinjam;
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date tglKembali;

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
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
}
