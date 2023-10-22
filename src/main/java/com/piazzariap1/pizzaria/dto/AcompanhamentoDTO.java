package com.piazzariap1.pizzaria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AcompanhamentoDTO   {

    private Long id;

    private boolean ativo;

    @NotNull(message = "{campo.acompanhamento-descricao.NotNull}")
    @NotBlank(message = "{campo.acompanhamento-descricao-NotBlak}")
    private String descricao;

    @Min(value = 1, message = "{campo.acompanhamento-valor-Min}")
    private Long valor;
}
