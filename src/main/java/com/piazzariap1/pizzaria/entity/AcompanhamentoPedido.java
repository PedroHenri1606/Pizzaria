package com.piazzariap1.pizzaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_acompanhamento_pedido")
public class AcompanhamentoPedido extends AbstractEntity {

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "acompanhamento_id")
    private Acompanhamento acompanhamento;

    @Getter @Setter
    @Column(name = "quantidade")
    private Integer quantidade;

    @JsonIgnore
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
