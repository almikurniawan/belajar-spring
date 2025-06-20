package com.belajar.sales.repositories;

import com.belajar.sales.entities.Produk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProdukRepository extends JpaRepository<Produk, String> {
    Page<Produk> findProdukByName(String search, Pageable pageable);

    Page<Produk> findProdukByNameContains(String search, Pageable pageable);

    List<Produk> findProdukById(String id);
}
