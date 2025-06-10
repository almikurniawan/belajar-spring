package com.belajar.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "sales_detail", schema = "public")
public class SalesDetail  extends Auditable<String>{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_id")
    private Sale sales;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produk_id")
    private Produk produk;

    @Column(name = "harga_jual")
    private BigDecimal hargaJual;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "total")
    private BigDecimal total;

}