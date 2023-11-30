package com.springboot.uts_praktikum_java.repository;

import com.springboot.uts_praktikum_java.model.Pesanan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PesananRepository extends JpaRepository<Pesanan, Long> {
    // Di sini Anda dapat menambahkan metode tambahan khusus jika diperlukan
	Pesanan findByStatus(String status);
}
