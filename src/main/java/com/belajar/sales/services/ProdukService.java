package com.belajar.sales.services;

import com.belajar.sales.entities.Produk;
import com.belajar.sales.repositories.IProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdukService {
    @Autowired
    IProdukRepository iProdukRepository;

    public List<Produk> getAllProduk() {
        return iProdukRepository.findAll();
    }

    public Page<Produk> getPageProduk(String search, int page) {
        int size = 2;
        Pageable pageable = PageRequest.of(page-1, size);
        Page result;
        if(search != null && !search.isEmpty()) {
            result = iProdukRepository.findProdukByNameContains(search.toUpperCase(), pageable);
        }else{
            result = iProdukRepository.findAll(pageable);
        }
        return result;
    }
}
