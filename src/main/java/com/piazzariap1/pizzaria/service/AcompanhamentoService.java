package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;

import java.util.List;

public interface AcompanhamentoService {


    /**@PostMapping
     *
     * Ao receber o objeto acompanhamento, sera efetuado as validações e se for altorizado
     * ira persistir os dados no banco de dados apos a persistencia,
     * sera possivel cadastrar um AcompanhamentoPedido
     *
     * @param acompanhamento novo acompanhamento
     * @return
     */
    Acompanhamento cadastrar(AcompanhamentoDTO acompanhamento);


    /**@GetMapping
     *
     * Ao receber o id, deve buscar no banco de dados o acompanhamento referente ao id
     *
     * @param id do acompanhamento já existente
     * @return
     */
    Acompanhamento buscarPorId(Long id);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os acompanhamentos que possuem a mesma descrição
     *
     * @param descricao do acompanhamento já existente
     * @return
     */
    List<Acompanhamento> buscarPorDescricao(String descricao);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os acompanhamentos que possuem o valor enviado
     *
     * @param valor do acompanhamento já existente
     * @return
     */
    List<Acompanhamento> buscarPorValor(Long valor);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os acompanhamentos que começam pela string enviada
     *
     * @param descricao do acompanhamento já existente
     * @return
     */
    List<Acompanhamento> buscarAcompanhamentoComecandoCom(String descricao);


    /**@GetMapping
     *
     *Busca no banco de dados, todos os acompanhamentos que terminam pela string enviada
     *
     * @param descricao do acompanhamento já existente
     * @return
     */
    List<Acompanhamento> buscarAcompanhamentoTerminandoCom(String descricao);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os acompanhamentos que contenha a string enviada
     *
     * @param descricao do acompanhamento já existente
     * @return
     */
    List<Acompanhamento> buscarAcompanhamentoQueContenha(String descricao);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os acompanhamentos já cadastrados
     *
     * @return
     */
    List<Acompanhamento> listar();


    /**@PutMapping
     *
     * Ao receber o id do acompanhamento e as informações do acompanhamento a ser editado, deve comparar
     * os ids e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do acompanhamento já existente
     * @param acompanhamento objeto acompanhamento que fornecera as novas informações do acompanhamento solucionado
     * @return
     */
    Acompanhamento editar(Long id, AcompanhamentoDTO acompanhamento);


    /**@DeleteMapping
     *
     * Ao receber o id do acompanhamento, efetua a busca para verificar se o id é valido e em seguida, deleta o acompanhamento
     *
     * @param id utilizado para passar as informações do acompanhamento a ser deletado
     */
    void delete(Long id);
}
