package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Pedido;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<PedidoDTO> buscarPorId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.buscarPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<PedidoDTO>> listar(){
        try {
            return ResponseEntity.ok().body(service.listar());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrar(@RequestBody final PedidoDTO pedidoDTO){
        try {
            return ResponseEntity.ok().body(service.cadastrar(pedidoDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<PedidoDTO> editar(@RequestParam("id") final Long id, @RequestBody final PedidoDTO pedidoDTO){
        try {
            return ResponseEntity.ok().body(service.editar(id,pedidoDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.deletar(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error, não foi possivel deletar o pedido informado!");
        }
    }
}
