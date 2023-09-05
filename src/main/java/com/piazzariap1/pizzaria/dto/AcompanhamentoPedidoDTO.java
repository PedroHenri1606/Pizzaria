package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.AcompanhamentoPedido;
import com.piazzariap1.pizzaria.entity.Pedido;
import com.piazzariap1.pizzaria.entity.Produto;
import lombok.Getter;
import lombok.Setter;

public class AcompanhamentoPedidoDTO extends AbstractEntityDTO {

    @Getter @Setter
    private AcompanhamentoPedido acompanhamentoPedido;

    @Getter @Setter
    private Integer quantidade;

    @Getter @Setter
    private Pedido pedido;

}
