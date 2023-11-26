package com.piazzariap1.pizzaria.config.security;

import com.piazzariap1.pizzaria.repository.UserEntityRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService service;

    @Autowired
    UserEntityRepository repository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recuperarToken(request);
        if(token != null){
            var username = service.validarToken(token);
            UserDetails user = repository.findByUsername(username);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }


    private String recuperarToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
