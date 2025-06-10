package com.belajar.sales.controllers;

import com.belajar.sales.dtos.HttpResponse;
import com.belajar.sales.dtos.IPubersVersionResponseDto;
import com.belajar.sales.exceptionHandler.exception.CallHttpException;
import com.belajar.sales.services.ExternalService;
import com.belajar.sales.utils.WebClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequestMapping("http")
@RestController
public class HttpController {
    @Autowired
    ExternalService externalService;

    @GetMapping
    public ResponseEntity<HttpResponse<?>> get() throws ExecutionException, InterruptedException {
        var result = externalService.callSuccess().get();
        var data = result.getData();
        var version = data.getVersion();
        return ResponseEntity.ok(new HttpResponse<IPubersVersionResponseDto>(result, 200, "Success"));
    }

    @GetMapping("call-error")
    public ResponseEntity<HttpResponse<?>> call_error(){
        try{
            var result = externalService.callError();
            return ResponseEntity.ok(new HttpResponse<String>(result, 200, "Error"));
        }
        catch (CallHttpException e){
            return ResponseEntity.status(500).body(new HttpResponse<String>(e.message, 500, "Error"));
        }
    }
}
