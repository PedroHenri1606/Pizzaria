package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Sabor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

public class AcompanhamentoDTO extends AbstractEntityDTO {

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private Long valor;
}
