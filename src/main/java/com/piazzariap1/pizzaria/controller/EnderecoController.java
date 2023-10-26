package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.EnderecoDTO;
import com.piazzariap1.pizzaria.entity.Endereco;
import com.piazzariap1.pizzaria.service.implementada.EnderecoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
@CrossOrigin(origins = "*")
public class EnderecoController {

    @Autowired
    public EnderecoServiceImpl service;

    @PostMapping
    public ResponseEntity<Endereco> salvar(@Valid @RequestBody final EnderecoDTO enderecoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(enderecoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<Endereco> buscarOndeId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Endereco>> listarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }
    
    @PutMapping(value = "/editar")
    public ResponseEntity<Endereco> atualizar(@RequestParam("id") final Long id, @Valid @RequestBody final EnderecoDTO enderecoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,enderecoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{endereco.delete-mapping-failed}");
        }
    }
}
