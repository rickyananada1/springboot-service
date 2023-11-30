package com.springboot.uts_praktikum_java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Secara otomatis di-generate oleh database
    private String nama_menu;
    private String deskripsi;
    private Double harga;
    private Integer stok;
    private String kategori;

    public Menu() {
        // Default constructor
    }

    public Menu(String nama_menu, String deskripsi, Double harga, Integer stok, String kategori) {
        this.nama_menu = nama_menu;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnama_menu() {
        return nama_menu;
    }

    public void setnama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
