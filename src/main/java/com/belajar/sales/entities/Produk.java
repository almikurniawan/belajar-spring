package com.belajar.sales.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "produk", schema = "public")
public class Produk {
    @Id
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    private String id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "harga_jual")
    private BigDecimal hargaJual;

    @Column(name = "stok")
    private Integer stok;

}