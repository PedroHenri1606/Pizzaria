package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.SaborDTO;
import com.piazzariap1.pizzaria.entity.Sabor;
import com.piazzariap1.pizzaria.service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sabor")
public class SaborController {

    @Autowired
    private SaborService service;

    @GetMapping
    public ResponseEntity<SaborDTO> buscarPorId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.buscarPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<SaborDTO>> listar(){
        try {
            return ResponseEntity.ok().body(service.listar());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Sabor> cadastrar(SaborDTO saborDTO){
        try {
            return ResponseEntity.ok().body(service.cadastrar(saborDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<SaborDTO> editar(@RequestParam("id") final Long id, @RequestBody final SaborDTO saborNovo){
        try {
            return ResponseEntity.ok().body(service.editar(id,saborNovo));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.deletar(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
