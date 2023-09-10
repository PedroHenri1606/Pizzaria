package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Acompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento,Long> {

    List<Acompanhamento> findByDescricao(String descricao);

    List<Acompanhamento> findByValor(Long valor);

    List<Acompanhamento> findByDescricaoStartingWith(String descricao);

    List<Acompanhamento> findByDescricaoEndingWith(String descricao);

    List<Acompanhamento> findByDescricaoContaining(String descricao);

}
