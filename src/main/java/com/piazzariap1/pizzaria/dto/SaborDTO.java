package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.ProdutoPedido;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


public class SaborDTO extends AbstractEntityDTO {

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private Set<ProdutoPedido> produtosPedidos;
}
