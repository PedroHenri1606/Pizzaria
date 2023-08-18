package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Acompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento,Long> {

    @Query("SELECT Acompanhamento FROM Acompanhamento acompanhamento WHERE acompanhamento.descricao = :descricao")
    public List<Acompanhamento> verificaDescricao(@Param("descricao") String descricao);
}
