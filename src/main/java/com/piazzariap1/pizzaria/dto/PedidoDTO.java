package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class PedidoDTO extends AbstractEntityDTO {

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private Set<ProdutoPedido> item = new HashSet<>();

    @Getter @Setter
    private Set<AcompanhamentoPedido> acompanhamento = new HashSet<>();

    @Getter @Setter
    private Funcionario funcionario;

    @Getter @Setter
    private String observacao;

    @Getter @Setter
    private Boolean entregar;

    @Getter @Setter
    private Boolean pago;

    @Getter @Setter
    private SituacaoPedido situacaoPedido;

    @Getter @Setter
    private FormaDePagamento formaDePagamento;

    @Getter @Setter
    private Long valorTotal;
}
