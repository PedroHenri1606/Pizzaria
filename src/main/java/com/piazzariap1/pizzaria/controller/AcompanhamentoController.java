package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.service.Implementada.AcompanhamentoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

    {
        "id": 1,
        "cadastro": "2023-09-03T23:25:06.555647",
        "edicao": null,
        "ativo": true,
        "descricao": "Coca Colla 1L",
        "valor": 8
    }

 */

@RestController
@RequestMapping(value = "/acompanhamento")
public class AcompanhamentoController {

    @Autowired
    private AcompanhamentoServiceImpl service;


    @PostMapping
    private ResponseEntity<Object> cadastrar(@Valid @RequestBody final AcompanhamentoDTO acompanhamentoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(acompanhamentoDTO));

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
    private ResponseEntity<Object> buscarPorDescricao(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorDescricao(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/valor")
    private ResponseEntity<Object> buscarPorValor(@RequestParam("conteudo") Long valor){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorValor(valor));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    private ResponseEntity<Object> buscarAcompanhamentoComecandoCom(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoComecandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    private ResponseEntity<Object> buscarAcompanhamentoTerminandoCom(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoTerminandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    private ResponseEntity<Object> buscarAcompanhamntoQueContenha(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoQueContenha(conteudo));

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
    private ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final AcompanhamentoDTO acompanhamentoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,acompanhamentoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Acompanhamento deletado com sucesso!");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, não foi possivel localizar o acompanhamento informado");
        }
    }
}
