package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany(mappedBy = "sabores")
    private Set<ProdutoPedido> produtosPedidos;
}
