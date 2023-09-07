package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.validation.constraints.CPF;
import com.piazzariap1.pizzaria.validation.constraints.Telefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ClienteDTO extends AbstractEntityDTO {

    @Getter @Setter
    @NotNull(message = "{campo.cliente/funcionario-nome-NotNull}")
    @NotBlank(message = "{campo.cliente/funcionario-nome-NotBlank}")
    private String nome;

    @Getter @Setter
    @CPF(message = "{campo.cliente/funcionario-cpf-CPF}")
    private String cpf;

    @Getter @Setter
    @Telefone(message = "{campo.cliente/funcionario-telefone-Tell}")
    private String telefone;
}
