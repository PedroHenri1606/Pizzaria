package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.AcompanhamentoPedidoDTO;
import com.piazzariap1.pizzaria.service.Implementada.AcompanhamentoPedidoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

    {
        "id": 1,
        "cadastro": "2023-09-04T22:24:11.738394",
        "edicao": null,
        "ativo": true,
        "acompanhamento": {
            "id": 1,
            "cadastro": "2023-09-04T22:22:21.729774",
            "edicao": null,
            "ativo": true,
            "descricao": "Coca Colla 1L",
            "valor": 8
        },
        "quantidade": 1
    }

 */

@RestController
@RequestMapping(value = "/acompanhamento-pedido")
public class AcompanhamentoPedidoController {

    @Autowired
    private AcompanhamentoPedidoServiceImpl service;

    @PostMapping
    private ResponseEntity<Object> cadastrar(@Valid @RequestBody final AcompanhamentoPedidoDTO acompanhamentoPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(acompanhamentoPedidoDTO));

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
    private ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final AcompanhamentoPedidoDTO acompanhamentoPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,acompanhamentoPedidoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, não foi possivel localizar o acompanhamento informado");
        }
    }
}
