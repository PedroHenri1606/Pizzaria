package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_funcionario", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome_funcionario")
    private String nome;

    @Getter @Setter
    @Column(name = "cpf_funcionario")
    private String cpf;

    @Getter @Setter
    @Column(name = "telefone_funcionario")
    private String telefone;
}
