package com.belajar.sales.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Data{
    public int id;
    public String version;
    public Date tanggalUpdate;
    public int requiredUpdate;
    public int apps;
    public boolean isBetaVersion;
}
