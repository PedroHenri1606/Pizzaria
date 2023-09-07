package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.ProdutoPedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


public class SaborDTO extends AbstractEntityDTO {

    @Getter @Setter
    @NotNull(message = "{campo.sabor-nome-NotNull")
    @NotBlank(message = "{campo.sabor-nome-NotBlank}")
    private String nome;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private Set<ProdutoPedido> produtosPedidos;
}
