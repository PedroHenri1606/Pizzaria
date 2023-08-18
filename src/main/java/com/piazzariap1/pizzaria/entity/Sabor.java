package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_sabor", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Sabor extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome_sabor")
    private String nome;

    @Getter @Setter
    @Column(name = "descricao_sabor")
    private String descricao;
}
