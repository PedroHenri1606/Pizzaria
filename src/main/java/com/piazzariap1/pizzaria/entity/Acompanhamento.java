package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_acompanhamento")
@Getter @Setter
public class Acompanhamento extends AbstractEntity {

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Long valor;

}
