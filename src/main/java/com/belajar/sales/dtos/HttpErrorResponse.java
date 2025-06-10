package com.belajar.sales.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpErrorResponse<T> {
    private T errors;
    private int status;
    private String message;
    public HttpErrorResponse(T errors, int status, String message) {
        this.errors = errors;
        this.status = status;
        this.message = message;
    }
}
