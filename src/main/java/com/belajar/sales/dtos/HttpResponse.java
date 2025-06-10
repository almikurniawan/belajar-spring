package com.belajar.sales.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpResponse<T> {
    private T data;
    private int status;
    private String message;
    public HttpResponse(T data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }
}
