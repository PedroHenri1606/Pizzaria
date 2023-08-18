package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_itemPedido", schema = "public")
public class ItemPedido extends AbstractEntity {

    @Getter @Setter
    @ManyToOne
    private Produto idProduto;

    @Getter @Setter
    @Column(name = "quantidade_item")
    private Integer quantidade;

    @ManyToMany
    @JoinTable(
            name = "item_sabores",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_sabor")
    )
    @Getter @Setter
    private Set<Sabor> sabor = new HashSet<>();
}
