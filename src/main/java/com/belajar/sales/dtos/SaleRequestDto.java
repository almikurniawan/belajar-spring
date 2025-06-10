package com.belajar.sales.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleRequestDto {
    @NotBlank(message = "produk is required")
    String produkId;
    @Min(value = 1, message = "Minimum qty is 1")
    int qty;
}
