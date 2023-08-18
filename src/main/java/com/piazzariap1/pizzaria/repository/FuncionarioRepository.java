package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT Funcionario FROM Funcionario funcionario WHERE funcionario.cpf = :cpf")
    public List<Funcionario> verificaCPF(@Param("cpf") String cpf);
}
