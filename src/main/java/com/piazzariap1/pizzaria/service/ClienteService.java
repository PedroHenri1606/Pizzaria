package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;

import java.util.List;

public interface ClienteService {


    /**
     * Ao receber o objeto cliente, sera efetuado as validações, e se for altorizado
     * ira persistir os dados no banco de dados
     *
     * @param clienteDTO novo cliente
     * @return cliente cadastrado no banco de dados
     */
    Cliente cadastrar(ClienteDTO clienteDTO);


    /**
     * Ao receber o id, deve buscar no banco de dados o cliente referente ao id
     *
     * @param id do cliente já existente
     * @return cliente cadastrado no banco de dados
     */
    Cliente buscarPorId(Long id);

    /**
     * Busca no banco de dados, todos os clientes que possuem a mesmo id
     *
     * @param nome do clientes já existente
     * @return cliente cadastrado no banco de dados
     */
    List<Cliente> buscarPorNome(String nome);


    /**
     * Busca no banco de dados, o cliente que possue o cpf enviado
     *
     * @param cpf do cliente já existente
     * @return cliente cadastrado no banco de dados
     */
    List<Cliente> buscarPorCpf(String cpf);


    /**
     * Busca no banco de dados, todos os clientes que começam pelo nome enviada
     *
     * @param nome do cliente já existente
     * @return cliente cadastrado no banco de dados
     */
    List<Cliente> buscarClienteComecandoCom(String nome);


    /**
     *Busca no banco de dados, todos os clientes que terminam pelo nome enviada
     *
     * @param nome do cliente já existente
     * @return cliente cadastrado no banco de dados
     */
    List<Cliente> buscarClienteTerminandoCom(String nome);


    /**
     * Busca no banco de dados, todos os clientes que contenha o nome enviada
     *
     * @param nome do cliente já existente
     * @return cliente cadastrado no banco de dados
     */
    List<Cliente> buscarClienteQueContenha(String nome);

    /**
     * Busca no banco de dados, todos os clientes já cadastrados
     *
     * @return todos os clientes cadastrados no banco de dados
     */
    List<Cliente> listar();


    /**
     * Ao receber o id do cliente, e as informações do cliente a ser alterado, deve comparar os ids e se forem iguais
     * deve persistir as dados atualizados
     *
     * @param id do cliente já existente
     * @param clienteDTO objeto cliente que fornecera as novas informações do cliente selecionado
     * @return cliente atualizado, podendo alterar nome, telefone
     */
    Cliente editar(Long id, ClienteDTO clienteDTO);


    /**
     * Ao receber o id do cliente, efetua a busca para verificar se o id é valido e em seguida, deleta o cliente
     *
     * @param id utilizado para passar as informações do cliente a ser deletado
     */
    void delete(Long id);
}
