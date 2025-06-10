package com.belajar.sales.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class IPubersVersionResponseDto{
    public int statusCode;
    public String statusDesc;
    public String statusDescHeading;

    @Setter
    @Getter
    public Data data;
}

