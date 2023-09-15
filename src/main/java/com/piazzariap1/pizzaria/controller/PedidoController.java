package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.service.Implementada.PedidoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

   {
        "id": 1,
        "cadastro": "2023-09-04T22:23:04.65252",
        "edicao": null,
        "ativo": true,
        "cliente": {
            "id": 1,
            "cadastro": "2023-09-04T22:19:40.136105",
            "edicao": null,
            "ativo": true,
            "nome": "Pedro Henrique",
            "cpf": "12345678911",
            "telefone": "45 998265476"
        },
        "item": [
            {
                "id": 1,
                "cadastro": "2023-09-04T22:31:31.804234",
                "edicao": null,
                "ativo": true,
                "produto": {
                    "id": 1,
                    "cadastro": "2023-09-04T22:19:11.948989",
                    "edicao": null,
                    "ativo": true,
                    "descricao": "Pizza GG",
                    "valor": 8
                },
                "quantidade": 1,
                "sabores": []
            }
        ],
        "acompanhamento": [
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
        ],
        "funcionario": {
            "id": 1,
            "cadastro": "2023-09-04T22:19:37.649766",
            "edicao": null,
            "ativo": true,
            "nome": "Pedro Henrique",
            "cpf": "12345678911",
            "telefone": "45 998265476"
        },
        "observacao": null,
        "entregar": true,
        "pago": false,
        "situacaoPedido": null,
        "formaDePagamento": null,
        "valorTotal": null
    }

 */

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
