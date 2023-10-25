package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

    @Query("SELECT endereco FROM Endereco endereco WHERE endereco.cliente.id = :id")
    public List<Endereco> listarPorIdDoCliente(@Param("id") final Long id);
}
