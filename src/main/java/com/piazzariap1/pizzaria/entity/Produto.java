package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@Getter @Setter
public class Produto extends AbstractEntity {

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Long valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho")
    private TamanhoProduto tamanho;
}
