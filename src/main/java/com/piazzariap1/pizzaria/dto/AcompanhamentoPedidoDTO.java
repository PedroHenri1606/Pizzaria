package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractentitydto.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Pedido;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AcompanhamentoPedidoDTO extends AbstractEntityDTO {

    @NotNull(message = "{campo.acompanhamentoPedido-acompanhamento-NotNull}")
    private AcompanhamentoDTO acompanhamentoDTO;

    @Min(value = 1, message = "{campo.acompanhamentoPedido-quantidade-Min}")
    private Integer quantidade;

    private Pedido pedido;

    public AcompanhamentoPedidoDTO(Long id, AcompanhamentoDTO acompanhamentoDTO, Integer quantidade, Pedido pedido) {
        super(id);
        this.acompanhamentoDTO = acompanhamentoDTO;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }
}
