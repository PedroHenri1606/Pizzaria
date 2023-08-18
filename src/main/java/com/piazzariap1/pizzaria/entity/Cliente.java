package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "tb_cliente", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends AbstractEntity {

    @Getter @Setter
    @NotNull(message = "Nome do cliente é um campo obrigatorio!")
    @NotBlank(message = "Nome do cliente não pode ser vazio!")
    @Column(name = "nome_cliente")
    private String nome;

    @Getter @Setter
    @NotNull(message = "Cpf do cliente é um campo obrigatorio!")
    @NotBlank(message = "Cpf do cliente não pode ser vazio!")
    @CPF(message = "CPF informado não é válido!")
    @Column(name = "cpf_cliente")
    private String cpf;

    @Getter @Setter
    @NotNull(message = "Telefone do cliente é um campo obrigatorio!")
    @NotBlank(message = "Telefone do cliente não ser vazio!")
    @Column(name = "telefone_cliente")
    private String telefone;
}
