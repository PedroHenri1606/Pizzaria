package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Nome do funcionario informado é um campo obrigatorio!")
    @NotBlank(message = "Nome do funcionario informado não pode ser vazio!")
    @Column(name = "nome_funcionario")
    private String nome;

    @Getter @Setter
    @NotNull(message = "CPF do funcionario informado é um campo obrigatorio!")
    @NotBlank(message = "CPF do funcionario informado não pode ser vazio!")
    @Column(name = "cpf_funcionario")
    private String cpf;

    @Getter @Setter
    @NotNull(message = "Telefone do funcionario informado é um campo obrigatorio!")
    @NotBlank(message = "Telefone do funcionario informado não pode ser vazio!")
    @Column(name = "telefone_funcionario")
    private String telefone;
}
