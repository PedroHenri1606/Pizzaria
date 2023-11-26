package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.config.security.TokenService;
import com.piazzariap1.pizzaria.dto.UserEntityDTO;
import com.piazzariap1.pizzaria.dto.security.AuthenticationDTO;
import com.piazzariap1.pizzaria.dto.security.LoginResponseDTO;
import com.piazzariap1.pizzaria.entity.UserEntity;
import com.piazzariap1.pizzaria.service.implementada.UserEntityServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserEntityController {

    @Autowired
    UserEntityServiceImpl service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        UserEntity user = new UserEntity();

        BeanUtils.copyProperties(auth,user);

        var token = tokenService.gerarToken(user);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping
    public ResponseEntity<UserEntity> cadastrar(@Valid @RequestBody final UserEntityDTO userEntityDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(userEntityDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error cadastrar, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<UserEntity> buscarPorId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error buscar, " + e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<UserEntity>> listar(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Error listar, " + e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<UserEntity> editar(@RequestParam("id") final Long id, @Valid @RequestBody final UserEntityDTO userNovo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,userNovo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error editar, " + e.getMessage());
        }
    }
}
