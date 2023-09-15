package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.service.implementada.FuncionarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    public FuncionarioServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(funcionarioDTO));

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


    @GetMapping(value = "/buscar/nome")
    public ResponseEntity<Object> buscarPorNome(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorNome(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/cpf")
    public ResponseEntity<Object> buscarPorCpf(@RequestParam("conteudo") String cpf){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorCpf(cpf));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    public ResponseEntity<Object> buscarFuncionarioComecandoCom(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioComecandoCom(nome));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    public ResponseEntity<Object> buscarFuncionarioTerminandoCom(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioTerminandoCom(nome));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    public ResponseEntity<Object> buscarFuncionarioQueContenha(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioQueContenha(nome));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
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
    public ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,funcionarioDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> delete(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{funcionario.delete-mapping-sucesso}");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{funcionario.delete-mapping-failed}");
        }
    }
}
