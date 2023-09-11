package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.service.Implementada.ProdutoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

    {
        "id": 1,
        "cadastro": "2023-09-03T23:31:33.6303253",
        "edicao": null,
        "ativo": true,
        "descricao": "Pizza GG",
        "tamanho": "GG",
        "valor": 65
    }

 */

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl service;

    @PostMapping
    private ResponseEntity<Object> cadastrar(@Valid @RequestBody final ProdutoDTO produtoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(produtoDTO));

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

    @GetMapping(value = "/buscar/descricao")
    private ResponseEntity<Object> buscarPorDescricao(@RequestParam("descricao") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorDescricao(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/valor")
    private ResponseEntity<Object> buscarPorValor(@RequestParam("valor") Long valor){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorValor(valor));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    private ResponseEntity<Object> buscarAcompanhamentoComecandoCom(@RequestParam("descricao") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarProdutoComecandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    private ResponseEntity<Object> buscarAcompanhamentoTerminandoCom(@RequestParam("descricao") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarProdutoTerminandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    private ResponseEntity<Object> buscarAcompanhamntoQueContenha(@RequestParam("descricao") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarProdutoQueContenha(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error, " + e.getMessage());
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
    private ResponseEntity<Object> editar(@RequestParam("id") final Long id, @Valid @RequestBody final ProdutoDTO produtoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,produtoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, não foi possivel localizar o produto informado");
        }
    }
}
