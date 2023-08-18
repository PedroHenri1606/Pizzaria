package com.piazzariap1.pizzaria.entity.abstractEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter @Setter
    @Column(name = "hr_cadastro")
    private LocalDateTime cadastro;

    @Getter @Setter
    @Column(name = "hr_edicao")
    private LocalDateTime edicao;

    @Getter @Setter
    @Column(name = "ativo")
    private boolean ativo;

    @PrePersist
    public void prePersist(){
        this.cadastro = LocalDateTime.now();
        this.ativo = true;
    }
}
