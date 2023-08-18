package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import com.piazzariap1.pizzaria.entity.enuns.tamanhoProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Descrição do produto informado é um campo obrigatorio!")
    @NotBlank(message = "Descrição do produto informado não pode ser vazio!")
    private String descricao;

    @Getter @Setter
    @NotNull(message = "Tamanho do produto informado é um campo obrigatorio!")
    @NotBlank(message = "Tamanho do produto informado não pode ser vazio!")
    @Column(name = "tamanho_produto")
    private tamanhoProduto tamanho;

    @Getter @Setter
    @NotNull(message = "Valor do produto informado é um campo obrigatorio!")
    @NotBlank(message = "Valor do produto informado não pode ser vazio!")
    @Column(name = "valor_produto")
    private Long valor;
}
