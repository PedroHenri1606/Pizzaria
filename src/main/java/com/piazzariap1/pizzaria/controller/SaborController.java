package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.SaborDTO;
import com.piazzariap1.pizzaria.service.Implementada.SaborServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

    {
        "id": 1,
        "cadastro": "2023-09-03T23:23:19.200986",
        "edicao": null,
        "ativo": true,
        "nome": "Chocolate",
        "descricao": "Chocolate"
    }

 */

@RestController
@RequestMapping(value = "/sabor")
public class SaborController {

    @Autowired
    public SaborServiceImpl service;

    @PostMapping
    private ResponseEntity<Object> cadastrar(@Valid @RequestBody final SaborDTO saborDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(saborDTO));

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

    @GetMapping(value = "/buscar/descricao")
    private ResponseEntity<Object> buscarPorNome(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorNome(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    private ResponseEntity<Object> buscarAcompanhamentoComecandoCom(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarSaborComecandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    private ResponseEntity<Object> buscarAcompanhamentoTerminandoCom(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarSaborTerminandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    private ResponseEntity<Object> buscarAcompanhamntoQueContenha(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarSaborQueContenha(conteudo));

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
    private ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final SaborDTO saborDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,saborDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    private ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Sabor deletado com sucesso!");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, não foi possivel localizar o sabor informado");
        }
    }
}
