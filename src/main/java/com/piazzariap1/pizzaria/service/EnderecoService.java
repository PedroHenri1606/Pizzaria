package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.EnderecoDTO;
import com.piazzariap1.pizzaria.entity.Endereco;

import java.util.List;

public interface EnderecoService {

    /**
     * Ao receber o objeto endereço, sera efetuado as validações, e se for altorizado
     * ira persistir os dados no banco de dados
     *
     * @param enderecoDTO novo endereço
     * @return endereço cadastrado no banco de dados
     */
    Endereco cadastrar(EnderecoDTO enderecoDTO);

    /**
     * Ao receber o id, deve buscar no banco de dados o endereco referente ao id
     *
     * @param id do endereco já existente
     * @return endereço cadastrado no banco de dados
     */
    Endereco buscarPorId(Long id);

    /**
     * Busca no banco de dados, todos os endereços já cadastrados
     *
     * @return todos os endereço cadastrados no banco de dados
     */
    List<Endereco> listar();

    /**
     * Ao receber o id do endereço, e as informações do endereço a ser alterado, deve comparar os ids e se forem iguais
     * deve persistir os dados atualizados
     *
     * @param id do endereço já existente
     * @param enderecoDTO objeto endereço que fornecera as novas informações do cliente selecionado
     * @return endereço atualizado, podendo alterar numero, bairro, logadouro e cep
     */
    Endereco editar(Long id, EnderecoDTO enderecoDTO);

    /**
     * Ao receber o id do endereço, efetua a busca para verificar se o id é valido e em seguida, deleta o endereço
     *
     * @param id utilizado para passar as informações do enderçeo a ser deletado
     */
    void delete(Long id);
}
