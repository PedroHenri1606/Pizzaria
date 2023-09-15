package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.EnderecoDTO;
import com.piazzariap1.pizzaria.service.Implementada.EnderecoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    public EnderecoServiceImpl service;

    @PostMapping
    private ResponseEntity<Object> cadastrar(@Valid @RequestBody final EnderecoDTO enderecoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(enderecoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    private ResponseEntity<Object> buscarPorId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    private ResponseEntity<Object> listar(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    private ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final EnderecoDTO enderecoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,enderecoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, não foi possivel localizar o endereço informado");
        }
    }
}
