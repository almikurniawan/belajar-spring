package com.belajar.sales.controllers;

import com.belajar.sales.dtos.HttpResponse;
import com.belajar.sales.dtos.SaleRequestDto;
import com.belajar.sales.services.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("sale")
@RestController
@PreAuthorize("isAuthenticated()")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<?> createSale(@Valid @RequestBody List<SaleRequestDto> saleRequestDto) {
        try{
            var create = saleService.save(saleRequestDto);
            if(create){
                return ResponseEntity.ok(new HttpResponse<String>("berhasil create penjualan",200, "Success"));
            }else{
                return ResponseEntity.status(500).body(new HttpResponse<String>("gagal create penjualan",500, "Failur"));
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(new HttpResponse<String>("gagal create penjualan",500, "Failur"));
        }
    }
}
