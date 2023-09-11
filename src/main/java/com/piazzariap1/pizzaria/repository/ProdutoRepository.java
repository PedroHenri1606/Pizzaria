package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByDescricao(String descricao);

    List<Produto> findByValor(Long valor);

    List<Produto> findByDescricaoStartingWith(String descricao);

    List<Produto> findByDescricaoEndingWith(String descricao);

    List<Produto> findByDescricaoContaining(String descricao);
}
