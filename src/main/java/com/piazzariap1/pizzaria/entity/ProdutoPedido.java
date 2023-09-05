package com.piazzariap1.pizzaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_produto_pedido")
public class ProdutoPedido extends AbstractEntity {

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Getter @Setter
    @Column(name = "quantidade")
    private Integer quantidade;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "tb_sabor_produto",
            joinColumns = @JoinColumn(name = "produto_pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "sabor_id")
    )
    private Set<Sabor> sabores = new HashSet<>();

    @JsonIgnore
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
