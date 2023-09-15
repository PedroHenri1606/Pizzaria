package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.service.Implementada.FuncionarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

    {
        "id": 1,
        "cadastro": "2023-09-03T23:18:41.800216",
        "edicao": null,
        "ativo": true,
        "nome": "Pedro Henrique",
        "cpf": "12345678911",
        "telefone": "45 998265476"
    }

 */

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    public FuncionarioServiceImpl service;

    @PostMapping
    private ResponseEntity<Object> cadastrar(@Valid @RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(funcionarioDTO));

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


    @GetMapping(value = "/buscar/nome")
    private ResponseEntity<Object> buscarPorNome(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorNome(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/cpf")
    private ResponseEntity<Object> buscarPorCpf(@RequestParam("conteudo") String cpf){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorCpf(cpf));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    private ResponseEntity<Object> buscarClienteComecandoCom(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioComecandoCom(nome));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    private ResponseEntity<Object> buscarClienteTerminandoCom(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioTerminandoCom(nome));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    private ResponseEntity<Object> buscarClienteQueContenha(@RequestParam("conteudo") final String nome){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarFuncionarioQueContenha(nome));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
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
    private ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,funcionarioDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Funcionario deletado com sucesso!");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, não foi possivel localizar o funcionario informado");
        }
    }
}
