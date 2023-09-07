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

public class ProdutoPedidoDTO extends AbstractEntityDTO {

    @Getter @Setter
    @NotNull(message = "{campo.produtoPedido-acompanhamento-NotNull}")
    private Produto produto;

    @Getter @Setter
    @Min(value = 1, message = "{campo.produtoPedido-quantidade-Min}")
    private Integer quantidade;

    @Getter @Setter
    @NotNull(message = "{campo.produtoPedido-sabores-NotNull}")
    private Set<Sabor> sabores = new HashSet<>();

    @Getter @Setter
    private Pedido pedido;
}
