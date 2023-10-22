package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_produto")
@Getter @Setter
@NoArgsConstructor

public class Produto   {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Long valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho")
    private TamanhoProduto tamanho;
}
