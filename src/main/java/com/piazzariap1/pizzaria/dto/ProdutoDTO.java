package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdutoDTO extends AbstractEntityDTO {

    @NotNull(message = "{campo.produto-descricao.NotNull}")
    @NotBlank(message = "{campo.produto-descricao-NotBlak}")
    private String descricao;

    @Min(value = 1, message = "{campo.produto-valor-Min}")
    private Long valor;

    @NotNull(message = "{campo.produto-tamanho-NotNull}")
    private TamanhoProduto tamanho;
}
