package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Pedido;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.entity.Sabor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class ProdutoPedidoDTO extends AbstractEntityDTO {

    @NotNull(message = "{campo.produtoPedido-acompanhamento-NotNull}")
    private Produto produto;

    @Min(value = 1, message = "{campo.produtoPedido-quantidade-Min}")
    private Integer quantidade;

    @NotNull(message = "{campo.produtoPedido-sabores-NotNull}")
    private Set<Sabor> sabores = new HashSet<>();

    private Pedido pedido;
}
