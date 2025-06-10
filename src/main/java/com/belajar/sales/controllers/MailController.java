package com.belajar.sales.controllers;

import com.belajar.sales.dtos.HttpResponse;
import com.belajar.sales.dtos.SendMailRequestDto;
import com.belajar.sales.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping
    public ResponseEntity<HttpResponse<?>> sendMail(@RequestBody SendMailRequestDto payload) {
        try{
            mailService.sendMail(payload.to, payload.subject, payload.body);
            return ResponseEntity.ok(new HttpResponse<String>("Success", 200, "Success"));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
