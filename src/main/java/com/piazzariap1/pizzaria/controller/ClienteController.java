package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.test.implementada.ClienteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    public ClienteServiceImpl service;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody final ClienteDTO clienteDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(clienteDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<Cliente> buscarOndeId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/nome")
    public ResponseEntity<List<Cliente>> buscarOndeNome(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorNome(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/cpf")
    public ResponseEntity<List<Cliente>> buscarOndeCpf(@RequestParam("conteudo") String cpf){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorCpf(cpf));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    public ResponseEntity<List<Cliente>> buscarClienteComecando(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarClienteComecandoCom(nome));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    public ResponseEntity<List<Cliente>> buscarClienteTerminando(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarClienteTerminandoCom(nome));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    public ResponseEntity<List<Cliente>> buscarClienteContendo(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarClienteQueContenha(nome));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Cliente>> listarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Cliente> atualizar(@RequestParam("id") final Long id, @Valid @RequestBody final ClienteDTO clienteDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,clienteDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{cliente.delete-mapping-sucesso}");

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{cliente.delete-mapping-failed}");
        }
    }
}
