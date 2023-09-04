package com.piazzariap1.pizzaria.entity;

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
    @OneToMany(mappedBy = "produtoPedido")
    private Set<Sabor> sabor = new HashSet<>();

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
