package com.piazzariap1.pizzaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piazzariap1.pizzaria.entity.abstractentity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_acompanhamento_pedido")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcompanhamentoPedido extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name = "acompanhamento_id")
    private Acompanhamento acompanhamento;

    @Column(name = "quantidade")
    private Integer quantidade;

    @JsonIgnore
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
