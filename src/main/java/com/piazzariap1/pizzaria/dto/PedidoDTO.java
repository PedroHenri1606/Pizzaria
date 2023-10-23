package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class PedidoDTO   {

    private Long id;

    private Cliente cliente;

    private Set<Produto> item = new HashSet<>();

    private Set<Acompanhamento> acompanhamento = new HashSet<>();

    private Funcionario funcionario;

    private String observacao;

    private Boolean entregar;

    private Boolean pago;

    private SituacaoPedido situacaoPedido;

    private FormaDePagamento formaDePagamento;

    private Long valorTotal;
}
