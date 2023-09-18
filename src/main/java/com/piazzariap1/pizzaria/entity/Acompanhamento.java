package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_acompanhamento")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Acompanhamento extends AbstractEntity {

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Long valor;
}
