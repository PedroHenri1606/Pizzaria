package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_PEDIDO")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "tb_item_pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<ProdutoPedido> item = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "tb_acompanhamento_pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "acompanhamento_id")
    )
    private Set<AcompanhamentoPedido> acompanhamento = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "endereco_entrega")
    private Endereco enderecoEntrega;

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
}
