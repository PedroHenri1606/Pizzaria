package com.piazzariap1.pizzaria.entity;


import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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
