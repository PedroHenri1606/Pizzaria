package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractentitydto.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.entity.Pedido;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AcompanhamentoPedidoDTO extends AbstractEntityDTO {

    @NotNull(message = "{campo.acompanhamentoPedido-acompanhamento-NotNull}")
    private Acompanhamento acompanhamento;

    @Min(value = 1, message = "{campo.acompanhamentoPedido-quantidade-Min}")
    private Integer quantidade;

    private Pedido pedido;

    public AcompanhamentoPedidoDTO(Long id, Acompanhamento acompanhamento, Integer quantidade, Pedido pedido) {
        super(id);
        this.acompanhamento = acompanhamento;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }
}
