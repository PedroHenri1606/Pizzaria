package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {
}
