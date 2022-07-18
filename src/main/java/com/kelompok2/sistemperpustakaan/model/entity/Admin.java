package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_admin")
public class Admin {
    @Id
    @Column(name = " id_admin")
    private String idadmin;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "status_admin")
    private String statusadmin;

    public String getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus_admin() {
        return statusadmin;
    }

    public void setStatus_admin(String status_admin) {
        this.statusadmin = status_admin;
    }
}
