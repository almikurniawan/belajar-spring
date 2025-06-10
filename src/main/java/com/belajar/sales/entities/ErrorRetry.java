package com.belajar.sales.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "error_retry", schema = "public")
public class ErrorRetry extends Auditable<String> {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "action", length = Integer.MAX_VALUE)
    private String action;

    @Column(name = "payload", length = Integer.MAX_VALUE)
    private String payload;

    @Column(name = "error", length = Integer.MAX_VALUE)
    private String error;


}