package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Acompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento,Long> {
}
