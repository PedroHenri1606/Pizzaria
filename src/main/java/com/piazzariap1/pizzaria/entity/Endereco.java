package com.piazzariap1.pizzaria.entity;


import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@Getter @Setter
@NoArgsConstructor
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

    public Endereco(Long id, String cep, String bairro, String logadouro, Integer numero, Cliente cliente) {
        super(id);
        this.cep = cep;
        this.bairro = bairro;
        this.logadouro = logadouro;
        this.numero = numero;
        this.cliente = cliente;
    }
}
