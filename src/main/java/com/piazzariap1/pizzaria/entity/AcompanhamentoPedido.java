package com.piazzariap1.pizzaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ACOMPANHAMENTO_PEDIDO")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoPedido{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "acompanhamento_id")
    @NotNull(message = "{campo.acompanhamentoPedido-acompanhamento-NotNull}")
    private Acompanhamento acompanhamento;

    @Column(name = "quantidade")
    @Min(value = 1, message = "{campo.acompanhamentoPedido-quantidade-Min}")
    private Integer quantidade;

    @Column(name = "observacao")
    private String observacao;
}