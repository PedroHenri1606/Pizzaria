package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends AbstractEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    public Cliente(Long id, String nome, String cpf, String telefone) {
        super(id);
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
