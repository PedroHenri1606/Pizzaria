package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.validation.constraints.CEP;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class EnderecoDTO extends AbstractEntityDTO {

    @Getter @Setter
    @CEP(message = "{campo.endereco-cep-CEP}")
    private String cep;

    @Getter @Setter
    @NotNull(message = "{campo.endereco-bairro-NotNull}")
    @NotBlank(message = "{campo.endereco-bairro-NotBlank}")
    private String bairro;

    @Getter @Setter
    @NotNull(message = "{campo.endereco-logadouro-NotNull}")
    @NotBlank(message = "{campo.endereco-logadouro-NotBlank}")
    private String logadouro;

    @Getter @Setter
    @Min(value = 1,message = "{campo.endereço-numero-Min}")
    private Integer numero;

    @Getter @Setter
    @NotNull(message = "{campo.endereço-cliente-NotNull}")
    private Cliente cliente;
}
