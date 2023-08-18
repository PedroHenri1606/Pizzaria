package com.piazzariap1.pizzaria.dto;


import com.piazzariap1.pizzaria.dto.abstractEntityDTO.AbstractEntityDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import lombok.Getter;
import lombok.Setter;

public class EnderecoDTO extends AbstractEntityDTO {

    @Getter @Setter
    private String cep;

    @Getter @Setter
    private String bairro;

    @Getter @Setter
    private String logadouro;

    @Getter @Setter
    private String numero;

    @Getter @Setter
    private Cliente clienteId;
}
