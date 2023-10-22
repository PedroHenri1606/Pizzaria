package com.piazzariap1.pizzaria.entity.abstractentity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
public abstract class User {

    @Column(name = "user_email")
    private String email;


    @Column(name = "user_senha")
    private String senha;

    public User(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
