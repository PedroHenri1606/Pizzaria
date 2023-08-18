package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_acompanhamento", schema = "public")
public class Acompanhamento extends AbstractEntity {

    @Getter @Setter
    @NotNull(message = "Descrição do acompanhamento é um campo obrigatorio!")
    @NotBlank(message = "Descrição do acompanhamento não pode ser vazia!")
    @Column(name = "descricao_produto")
    private String descricao;

    @Getter @Setter
    @NotNull(message = "Valor do acompanhamento é um campo obrigatorio!")
    @NotBlank(message = "Valor do acompanhamento não pode ser vazia!")
    @Column(name = "valor_acompanhamento")
    private Long valor;

}
