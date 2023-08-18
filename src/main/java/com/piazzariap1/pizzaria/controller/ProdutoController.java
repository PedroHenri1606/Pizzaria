package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.service.ProdutoService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<ProdutoDTO> buscarPorId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.buscarPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<ProdutoDTO>> listar(){
        try {
            return ResponseEntity.ok().body(service.listar());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody final ProdutoDTO produtoDTO){
        try {
            return ResponseEntity.ok().body(service.cadastrar(produtoDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<ProdutoDTO> editar(@RequestParam("id") final Long id, @RequestBody final ProdutoDTO produtoNovo){
        try {
            return ResponseEntity.ok().body(service.editar(id,produtoNovo));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.deletar(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error, não foi possivel deletar o produto informado!");
        }
    }
}
