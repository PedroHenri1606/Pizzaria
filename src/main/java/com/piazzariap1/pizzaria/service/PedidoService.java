package com.piazzariap1.pizzaria.service;


import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.entity.Pedido;

import java.util.List;

public interface PedidoService {

    /**@PostMapping
     *
     * Ao receber o objeto pedido, deve ser efetuado as validações, e se for altorizado
     * ira persistir os dados no banco de dados
     *
     * @param pedidoDTO novo pedido
     * @return
     */
    Pedido cadastrar(PedidoDTO pedidoDTO);

    /**@GetMapping
     *
     * Ao receber o id, deve buscar no banco de dados o pedido referente ao id
     *
     * @param id do pedido já existente
     * @return
     */
    Pedido buscarPorId(Long id);

    /**@GetMapping
     *
     * Busca no banco de dados, todos os pedidos já cadastrados
     *
     * @return
     */
    List<Pedido> listar();

    /**@PutMapping
     *
     * Ao receber o id do pedido, e as informações do pedido a ser alterado, deve comparar os ids
     * e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do pedido já existente
     * @param clienteDTO objeto pedido que fornece as novas informações do pedido selecionado
     * @return
     */
    Pedido editar(Long id, PedidoDTO clienteDTO);

}
