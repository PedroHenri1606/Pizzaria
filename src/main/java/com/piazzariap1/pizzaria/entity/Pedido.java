package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
@Getter @Setter
@NoArgsConstructor
public class Pedido extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private Set<ProdutoPedido> item = new HashSet<>();

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private Set<AcompanhamentoPedido> acompanhamento = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario funcionario;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "entregar")
    private Boolean entregar;

    @Column(name = "pago")
    private Boolean pago;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_pedido")
    private SituacaoPedido situacaoPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_de_pagamento")
    private FormaDePagamento formaDePagamento;

    @Column(name = "valor_total")
    private Long valorTotal;

    public Pedido(Long id, Cliente cliente, Funcionario funcionario, String observacao, Boolean entregar, FormaDePagamento formaDePagamento) {
        super(id);
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.observacao = observacao;
        this.entregar = entregar;
        this.formaDePagamento = formaDePagamento;
    }

    public void adicionarProduto(Set<ProdutoPedido> item, Set<AcompanhamentoPedido> acompanhamento){
        this.item = item;
        this.acompanhamento = acompanhamento;
    }
}
