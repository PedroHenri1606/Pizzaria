package com.piazzariap1.pizzaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sabor")
@Getter @Setter
@NoArgsConstructor
public class Sabor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "nome")
    @NotNull(message = "{campo.sabor-nome-NotNull")
    @NotBlank(message = "{campo.sabor-nome-NotBlank}")
    private String nome;

    @Column(name = "descricao")
    private String descricao;
}
