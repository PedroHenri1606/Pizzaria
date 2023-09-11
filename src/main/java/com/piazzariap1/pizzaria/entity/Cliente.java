package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
public class Cliente extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome")
    private String nome;

    @Getter @Setter
    @Column(name = "cpf")
    private String cpf;

    @Getter @Setter
    @Column(name = "telefone")
    private String telefone;

}
