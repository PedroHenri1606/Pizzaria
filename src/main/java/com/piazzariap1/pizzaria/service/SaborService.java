package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.SaborDTO;
import com.piazzariap1.pizzaria.entity.Sabor;

import java.util.List;

public interface SaborService {


    /**
     * Ao receber o objeto sabor, deve ser efetuado as validações, e se for altorizado
     * deve persistir os dados no banco de dados
     *
     * @param saborDTO novo sabor
     * @return sabor cadastrado no banco de dados
     */
    Sabor cadastrar(SaborDTO saborDTO);


    /**
     * Ao receber o id, deve buscar no banco de dados o sabor referente ao id
     *
     * @param id do sabor já existente
     * @return sabor cadastrado no banco de dados
     */
    Sabor buscarPorId(Long id);

    /**
     * Busca no banco de dados, todos os sabores que possuem a mesmo id
     *
     * @param nome do sabor já existente
     * @return sabor cadastrado no banco de dados
     */
    List<Sabor> buscarPorNome(String nome);


    /**
     * Busca no banco de dados, todos os sabores que começam pelo nome enviada
     *
     * @param nome do sabor já existente
     * @return sabor cadastrado no banco de dados
     */
    List<Sabor> buscarSaborComecandoCom(String nome);


    /**
     *Busca no banco de dados, todos os sabores que terminam pelo nome enviada
     *
     * @param nome do sabor já existente
     * @return sabor cadastrado no banco de dados
     */
    List<Sabor> buscarSaborTerminandoCom(String nome);


    /**
     * Busca no banco de dados, todos os sabores que contenha o nome enviada
     *
     * @param nome do sabor já existente
     * @return sabor cadastrado no banco de dados
     */
    List<Sabor> buscarSaborQueContenha(String nome);


    /**
     * Busca no banco de dados, todos os sabores já cadastrados
     *
     * @return todos os sabores cadastrados no banco de dados
     */
    List<Sabor> listar();


    /**
     * Ao receber o id do sabor e as informações do sabor a ser editado, deve comparar
     * os dois ids e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do sabor já existente
     * @param saborDTO objeto sabor que fornecera as novas informações do sabor selecionado
     * @return sabor atualizado, podendo alterar nome e a descrição
     */
    Sabor editar(Long id, SaborDTO saborDTO);


    /**
     * Ao receber o id do sabor, efetua a busca para verificar se o id é valido, e em seguida, deleta o sabor
     *
     * @param id utilizado para passar as informações do sabor a ser deletado
     */
    void delete(Long id);
}
