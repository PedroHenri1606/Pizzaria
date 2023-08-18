package com.piazzariap1.pizzaria.controller;


import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

{
    "id": 1,
    "cadastro": "2023-08-16T18:46:08.180458",
    "edicao": null,
    "ativo": true,
    "nome": "Pedro Henrique",
    "cpf": "10250870975",
    "telefone": "45 998265476"
}

 */

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<ClienteDTO> buscarPorId(@RequestParam("id") Long id){
        try {
            return ResponseEntity.ok().body(service.buscarPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<ClienteDTO>> listar(){
        try {
            return ResponseEntity.ok().body(service.listar());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody final ClienteDTO clienteDTO){
        try {
            return ResponseEntity.ok().body(service.cadastrar(clienteDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<ClienteDTO> editar(@RequestParam("id") final Long id, @RequestBody final ClienteDTO clienteNovo){
        try {
            return ResponseEntity.ok().body(service.editar(id,clienteNovo));
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
