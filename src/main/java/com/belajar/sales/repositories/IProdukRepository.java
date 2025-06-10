package com.belajar.sales.repositories;

import com.belajar.sales.entities.Produk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdukRepository extends JpaRepository<Produk, String> {
    Page<Produk> findProdukByName(String search, Pageable pageable);

    Page<Produk> findProdukByNameContains(String search, Pageable pageable);
}
