package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.Endereco;
import com.piazzariap1.pizzaria.entity.UserEntity;

import java.util.Set;


public record ClienteDTO(Long id, Boolean ativo, String nome, String cpf, String telefone, Set<Endereco> enderecos, UserEntity user) {
}
