package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.AcompanhamentoPedidoDTO;
import com.piazzariap1.pizzaria.entity.AcompanhamentoPedido;

import java.util.List;

public interface AcompanhamentoPedidoService {


    /** @PostMapping
     *
     *  Ao receber o objeto acompanhamento, e quantidade, sera efetuado as validações e se for altoriazdo
     *  ira persistir no banco de dados
     *
     *  @param acompanhamentoPedidoDTO novo acompanhamnto no pedido
     *  @return
     */
    AcompanhamentoPedido cadastrar(AcompanhamentoPedidoDTO acompanhamentoPedidoDTO);

    /**@GetMapping
     *
     * Ao receber o id, deve buscar no banco de dados o acompanhamento referente ao pedido
     *
     * @param id do acompanhamento do pedido já existente
     * @return
     */
    AcompanhamentoPedido buscarPorId(Long id);

    /**@GetMapping
     *
     * Busca no banco de dados, todos os acompanhamentos separado por pedidos
     *
     * @return
     */
    List<AcompanhamentoPedido> listar();

    /**@PutMapping
     *
     * Ao receber o id, e as informações do acompanhamentoPedido a ser editada, deve comparar os ids e se forem iguais
     * deve persisistir os dados atualizados
     *
     * @param id do acompanhamento já existente
     * @param acompanhamentoPedidoNovo objeto acompanhamentoPedido que fornecera as novas informações do acompanhamento
     * @return
     */
    AcompanhamentoPedido editar(Long id, AcompanhamentoPedidoDTO acompanhamentoPedidoNovo);

    /**@DeleteMapping
     *
     * Ao receber o id do acompanhamentoPedido, efetua a busca para verificar se o id é valido e em seguida,
     * deleta o acompnhamentoPedido
     *
     * @param id utilizado para passar o id do acompanhamento a ser deletado
     */
    void delete(Long id);
}
