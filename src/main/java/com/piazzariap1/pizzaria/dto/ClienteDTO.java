package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractentitydto.AbstractEntityDTO;
import com.piazzariap1.pizzaria.validation.constraints.CPF;
import com.piazzariap1.pizzaria.validation.constraints.Telefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteDTO extends AbstractEntityDTO {

    @NotNull(message = "{campo.cliente/funcionario-nome-NotNull}")
    @NotBlank(message = "{campo.cliente/funcionario-nome-NotBlank}")
    private String nome;

    @CPF(message = "{campo.cliente/funcionario-cpf-CPF}")
    private String cpf;

    @Telefone(message = "{campo.cliente/funcionario-telefone-Tell}")
    private String telefone;

    public ClienteDTO(Long id, String nome, String cpf, String telefone) {
        super(id);
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
