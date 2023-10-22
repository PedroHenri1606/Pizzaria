package com.piazzariap1.pizzaria.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@Getter @Setter
@NoArgsConstructor
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "logadouro")
    private String logadouro;

    @Column(name = "numero")
    private Integer numero;
}
