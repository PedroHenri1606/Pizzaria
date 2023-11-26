package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;



public record ProdutoDTO(Long id, Boolean ativo, String descricao, Long valor, TamanhoProduto tamanho)   {
}
