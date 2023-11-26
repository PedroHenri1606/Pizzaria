package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.Acompanhamento;

public record AcompanhamentoPedidoDTO(Long id, Acompanhamento acompanhamento, Integer quantidade, String observacao) {
}
