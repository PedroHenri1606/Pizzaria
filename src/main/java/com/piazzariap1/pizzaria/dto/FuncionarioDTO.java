package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.validation.constraints.CPF;
import com.piazzariap1.pizzaria.validation.constraints.Telefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FuncionarioDTO   {

    private Long id;

    private boolean ativo;

    @NotNull(message = "{campo.cliente/funcionario-nome-NotNull}")
    @NotBlank(message = "{campo.cliente/funcionario-nome-NotBlank}")
    private String nome;

    @CPF(message = "{campo.cliente/funcionario-cpf-CPF}")
    private String cpf;

    @Telefone(message = "{campo.cliente/funcionario-telefone-Tell}")
    private String telefone;

}
