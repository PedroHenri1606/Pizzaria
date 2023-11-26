package com.piazzariap1.pizzaria.repository;

import com.piazzariap1.pizzaria.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    UserDetails findByUsername(String username);
}
