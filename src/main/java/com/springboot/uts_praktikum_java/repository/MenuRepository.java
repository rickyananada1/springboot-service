package com.springboot.uts_praktikum_java.repository;

import com.springboot.uts_praktikum_java.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("SELECT m FROM Menu m WHERE m.nama_menu LIKE CONCAT('%', :query, '%')")
    Menu findByNamaMenu(String query);
}