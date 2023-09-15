package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractentitydto.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.ProdutoPedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class SaborDTO extends AbstractEntityDTO {

    @NotNull(message = "{campo.sabor-nome-NotNull")
    @NotBlank(message = "{campo.sabor-nome-NotBlank}")
    private String nome;

    private String descricao;

    private Set<ProdutoPedido> produtosPedidos;
}
