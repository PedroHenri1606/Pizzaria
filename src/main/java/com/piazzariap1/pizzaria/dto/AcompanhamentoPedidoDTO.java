package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Produto;
import lombok.Getter;
import lombok.Setter;

public class AcompanhamentoPedidoDTO extends AbstractEntityDTO {

    @Getter
    @Setter
    private Produto idProduto;

    @Getter @Setter
    private Integer quantidade;

}
