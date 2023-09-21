package com.piazzariap1.pizzaria.test;

import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {


    /**
     * Ao receber o objeto funcionario, deve ser efetuado as validações, e se for altorizado
     * ira persistir os dados no banco de dados
     *
     * @param funcionarioDTO novo funcionario
     * @return funcionario cadastrado no banco de dados
     */
    Funcionario cadastrar(FuncionarioDTO funcionarioDTO);


    /**
     * Ao receber o id, deve buscar no banco de dados o funcionario referente ao id
     *
     * @param id do funcionario já existente
     * @return funcionario cadastrado no banco de dados
     */
    Funcionario buscarPorId(Long id);


    /**
     * Busca no banco de dados, todos os clientes que possuem a mesmo id
     *
     * @param nome do funcionario já existente
     * @return funcionario cadastrado no banco de dados
     */
    List<Funcionario> buscarPorNome(String nome);


    /**
     * Busca no banco de dados, o cliente que possue o cpf enviado
     *
     * @param cpf do funcionario já existente
     * @return funcionario cadastrado no banco de dados
     */
    List<Funcionario> buscarPorCpf(String cpf);


    /**
     * Busca no banco de dados, todos os funcionarios que começam pelo nome enviada
     *
     * @param nome do funcionario já existente
     * @return funcionario cadastrado no banco de dados
     */
    List<Funcionario> buscarFuncionarioComecandoCom(String nome);


    /**
     *Busca no banco de dados, todos os funcionarios que terminam pelo nome enviada
     *
     * @param nome do funcionario já existente
     * @return funcionario cadastrado no banco de dados
     */
    List<Funcionario> buscarFuncionarioTerminandoCom(String nome);


    /**
     * Busca no banco de dados, todos os funcionarios que contenha o nome enviada
     *
     * @param nome do funcionario já existente
     * @return funcionario cadastrado no banco de dados
     */
    List<Funcionario> buscarFuncionarioQueContenha(String nome);


    /**
     * Busca no banco de dados, todos os funcionarios já cadastrados
     *
     * @return todos os funcionarios cadastrados no banco de dados
     */
    List<Funcionario> listar();


    /**
     * Ao receber o id do funcionario, e as informações do funcionario a ser alterado, deve comparar os ids
     * e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do cliente já existente
     * @param funcionarioDTO objeto funcionario que fornece as novas informações do funcionario selecionado
     * @return funcionario atualizado, podendo alterar nome e telefone
     */
    Funcionario editar(Long id, FuncionarioDTO funcionarioDTO);


    /**
     * Ao receber o id do cliente, efetua a busca para verificar se o id é valido e em seguida, deleta o funcionario
     *
     * @param id utilizado para passar as informações do funcionario a ser editado
     */
    void delete(Long id);
}
