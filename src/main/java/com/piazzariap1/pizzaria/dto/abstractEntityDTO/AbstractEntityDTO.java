package com.piazzariap1.pizzaria.dto.abstractEntityDTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public abstract class AbstractEntityDTO {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private LocalDateTime cadastro;

    @Getter @Setter
    private LocalDateTime edicao;

    @Getter @Setter
    private boolean ativo;
}
