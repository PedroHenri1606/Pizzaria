package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends AbstractEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;
}
