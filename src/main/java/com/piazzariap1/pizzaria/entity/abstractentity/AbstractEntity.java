package com.piazzariap1.pizzaria.entity.abstractentity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;


    @Column(name = "hr_cadastro")
    private LocalDateTime cadastro;


    @Column(name = "hr_edicao")
    private LocalDateTime edicao;


    @Column(name = "ativo")
    private boolean ativo;

    @PrePersist
    public void prePersist(){
        this.cadastro = LocalDateTime.now();
        this.ativo = true;
    }
}
