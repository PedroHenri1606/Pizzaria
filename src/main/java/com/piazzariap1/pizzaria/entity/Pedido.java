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
@Table(name = "tb_pedido", schema = "public")
public class Pedido extends AbstractEntity {

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "idCliente_pedido")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "pedido_item",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @Getter @Setter
    private Set<ItemPedido> item = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "pedido_acompanhamento",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "acompanhamento_id")
    )
    @Getter @Setter
    private Set<Acompanhamento> acompanhamento = new HashSet<>();

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "idFuncionario_pedido")
    private Funcionario funcionario;

    @Getter @Setter
    @JoinColumn(name = "observacao_pedido")
    private String observacao;

    @Getter @Setter
    @JoinColumn(name = "entregar_pedido")
    private Boolean entregar;

    @Getter @Setter
    @JoinColumn(name = "pago_pedido")
    private Boolean pago;

    @Getter @Setter
    @JoinColumn(name = "situacao_pedido")
    private SituacaoPedido situacaoPedido;

    @Getter @Setter
    @JoinColumn(name = "forma_pagamento_pedido")
    private FormaDePagamento formaDePagamento;

    @Getter @Setter
    @JoinColumn(name = "valor_total_pedido")
    private Long valorTotal;
}
