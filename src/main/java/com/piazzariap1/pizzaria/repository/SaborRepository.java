package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {

    @Query("SELECT Sabor FROM Sabor sabor WHERE sabor.nome = :nome")
    public List<Sabor> verificarNome(@Param("nome") String nome);
}
