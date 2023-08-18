package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_sabor", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Sabor extends AbstractEntity {

    @Getter @Setter
    @NotNull(message = "Nome do sabor informado é um campo obrigatorio!")
    @NotBlank(message = "Nome do sabor informado não pode ser vazio!")
    @Column(name = "nome_sabor")
    private String nome;

    @Getter @Setter
    @NotNull(message = "Descrição do sabor informado é um campo obrigatorio!")
    @NotBlank(message = "Descrição do sabor informado não pode ser vazio!")
    @Column(name = "descricao_sabor")
    private String descricao;
}
