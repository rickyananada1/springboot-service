package com.springboot.uts_praktikum_java.controller;

import com.springboot.uts_praktikum_java.model.Pesanan;
import com.springboot.uts_praktikum_java.service.PesananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pesanan")
public class PesananController {
    @Autowired
    PesananService pesananService;

    @GetMapping("")
    public List<Pesanan> list() {
        return pesananService.getAllPesanan();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pesanan> get(@PathVariable Long id) {
        try {
            Pesanan pesanan = pesananService.getPesananById(id);
            return new ResponseEntity<>(pesanan, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Pesanan pesanan) {
        pesananService.createPesanan(pesanan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Pesanan pesanan, @PathVariable Long id) {
        try {
            Pesanan existPesanan = pesananService.getPesananById(id);
            pesanan.setId(id);
            pesananService.updatePesanan(id, pesanan);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pesananService.deletePesanan(id);
    }

}

