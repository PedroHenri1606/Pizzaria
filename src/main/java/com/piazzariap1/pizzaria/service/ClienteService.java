package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;

import java.util.List;

public interface ClienteService {

    /**@PostMapping
     *
     * Ao receber o objeto cliente, sera efetuado as validações, e se for altorizado
     * ira persistir os dados no banco de dados
     *
     * @param clienteDTO novo cliente
     * @return
     */
    Cliente cadastrar(ClienteDTO clienteDTO);

    /**@GetMapping
     *
     * Ao receber o id, deve buscar no banco de dados o cliente referente ao id
     *
     * @param id do cliente já existente
     * @return
     */
    Cliente buscarPorId(Long id);

    /**@GetMapping
     *
     * Busca no banco de dados, todos os clientes já cadastrados
     *
     * @return
     */
    List<Cliente> listar();


    /**@PutMapping
     *
     * Ao receber o id do cliente, e as informações do cliente a ser alterado, deve comparar os ids e se forem iguais
     * deve persistir as dados atualizados
     *
     * @param id do cliente já existente
     * @param clienteDTO objeto cliente que fornecera as novas informações do cliente selecionado
     * @return
     */
    Cliente editar(Long id, ClienteDTO clienteDTO);

    /**@DeleteMapping
     *
     * Ao receber o id do cliente, efetua a busca para verificar se o id é valido e em seguida, deleta o cliente
     *
     * @param id utilizado para passar as informações do cliente a ser deletado
     */
    void delete(Long id);
}
