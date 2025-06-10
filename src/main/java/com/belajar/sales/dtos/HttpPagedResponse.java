package com.belajar.sales.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpPagedResponse<T> {
    private T data;
    private int status;
    private String message;
    private int total;
    private int page;
    public HttpPagedResponse(T data, int status, int total, int page) {
        this.data = data;
        this.status = status;
        this.total = total;
        this.page = page;
    }


    public HttpPagedResponse(T data, int status, String message, int total, int page) {
        this.data = data;
        this.status = status;
        this.total = total;
        this.page = page;
        this.message = message;
    }
}
