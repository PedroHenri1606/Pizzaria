package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import lombok.Getter;
import lombok.Setter;

public class ClienteDTO extends AbstractEntityDTO {

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String cpf;

    @Getter @Setter
    private String telefone;
}
