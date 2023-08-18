package com.piazzariap1.pizzaria.entity;


import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Endereco extends AbstractEntity {

    @Getter @Setter
    @Column(name = "cep_endereco")
    private String cep;

    @Getter @Setter
    @Column(name = "bairro_endereco")
    private String bairro;

    @Getter @Setter
    @Column(name = "logadouro_endereco")
    private String logadouro;

    @Getter @Setter
    @Column(name = "numero_endereco")
    private String numero;

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "id_cliente_endereco")
    private Cliente idCliente;
}
