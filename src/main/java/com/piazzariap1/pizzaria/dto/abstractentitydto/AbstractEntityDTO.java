package com.piazzariap1.pizzaria.dto.abstractentitydto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public abstract class AbstractEntityDTO {

    private Long id;

    private LocalDateTime cadastro;

    private LocalDateTime edicao;

    private boolean ativo;

    protected AbstractEntityDTO(Long id) {
        this.id = id;
    }
}
