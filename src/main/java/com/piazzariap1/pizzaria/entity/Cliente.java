package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_cliente", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome_cliente")
    private String nome;

    @Getter @Setter
    @Column(name = "cpf_cliente")
    private String cpf;

    @Getter @Setter
    @Column(name = "telefone_cliente")
    private String telefone;
}
