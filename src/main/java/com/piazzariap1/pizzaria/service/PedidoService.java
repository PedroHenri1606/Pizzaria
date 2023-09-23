package com.piazzariap1.pizzaria.service;


import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.entity.Pedido;

import java.util.List;

public interface PedidoService {

    /**
     * Ao receber o objeto pedido, deve ser efetuado as validações, e se for altorizado
     * ira persistir os dados no banco de dados
     *
     * @param pedidoDTO novo pedido
     * @return pedido cadastrado no banco de dados
     */
    Pedido cadastrar(PedidoDTO pedidoDTO);

    /**
     * Ao receber o id, deve buscar no banco de dados o pedido referente ao id
     *
     * @param id do pedido já existente
     * @return pedido cadastrado no banco de dados
     */
    Pedido buscarPorId(Long id);

    /**
     * Busca no banco de dados, todos os pedidos já cadastrados
     *
     * @return todos os pedidos cadastrados no banco de dados
     */
    List<Pedido> listar();

    /**
     * Ao receber o id do pedido, e as informações do pedido a ser alterado, deve comparar os ids
     * e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do pedido já existente
     * @param clienteDTO objeto pedido que fornece as novas informações do pedido selecionado
     * @return pedido atualizado, podendo alterar os itens, acompanhamentos, a entrega, as observações e a forma de pagamento
     */
    Pedido editar(Long id, PedidoDTO clienteDTO);

}
