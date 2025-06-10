package com.belajar.sales.repositories;

import com.belajar.sales.entities.ErrorRetry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IErrorRetryRepository extends CrudRepository<ErrorRetry, Long> {
}
