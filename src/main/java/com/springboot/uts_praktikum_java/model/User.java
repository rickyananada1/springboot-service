package com.springboot.uts_praktikum_java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Secara otomatis di-generate oleh database
    private String username;
    private String password;
    private String nama_lengkap;
    private String email;
    private String peran;
    private String alamat;
    private String nomor_telepon;

    public User() {
        // Default constructor
    }

    public User(String username, String password, String nama_lengkap, String email, String peran, String alamat, String nomor_telepon) {
        this.username = username;
        this.password = password;
        this.nama_lengkap = nama_lengkap;
        this.email = email;
        this.peran = peran;
        this.alamat = alamat;
        this.nomor_telepon = nomor_telepon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getnama_lengkap() {
        return nama_lengkap;
    }

    public void setnama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getnomor_telepon() {
        return nomor_telepon;
    }

    public void setnomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }
}