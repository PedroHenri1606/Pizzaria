package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {

    List<Sabor> findByNome(String nome);

    List<Sabor> findByNomeStartingWith(String nome);

    List<Sabor> findByNomeEndingWith(String nome);

    List<Sabor> findByNomeContaining(String nome);
}
