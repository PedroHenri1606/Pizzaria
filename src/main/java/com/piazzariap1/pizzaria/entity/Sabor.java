package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_sabor")
public class Sabor extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Getter @Setter
    @Column(name = "descricao")
    private String descricao;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoPedido produtoPedido;
}
