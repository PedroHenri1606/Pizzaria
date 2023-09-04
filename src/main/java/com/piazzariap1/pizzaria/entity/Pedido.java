package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tb_pedido")
public class Pedido extends AbstractEntity {

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @Getter @Setter
    @OneToMany(mappedBy = "pedido")
    private Set<ProdutoPedido> item = new HashSet<>();

    @Getter @Setter
    @OneToMany(mappedBy = "pedido")
    private Set<Acompanhamento> acompanhamento = new HashSet<>();

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario funcionario;

    @Getter @Setter
    @Column(name = "observacao")
    private String observacao;

    @Getter @Setter
    @Column(name = "entregar")
    private Boolean entregar;

    @Getter @Setter
    @Column(name = "pago")
    private Boolean pago;

    @Getter @Setter
    @Column(name = "situacao_pedido")
    private SituacaoPedido situacaoPedido;

    @Getter @Setter
    @Column(name = "forma_de_pagamento")
    private FormaDePagamento formaDePagamento;

    @Getter @Setter
    @Column(name = "valor_total")
    private Long valorTotal;
}
