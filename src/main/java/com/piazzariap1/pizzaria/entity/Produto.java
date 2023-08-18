package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import com.piazzariap1.pizzaria.entity.enuns.tamanhoProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_produto", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Produto extends AbstractEntity {

    @Getter @Setter
    @Column(name = "descricao_produto")
    private String descricao;

    @Getter @Setter
    @Column(name = "tamanho_produto")
    private tamanhoProduto tamanho;

    @Getter @Setter
    @Column(name = "valor_produto")
    private Long valor;
}
