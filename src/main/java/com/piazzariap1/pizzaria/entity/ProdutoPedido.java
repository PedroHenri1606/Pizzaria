package com.piazzariap1.pizzaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_produto_pedido")
@Getter @Setter
@NoArgsConstructor
public class ProdutoPedido{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "observacao")
    private String observacao;

    @ManyToMany
    @JoinTable(
            name = "tb_sabor_produto",
            joinColumns = @JoinColumn(name = "produto_pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "sabor_id")
    )
    private Set<Sabor> sabores = new HashSet<>();
}
