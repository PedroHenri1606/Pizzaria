package com.piazzariap1.pizzaria.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.piazzariap1.pizzaria.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.jwt.chave-secret}")
    private String secret;

    public String gerarToken(UserEntity user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-pizzaria")
                    .withSubject(user.getUsername())
                    .withExpiresAt(geradorDeExpiracaoToken())
                    .sign(algorithm);
            return token;

        } catch (JWTCreationException e){
            throw new JWTCreationException("Erro ao fazer a geração do token! ", e);
        }
    }

    public Instant geradorDeExpiracaoToken(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00:00"));
    }

    public String validarToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-pizzaria")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e){
            return "";
        }
    }
}
