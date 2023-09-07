package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
public class Produto extends AbstractEntity {

    @Getter @Setter
    @Column(name = "descricao")
    private String descricao;

    @Getter @Setter
    @Column(name = "valor")
    private Long valor;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho")
    private TamanhoProduto tamanho;
}
