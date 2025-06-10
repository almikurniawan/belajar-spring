package com.belajar.sales.repositories;

import com.belajar.sales.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalesrepository extends JpaRepository<Sale, Integer> {
}
