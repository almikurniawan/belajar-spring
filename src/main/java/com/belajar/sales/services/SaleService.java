package com.belajar.sales.services;

import com.belajar.sales.dtos.SaleRequestDto;
import com.belajar.sales.entities.Sale;
import com.belajar.sales.entities.SalesDetail;
import com.belajar.sales.repositories.IProdukRepository;
import com.belajar.sales.repositories.ISalesDetailRepository;
import com.belajar.sales.repositories.ISalesrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    ISalesDetailRepository salesDetailRepository;
    @Autowired
    ISalesrepository salesrepository;
    @Autowired
    IProdukRepository produkRepository;
    @Autowired
    private ISalesDetailRepository iSalesDetailRepository;

    @Transactional
    public boolean save(List<SaleRequestDto> saleRequestDto) {
        try{
            var sale = new Sale();
            sale.setTanggal(Instant.now());
            sale.setTotal(BigDecimal.ZERO);
            salesrepository.save(sale);

            BigDecimal total = BigDecimal.ZERO;

            for (SaleRequestDto item : saleRequestDto) {
                var produk = produkRepository.findById(item.getProdukId()).get();
                if(produk==null){
                    throw new Exception("Produk tidak ditemukan");
                }

                BigDecimal subTotal = produk.getHargaJual().multiply(BigDecimal.valueOf(item.getQty()));
                var itemDetail = new SalesDetail();
                itemDetail.setSales(sale);
                itemDetail.setQty(item.getQty());
                itemDetail.setProduk(produk);
                itemDetail.setHargaJual(produk.getHargaJual());
                itemDetail.setTotal(subTotal);
                total = total.add(subTotal);

                iSalesDetailRepository.save(itemDetail);

                produk.setStok(produk.getStok()-item.getQty());
                produkRepository.save(produk);
            }
            sale.setTotal(total);
            salesrepository.save(sale);
            return true;
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
