package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.entity.Sabor;

import java.util.Set;


public record ProdutoPedidoDTO(Long id, Produto produto, Integer quntidade, String observacao,Set<Sabor> sabores)   {
}