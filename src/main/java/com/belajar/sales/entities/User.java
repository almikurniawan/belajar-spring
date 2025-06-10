package com.belajar.sales.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"user\"", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "user_uniq_pk", columnNames = {"username"})
})
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "username", nullable = false, length = Integer.MAX_VALUE)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

}