package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query("SELECT Cliente FROM Cliente cliente WHERE cliente.cpf = :cpf")
    public List<Cliente> verificaCPF(@Param("cpf") String cpf);
}
