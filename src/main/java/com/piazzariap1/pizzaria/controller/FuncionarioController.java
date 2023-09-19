package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Funcionario;
import com.piazzariap1.pizzaria.service.implementada.FuncionarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    public FuncionarioServiceImpl service;

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@Valid @RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(funcionarioDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<Funcionario> buscarOndeId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


    @GetMapping(value = "/buscar/nome")
    public ResponseEntity<List<Funcionario>> buscarOndeNome(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorNome(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/cpf")
    public ResponseEntity<List<Funcionario>> buscarOndeCpf(@RequestParam("conteudo") String cpf){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorCpf(cpf));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    public ResponseEntity<List<Funcionario>> buscarFuncionarioComecando(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioComecandoCom(nome));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    public ResponseEntity<List<Funcionario>> buscarFuncionarioTerminando(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioTerminandoCom(nome));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    public ResponseEntity<List<Funcionario>> buscarFuncionarioContendo(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioQueContenha(nome));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Funcionario>> listarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Funcionario> atualizar(@RequestParam("id") final Long id, @Valid @RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,funcionarioDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{funcionario.delete-mapping-sucesso}");

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{funcionario.delete-mapping-failed}");
        }
    }
}
