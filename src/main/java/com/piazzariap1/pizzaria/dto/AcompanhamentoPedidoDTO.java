package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.Acompanhamento;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AcompanhamentoPedidoDTO   {

    private Long id;

    @NotNull(message = "{campo.acompanhamentoPedido-acompanhamento-NotNull}")
    private Acompanhamento acompanhamento;

    @Min(value = 1, message = "{campo.acompanhamentoPedido-quantidade-Min}")
    private Integer quantidade;

    private String observacao;
}
