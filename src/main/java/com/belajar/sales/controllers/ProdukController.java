package com.belajar.sales.controllers;

import com.belajar.sales.dtos.HttpPagedResponse;
import com.belajar.sales.dtos.HttpResponse;
import com.belajar.sales.entities.Produk;
import com.belajar.sales.services.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@SecurityRequirement(name = "bearer-jwt")
@RestController
@RequestMapping("/produk")
@PreAuthorize("isAuthenticated()")
public class ProdukController {
    @Autowired
    ProdukService produkService;

    @GetMapping
    public HttpResponse<List<Produk>> getAllProduk(@RequestParam(required = false) String search) {
        return new HttpResponse<List<Produk>>(produkService.getAllProduk(), 200, "Success");
    }


    @GetMapping("page")
    public HttpPagedResponse<List<Produk>> getPageProduk(@RequestParam(required = false) String search, @RequestParam(required = false) int page) {
        var result = produkService.getPageProduk(search, page);
        return new HttpPagedResponse<List<Produk>>(result.getContent(), 200, result.getPageable().getPageSize(), result.getPageable().getPageNumber());
    }
}
