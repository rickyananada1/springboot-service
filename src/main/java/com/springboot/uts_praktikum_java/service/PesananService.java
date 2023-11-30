package com.springboot.uts_praktikum_java.service;

import com.springboot.uts_praktikum_java.model.Pesanan;
import com.springboot.uts_praktikum_java.repository.PesananRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PesananService {
    private final PesananRepository pesananRepository;

    @Autowired
    public PesananService(PesananRepository pesananRepository) {
        this.pesananRepository = pesananRepository;
    }

    public List<Pesanan> getAllPesanan() {
        return pesananRepository.findAll();
    }

    public Pesanan getPesananById(Long id) {
        return pesananRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Pesanan createPesanan(Pesanan pesanan) {
        return pesananRepository.save(pesanan);
    }

    public Pesanan updatePesanan(Long id, Pesanan updatedPesanan) {
        Pesanan existingPesanan = getPesananById(id);
        updatedPesanan.setId(existingPesanan.getId()); // Make sure ID does not change
        return pesananRepository.save(updatedPesanan);
    }

    public void deletePesanan(Long id) {
        pesananRepository.deleteById(id);
    }

}
