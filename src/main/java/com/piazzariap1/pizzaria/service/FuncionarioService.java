package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {

    /**@PostMapping
     *
     * Ao receber o objeto funcionario, deve ser efetuado as validações, e se for altorizado
     * ira persistir os dados no banco de dados
     *
     * @param funcionarioDTO novo funcionario
     * @return
     */
    Funcionario cadastrar(FuncionarioDTO funcionarioDTO);

    /**@GetMapping
     *
     * Ao receber o id, deve buscar no banco de dados o funcionario referente ao id
     *
     * @param id do cliente já existente
     * @return
     */
    Funcionario buscarPorId(Long id);

    /**@GetMapping
     *
     * Busca no banco de dados, todos os funcionarios já cadastrados
     *
     * @return
     */
    List<Funcionario> listar();

    /**@PutMapping
     *
     * Ao receber o id do funcionario, e as informações do funcionario a ser alterado, deve comparar os ids
     * e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do cliente já existente
     * @param funcionarioDTO objeto funcionario que fornece as novas informações do funcionario selecionado
     * @return
     */
    Funcionario editar(Long id, FuncionarioDTO funcionarioDTO);

    /**@DeleteMapping
     *
     * Ao receber o id do cliente, efetua a busca para verificar se o id é valido e em seguida, deleta o funcionario
     *
     * @param id utilizado para passar as informações do funcionario a ser editado
     */
    void delete(Long id);
}
