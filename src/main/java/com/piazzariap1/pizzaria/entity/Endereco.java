package com.piazzariap1.pizzaria.entity;


import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
public class Endereco extends AbstractEntity {

    @Getter @Setter
    @Column(name = "cep")
    private String cep;

    @Getter @Setter
    @Column(name = "bairro")
    private String bairro;

    @Getter @Setter
    @Column(name = "logadouro")
    private String logadouro;

    @Getter @Setter
    @Column(name = "numero")
    private String numero;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
