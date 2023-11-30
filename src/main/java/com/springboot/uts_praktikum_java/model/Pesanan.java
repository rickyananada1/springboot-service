package com.springboot.uts_praktikum_java.model;

import javax.persistence.*;

@Entity
public class Pesanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_id")
    private Long menu;

    @Column(name = "user_id")
    private Long user;

    private int jumlah_pesanan; // Tambahkan atribut jumlah_pesanan
    private Double total_harga;
    private String status;

    // Constructors, getters, and setters
    // ...

    public Pesanan() {
        // Default constructor
    }

    public Pesanan(Long menu, Long user, int jumlah_pesanan, Double total_harga, String status) {
        this.menu = menu;
        this.user = user;
        this.jumlah_pesanan = jumlah_pesanan;
        this.total_harga = total_harga;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenu() {
        return menu;
    }

    public void setMenu(Long menu) {
        this.menu = menu;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public int getjumlah_pesanan() {
        return jumlah_pesanan;
    }

    public void setjumlah_pesanan(int jumlah_pesanan) {
        this.jumlah_pesanan = jumlah_pesanan;
    }

    public Double gettotal_harga() {
        return total_harga;
    }

    public void settotal_harga(Double total_harga) {
        this.total_harga = total_harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
