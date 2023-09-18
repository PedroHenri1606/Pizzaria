package com.piazzariap1.pizzaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_sabor")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sabor extends AbstractEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToMany(mappedBy = "sabores")
    @JsonIgnore
    private Set<ProdutoPedido> produtosPedidos;
}
