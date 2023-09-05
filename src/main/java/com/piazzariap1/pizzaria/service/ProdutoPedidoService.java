package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ProdutoPedidoDTO;
import com.piazzariap1.pizzaria.entity.ProdutoPedido;

import java.util.List;

public interface ProdutoPedidoService {

    /**@PostMapping
     *
     * Ao receber o objeto produto, quantidade e sabores, deve ser efetuddo as validações
     * e se for altorizado, ira persistir os dados no banco de dados
     *
     * @param produtoPedidoDTO novo produto do pedido
     * @return
     */
    ProdutoPedido cadastrar(ProdutoPedidoDTO produtoPedidoDTO);

    /**@GetMapping
     *
     * Ao receber o id, deve buscar no banco de dados o produtoPedido referente ao id
     *
     * @param id do produtoPedido já existente
     * @return
     */
    ProdutoPedido buscarPorId(Long id);

    /**@GetMapping
     *
     * Busca no banco de dados, todos os produtosPedidos já cadastrados
     *
     * @return
     */
    List<ProdutoPedido> listar();

    /**@PutMapping
     *
     * Ao receber o id do produtoPedido, e as informações do produtoPedido a ser alterado, deve comparar os ids
     * e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do produtoPedido já existente
     * @param produtoPedidoDTO objeto produtoPedido que fornece novas informações do produtoPedido selecionado
     * @return
     */
    ProdutoPedido editar(Long id, ProdutoPedidoDTO produtoPedidoDTO);

    void delete(Long id);
}
