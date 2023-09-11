package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    List<Cliente> findByCpf(String cpf);

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeStartingWith(String nome);

    List<Cliente> findByNomeEndingWith(String nome);

    List<Cliente> findByNomeContaining(String nome);

}
