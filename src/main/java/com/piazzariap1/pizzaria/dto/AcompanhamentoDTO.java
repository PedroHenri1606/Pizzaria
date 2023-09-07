package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class AcompanhamentoDTO extends AbstractEntityDTO {

    @Getter @Setter
    @NotNull(message = "{campo.acompanhamento-descricao.NotNull}")
    @NotBlank(message = "{campo.acompanhamento-descricao-NotBlak}")
    private String descricao;

    @Getter @Setter
    @Min(value = 1, message = "{campo.acompanhamento-valor-Min}")
    private Long valor;
}
