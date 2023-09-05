package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.SaborDTO;
import com.piazzariap1.pizzaria.entity.Sabor;

import java.util.List;

public interface SaborService {

    /**@PostMapping
     *
     * Ao receber o objeto sabor, deve ser efetuado as validações, e se for altorizado
     * deve persistir os dados no banco de dados
     *
     * @param saborDTO novo sabor
     * @return
     */
    Sabor cadastrar(SaborDTO saborDTO);

    /**@GetMapping
     *
     * Ao receber o id, deve buscar no banco de dados o sabor referente ao id
     *
     * @param id do sabor já existente
     * @return
     */
    Sabor buscarPorId(Long id);

    /**@GetMapping
     *
     * Busca no banco de dados, todos os sabores já cadastrados
     *
     * @return
     */
    List<Sabor> listar();

    /**@PutMapping
     *
     * Ao receber o id do sabor e as informações do sabor a ser editado, deve comparar
     * os dois ids e se forem iguais, deve persistir os dados atualizados
     *
     * @param id do sabor já existente
     * @param saborDTO objeto sabor que fornecera as novas informações do sabor selecionado
     * @return
     */
    Sabor editar(Long id, SaborDTO saborDTO);

    /**@DeleteMapping
     *
     * Ao receber o id do sabor, efetua a busca para verificar se o id é valido, e em seguida, deleta o sabor
     *
     * @param id utilizado para passar as informações do sabor a ser deletado
     */
    void delete(Long id);
}
