package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_acompanhamento")
@Getter @Setter
@NoArgsConstructor
public class Acompanhamento extends AbstractEntity {

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Long valor;

    public Acompanhamento(Long id, String descricao, Long valor) {
        super(id);
        this.descricao = descricao;
        this.valor = valor;
    }
}
