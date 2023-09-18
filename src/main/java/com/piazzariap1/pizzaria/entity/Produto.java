package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto extends AbstractEntity {

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Long valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho")
    private TamanhoProduto tamanho;
}
