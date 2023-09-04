package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_acompanhamento")
public class Acompanhamento extends AbstractEntity {

    @Getter @Setter
    @Column(name = "descricao")
    private String descricao;

    @Getter @Setter
    @Column(name = "valor")
    private Long valor;

}
