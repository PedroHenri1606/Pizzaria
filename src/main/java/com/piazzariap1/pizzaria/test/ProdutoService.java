package com.piazzariap1.pizzaria.test;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Produto;

import java.util.List;

public interface ProdutoService {


    /**
     * Ao receber o objeto produto, deve ser efetuado as validações, e se for altorizado
     * deve persistir os dados no banco de dados, apos a persistencia
     * ser possivel cadastrar um produtoPedido
     *
     *
     * @param produtoDTO novo produto
     * @return produto cadastrado no banco de dados
     */
    Produto cadastrar(ProdutoDTO produtoDTO);


    /**
     * Ao receber o id, deve buscar no banco de dados o produto referente ao id
     *
     * @param id do produto já existente
     * @return produto cadastrado no banco de dados
     */
    Produto buscarPorId(Long id);


    /**
     * Busca no banco de dados, todos os produtos que possuem a mesma descrição
     *
     * @param descricao do produto já existente
     * @return produto cadastrado no banco de dados
     */
    List<Produto> buscarPorDescricao(String descricao);


    /**
     * Busca no banco de dados, todos os produtos que possuem o valor enviado
     *
     * @param valor do produto já existente
     * @return produto cadastrado no banco de dados
     */
    List<Produto> buscarPorValor(Long valor);


    /**
     * Busca no banco de dados, todos os produtos que começam pela string enviada
     *
     * @param descricao do produto já existente
     * @return produto cadastrado no banco de dados
     */
    List<Produto> buscarProdutoComecandoCom(String descricao);


    /**
     *Busca no banco de dados, todos os produtos que terminam pela string enviada
     *
     * @param descricao do produto já existente
     * @return produto cadastrado no banco de dados
     */
    List<Produto> buscarProdutoTerminandoCom(String descricao);


    /**
     * Busca no banco de dados, todos os produtos que contenha a string enviada
     *
     * @param descricao do produto já existente
     * @return produto cadastrado no banco de dados
     */
    List<Produto> buscarProdutoQueContenha(String descricao);


    /**
     * Busca no banco de dados, todos os produtos já cadastrados
     *
     * @return todos os produtos cadastrados no banco de dados
     */
    List<Produto> listar();


    /**
     * Ao receber o id do produto e as informações do produto a ser editado, deve comparar
     * os dois ids e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do produto já existente
     * @param produtoDTO objeto produto que fornecera as novas informações do produto selecionado
     * @return produto atualizado, podendo alterar descrição e o valor
     */
    Produto editar(Long id, ProdutoDTO produtoDTO);


    /**
     * Ao receber o id do produto, efetua a busca para verificar se o id é valido, e em seguida, deleta o produto
     *
     * @param id utilizado para passar as informações do produto a ser deletado
     */
    void delete(Long id);
}
