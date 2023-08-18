package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.service.AcompanhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acompanhamento")
public class AcompanhamentoController {

    @Autowired
    private AcompanhamentoService service;


    @GetMapping
    public ResponseEntity<AcompanhamentoDTO> buscarPorId(@RequestParam("id") Long id){
        try {
            return ResponseEntity.ok().body(service.buscarPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<AcompanhamentoDTO>> listar(){
        try {
            return ResponseEntity.ok().body(service.listar());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Acompanhamento> cadastrar(@RequestBody final AcompanhamentoDTO acompanhamentoDTO){
        try {
            return ResponseEntity.ok().body(service.cadastrar(acompanhamentoDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<AcompanhamentoDTO> editar(@RequestParam("id") final Long id, @RequestBody final AcompanhamentoDTO acompanhamentoDTO){
        try {
            return ResponseEntity.ok().body(service.editar(id,acompanhamentoDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.deletar(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }
}
