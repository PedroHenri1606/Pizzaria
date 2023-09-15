package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ProdutoPedidoDTO;
import com.piazzariap1.pizzaria.entity.ProdutoPedido;

import java.util.List;

public interface ProdutoPedidoService {

    /**
     * Ao receber o objeto produto, quantidade e sabores, deve ser efetuddo as validações
     * e se for altorizado, ira persistir os dados no banco de dados
     *
     * @param produtoPedidoDTO novo produto do pedido
     * @return produto cadastrado ao pedido
     */
    ProdutoPedido cadastrar(ProdutoPedidoDTO produtoPedidoDTO);

    /**
     * Ao receber o id, deve buscar no banco de dados o produtoPedido referente ao id
     *
     * @param id do produtoPedido já existente
     * @return produto cadastrado ao pedido
     */
    ProdutoPedido buscarPorId(Long id);

    /**
     * Busca no banco de dados, todos os produtosPedidos já cadastrados
     *
     * @return produto cadastrado ao pedido
     */
    List<ProdutoPedido> listar();

    /**

     * Ao receber o id do produtoPedido, e as informações do produtoPedido a ser alterado, deve comparar os ids
     * e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do produtoPedido já existente
     * @param produtoPedidoDTO objeto produtoPedido que fornece novas informações do produtoPedido selecionado
     * @return produto atualizado, podendo alterar a sua quantidade
     */
    ProdutoPedido editar(Long id, ProdutoPedidoDTO produtoPedidoDTO);

    /**
     * Ao receber o id do produto, efetua a busca para verificar se o id é valido e em seguida, deleta o produto
     *
     * @param id utilizado para passar as informações do produto a ser deletado
     */
    void delete(Long id);
}
