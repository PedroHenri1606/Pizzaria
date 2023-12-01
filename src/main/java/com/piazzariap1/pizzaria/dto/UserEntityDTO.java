package com.piazzariap1.pizzaria.dto;

import com.piazzariap1.pizzaria.entity.enuns.Roles;

public record UserEntityDTO(Long id, String username, Roles roles, String token) {
}
