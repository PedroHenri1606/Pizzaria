package com.piazzariap1.pizzaria.dto.abstractentitydto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class UserDTO {

   private String email;

   private String senha;

   public UserDTO(String email, String senha) {
      this.email = email;
      this.senha = senha;
   }
}
