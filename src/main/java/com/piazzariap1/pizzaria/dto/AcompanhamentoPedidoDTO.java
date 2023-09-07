package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.AcompanhamentoPedido;
import com.piazzariap1.pizzaria.entity.Pedido;
import com.piazzariap1.pizzaria.entity.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class AcompanhamentoPedidoDTO extends AbstractEntityDTO {

    @Getter @Setter
    @NotNull(message = "{campo.acompanhamentoPedido-acompanhamento-NotNull}")
    private AcompanhamentoPedido acompanhamentoPedido;

    @Getter @Setter
    @Min(value = 1, message = "{campo.acompanhamentoPedido-quantidade-Min}")
    private Integer quantidade;

    @Getter @Setter
    private Pedido pedido;

}
