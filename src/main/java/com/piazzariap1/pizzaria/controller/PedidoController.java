package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.service.Implementada.PedidoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    public PedidoServiceImpl service;

    @PostMapping
    private ResponseEntity<Object> cadastrar(@Valid @RequestBody final PedidoDTO pedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(pedidoDTO));

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
    private ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final PedidoDTO pedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,pedidoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }
}
