package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import lombok.Getter;
import lombok.Setter;

public class ProdutoDTO extends AbstractEntityDTO {

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private tamanhoProduto tamanho;

    @Getter @Setter
    private Long valor;
}
