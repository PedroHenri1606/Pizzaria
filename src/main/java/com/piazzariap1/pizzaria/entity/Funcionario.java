package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario")
@Getter @Setter
public class Funcionario extends AbstractEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;
}
