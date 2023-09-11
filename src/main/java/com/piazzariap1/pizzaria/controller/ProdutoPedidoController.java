package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.ProdutoPedidoDTO;
import com.piazzariap1.pizzaria.service.Implementada.ProdutoPedidoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

{
    "id": 1,
    "cadastro": "2023-09-04T23:09:41.9268183",
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
            "id": 3,
            "cadastro": "2023-09-04T22:31:31.804234",
            "edicao": null,
            "ativo": true,
            "produto": {
                "id": 1,
                "cadastro": "2023-09-04T22:19:11.948989",
                "edicao": null,
                "ativo": true,
                "descricao": "Pizza GG",
                "valor": 65
            },
            "quantidade": 1,
            "sabores": [
                {
                    "id": 1,
                    "cadastro": "2023-09-04T22:31:31.804234",
                    "edicao": null,
                    "ativo": true,
                    "nome": "Chocolate",
                    "descricao": "Chocolate",
                    "produtosPedidos": null
                }
            ]
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
@RequestMapping(value = "/produto-pedido")
public class ProdutoPedidoController {

    @Autowired
    private ProdutoPedidoServiceImpl service;

    @PostMapping
    private ResponseEntity<Object> cadastrar(@Valid @RequestBody final ProdutoPedidoDTO produtoPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(produtoPedidoDTO));

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
    private ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final ProdutoPedidoDTO produtoPedidoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id, produtoPedidoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Produto do pedido deletado com sucesso!");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, não foi possivel localizar o item informado");
        }
    }
}
