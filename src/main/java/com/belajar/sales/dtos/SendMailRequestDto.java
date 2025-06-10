package com.belajar.sales.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMailRequestDto {
    public String to;
    public String subject;
    public String body;
}
