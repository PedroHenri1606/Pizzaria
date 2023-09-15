package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.SaborDTO;
import com.piazzariap1.pizzaria.service.implementada.SaborServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sabor")
public class SaborController {

    @Autowired
    public SaborServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody final SaborDTO saborDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(saborDTO));

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

    @GetMapping(value = "/buscar/descricao")
    public ResponseEntity<Object> buscarPorNome(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorNome(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    public ResponseEntity<Object> buscarSaborComecandoCom(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarSaborComecandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    public ResponseEntity<Object> buscarSaborTerminandoCom(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarSaborTerminandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    public ResponseEntity<Object> buscarSaborQueContenha(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarSaborQueContenha(conteudo));

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
    public ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final SaborDTO saborDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,saborDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> delete(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{sabor.delete-mapping-sucesso}");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{sabor.delete-mapping-failed}");
        }
    }
}
