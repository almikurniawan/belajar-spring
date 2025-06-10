package com.belajar.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "sales", schema = "public")
public class Sale extends Auditable<String> {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "tanggal")
    private Instant tanggal;

    @Column(name = "total")
    private BigDecimal total;

}