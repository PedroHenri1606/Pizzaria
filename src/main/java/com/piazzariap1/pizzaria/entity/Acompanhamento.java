package com.piazzariap1.pizzaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ACOMPANHAMENTO")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Acompanhamento{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "descricao")
    @NotNull(message = "{campo.acompanhamento-descricao.NotNull}")
    @NotBlank(message = "{campo.acompanhamento-descricao-NotBlak}")
    private String descricao;

    @Column(name = "valor")
    @Min(value = 1, message = "{campo.acompanhamento-valor-Min}")
    private Long valor;
}
