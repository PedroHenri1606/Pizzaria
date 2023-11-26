package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "{campo.produto-descricao.NotNull}")
    @NotBlank(message = "{campo.produto-descricao-NotBlak}")
    private String descricao;

    @Column(name = "valor")
    @Min(value = 1, message = "{campo.produto-valor-Min}")

    private Long valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho")
    @NotNull(message = "{campo.produto-tamanho-NotNull}")
    private TamanhoProduto tamanho;
}
