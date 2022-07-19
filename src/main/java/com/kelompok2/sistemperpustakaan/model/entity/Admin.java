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
    private String idAdmin;
    @Column(name = "username")
    private String usernameAdmin;
    @Column(name = "password")
    private String passwordAdmin;
    @Column(name = "status_admin")
    private String statusAdmin;

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getStatusAdmin() {
        return statusAdmin;
    }

    public void setStatusAdmin(String statusAdmin) {
        this.statusAdmin = statusAdmin;
    }
}
