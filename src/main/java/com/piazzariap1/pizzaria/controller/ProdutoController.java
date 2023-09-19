package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.service.implementada.ProdutoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    public ProdutoServiceImpl service;

    @PostMapping
    public ResponseEntity<Produto> salvar(@Valid @RequestBody final ProdutoDTO produtoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(produtoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<Produto> buscarOndeId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/descricao")
    public ResponseEntity<List<Produto>> buscarOndeDescricao(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorDescricao(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/valor")
    public ResponseEntity<List<Produto>> buscarOndeValor(@RequestParam("conteudo") Long valor){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorValor(valor));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    public ResponseEntity<List<Produto>> buscarProdutoComecando(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarProdutoComecandoCom(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    public ResponseEntity<List<Produto>> buscarProdutoTerminando(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarProdutoTerminandoCom(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    public ResponseEntity<List<Produto>> buscarProdutoContendo(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarProdutoQueContenha(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Produto>> listarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Produto> atualizar(@RequestParam("id") final Long id, @Valid @RequestBody final ProdutoDTO produtoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,produtoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<String> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{produto.delete-mapping-sucesso}");

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{produto.delete-mapping-failed}");
        }
    }
}
