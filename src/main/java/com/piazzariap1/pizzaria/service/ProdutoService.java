package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.entity.Produto;

import java.util.List;

public interface ProdutoService {


    /**@PostMapping
     *
     * Ao receber o objeto produto, deve ser efetuado as validações, e se for altorizado
     * deve persistir os dados no banco de dados, apos a persistencia
     * ser possivel cadastrar um produtoPedido
     *
     *
     * @param produtoDTO novo produto
     * @return
     */
    Produto cadastrar(ProdutoDTO produtoDTO);


    /**@GetMapping
     *
     * Ao receber o id, deve buscar no banco de dados o produto referente ao id
     *
     * @param id do produto já existente
     * @return
     */
    Produto buscarPorId(Long id);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os produtos que possuem a mesma descrição
     *
     * @param descricao do produtos já existente
     * @return
     */
    List<Produto> buscarPorDescricao(String descricao);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os produtos que possuem o valor enviado
     *
     * @param valor do produtos já existente
     * @return
     */
    List<Produto> buscarPorValor(Long valor);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os produtos que começam pela string enviada
     *
     * @param descricao do produtos já existente
     * @return
     */
    List<Produto> buscarProdutoComecandoCom(String descricao);


    /**@GetMapping
     *
     *Busca no banco de dados, todos os produtos que terminam pela string enviada
     *
     * @param descricao do produtos já existente
     * @return
     */
    List<Produto> buscarProdutoTerminandoCom(String descricao);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os produtos que contenha a string enviada
     *
     * @param descricao do produtos já existente
     * @return
     */
    List<Produto> buscarProdutoQueContenha(String descricao);


    /**@GetMapping
     *
     * Busca no banco de dados, todos os produtos já cadastrados
     *
     * @return
     */
    List<Produto> listar();


    /**@PutMapping
     *
     * Ao receber o id do produto e as informações do produto a ser editado, deve comparar
     * os dois ids e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do produto já existente
     * @param produtoDTO objeto produto que fornecera as novas informações do produto selecionado
     * @return
     */
    Produto editar(Long id, ProdutoDTO produtoDTO);


    /**@DeleteMapping
     *
     * Ao receber o id do produto, efetua a busca para verificar se o id é valido, e em seguida, deleta o produto
     *
     * @param id utilizado para passar as informações do produto a ser deletado
     */
    void delete(Long id);
}
