package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.entity.Sabor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class ProdutoPedidoDTO extends AbstractEntityDTO {

    @Getter @Setter
    private Produto idProduto;

    @Getter @Setter
    private Integer quantidade;

    @Getter @Setter
    private Set<Sabor> sabor = new HashSet<>();
}
