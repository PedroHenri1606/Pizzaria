package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractentitydto.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class PedidoDTO extends AbstractEntityDTO {

    private Cliente cliente;

    private Set<ProdutoPedido> item = new HashSet<>();

    private Set<AcompanhamentoPedido> acompanhamento = new HashSet<>();

    private Funcionario funcionario;

    private String observacao;

    private Boolean entregar;

    private Boolean pago;

    private SituacaoPedido situacaoPedido;

    private FormaDePagamento formaDePagamento;

    private Long valorTotal;

    public PedidoDTO(Long id, Cliente cliente, Funcionario funcionario, String observacao, Boolean entregar , FormaDePagamento formaDePagamento) {
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
