package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.AcompanhamentoPedidoDTO;
import com.piazzariap1.pizzaria.entity.AcompanhamentoPedido;
import com.piazzariap1.pizzaria.service.implementada.AcompanhamentoPedidoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/acompanhamento-pedido")
public class AcompanhamentoPedidoController {

    @Autowired
    public AcompanhamentoPedidoServiceImpl service;

    @PostMapping
    public ResponseEntity<AcompanhamentoPedido> salvar(@Valid @RequestBody final AcompanhamentoPedidoDTO acompanhamentoPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(acompanhamentoPedidoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<AcompanhamentoPedido> buscarOndeId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<AcompanhamentoPedido>> listarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<AcompanhamentoPedido> atualizar(@RequestParam("id") final Long id, @Valid @RequestBody final AcompanhamentoPedidoDTO acompanhamentoPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,acompanhamentoPedidoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{acompanhamento-pedido.delete-mapping-sucesso}");

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{acompanhamento-pedido.delete-mapping-failed}");
        }
    }
}
