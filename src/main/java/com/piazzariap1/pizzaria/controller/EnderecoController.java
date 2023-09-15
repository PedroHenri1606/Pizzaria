package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.EnderecoDTO;
import com.piazzariap1.pizzaria.service.implementada.EnderecoServiceImpl;
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
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody final EnderecoDTO enderecoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(enderecoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<Object> buscarPorId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> listar(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final EnderecoDTO enderecoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,enderecoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> delete(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{endereco.delete-mapping-sucesso}");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{endereco.delete-mapping-failed}");
        }
    }
}
