package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;

import java.util.HashSet;
import java.util.Set;

public record PedidoDTO(Long id,
                        Cliente cliente,
                        Set<ProdutoPedido> item,
                        Set<Acompanhamento> acompanhamentos,
                        Endereco enderecoEntrega,
                        Funcionario funcionario,
                        String observacao,
                        Boolean entregar,
                        Boolean pago,
                        SituacaoPedido situacaoPedido,
                        FormaDePagamento formaDePagamento,
                        Long valorTotal)   {

}
