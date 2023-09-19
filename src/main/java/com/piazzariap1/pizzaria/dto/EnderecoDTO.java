package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.dto.abstractentitydto.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.validation.constraints.CEP;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnderecoDTO extends AbstractEntityDTO {

    @CEP(message = "{campo.endereco-cep-CEP}")
    private String cep;

    @NotNull(message = "{campo.endereco-bairro-NotNull}")
    @NotBlank(message = "{campo.endereco-bairro-NotBlank}")
    private String bairro;

    @NotNull(message = "{campo.endereco-logadouro-NotNull}")
    @NotBlank(message = "{campo.endereco-logadouro-NotBlank}")
    private String logadouro;

    @Min(value = 1,message = "{campo.endereço-numero-Min}")
    private Integer numero;

    @NotNull(message = "{campo.endereço-cliente-NotNull}")
    private Cliente cliente;

    public EnderecoDTO(Long id, String cep, String bairro, String logadouro, Integer numero, Cliente cliente) {
        super(id);
        this.cep = cep;
        this.bairro = bairro;
        this.logadouro = logadouro;
        this.numero = numero;
        this.cliente = cliente;
    }
}
