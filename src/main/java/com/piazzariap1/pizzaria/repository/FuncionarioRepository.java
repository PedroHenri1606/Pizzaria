package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByCpf(String cpf);

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByNomeStartingWith(String nome);

    List<Funcionario> findByNomeEndingWith(String nome);

    List<Funcionario> findByNomeContaining(String nome);
}
