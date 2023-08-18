package com.piazzariap1.pizzaria.controller;


import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Funcionario;
import com.piazzariap1.pizzaria.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<FuncionarioDTO> buscarPorId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.buscarPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<FuncionarioDTO>> listar(){
        try {
            return ResponseEntity.ok().body(service.listar());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> cadastrar(@RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            return ResponseEntity.ok().body(service.cadastrar(funcionarioDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<FuncionarioDTO> editar(@RequestParam("id") final Long id, @RequestBody final FuncionarioDTO funcionarioNovo){
        try {
            return ResponseEntity.ok().body(service.editar(id,funcionarioNovo));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.ok().body(service.deletar(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error, não foi possivel deletar o funcionario informado!");
        }
    }
}
