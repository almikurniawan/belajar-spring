package com.belajar.sales.repositories;

import com.belajar.sales.entities.SalesDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalesDetailRepository extends JpaRepository<SalesDetail, Integer> {
}
