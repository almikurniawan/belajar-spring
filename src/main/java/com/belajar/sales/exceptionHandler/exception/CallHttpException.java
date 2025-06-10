package com.belajar.sales.exceptionHandler.exception;

import java.io.IOException;

public class CallHttpException extends IOException {
    public String message = "";
    public String payload = "";

    public CallHttpException(String apiFailed, String payload) {
        message = apiFailed;
        this.payload = payload;
    }
}
