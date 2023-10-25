package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.ProdutoPedidoDTO;
import com.piazzariap1.pizzaria.entity.ProdutoPedido;
import com.piazzariap1.pizzaria.service.implementada.ProdutoPedidoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/produto-pedido")
@CrossOrigin(origins = "*")
public class ProdutoPedidoController {

    @Autowired
    public ProdutoPedidoServiceImpl service;

    @PostMapping
    public ResponseEntity<ProdutoPedido> salvar(@Valid @RequestBody final ProdutoPedidoDTO produtoPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(produtoPedidoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<ProdutoPedido> buscarOndeId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<ProdutoPedido>> listarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<ProdutoPedido> atualizar(@RequestParam("id") final Long id, @Valid @RequestBody final ProdutoPedidoDTO produtoPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id, produtoPedidoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{produto-pedido.delete-mapping-failed}");
        }
    }
}