package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Quantidade do produto informado é um campo obrigatorio!")
    @NotBlank(message = "Quantidade do produto informado não pode ser vazio!")
    @Column(name = "quantidade_item")
    private Integer quantidade;

    @ManyToMany
    @JoinTable(
            name = "item_sabores",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_sabor")
    )
    @Getter @Setter
    @NotNull(message = "Sabor do produto informado é um campo obrigatorio!")
    @NotBlank(message = "Sabor do produto informado não pode ser vazio!")
    private Set<Sabor> sabor = new HashSet<>();
}
