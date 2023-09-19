package com.piazzariap1.pizzaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_produto_pedido")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoPedido extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToMany
    @JoinTable(
            name = "tb_sabor_produto",
            joinColumns = @JoinColumn(name = "produto_pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "sabor_id")
    )
    private Set<Sabor> sabores = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public ProdutoPedido(Long id, Produto produto, Integer quantidade, Set<Sabor> sabores, Pedido pedido) {
        super(id);
        this.produto = produto;
        this.quantidade = quantidade;
        this.sabores = sabores;
        this.pedido = pedido;
    }
}
