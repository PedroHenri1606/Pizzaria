package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.UserEntity;

public record FuncionarioDTO(Long id, Boolean ativo, String nome, String cpf, String telefone, UserEntity user) {
}
