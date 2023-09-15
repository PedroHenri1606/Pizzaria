package com.piazzariap1.pizzaria.entity;


import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@Getter @Setter
public class Endereco extends AbstractEntity {

    @Column(name = "cep")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "logadouro")
    private String logadouro;

    @Column(name = "numero")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
