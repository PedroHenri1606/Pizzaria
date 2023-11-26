package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.service.implementada.AcompanhamentoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/acompanhamento")
@CrossOrigin(origins = "*")
public class AcompanhamentoController {

    @Autowired
    public AcompanhamentoServiceImpl service;


    @PostMapping
    public ResponseEntity<Acompanhamento> salvar(@Valid @RequestBody final AcompanhamentoDTO acompanhamentoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(acompanhamentoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<Acompanhamento> buscarOndeId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/descricao")
    public ResponseEntity<List<Acompanhamento>> buscarOndeDescricao(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorDescricao(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/valor")
    public ResponseEntity<List<Acompanhamento>> buscarOndeValor(@RequestParam("conteudo") Long valor){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorValor(valor));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    public ResponseEntity<List<Acompanhamento>> buscarAcompanhamentoComecando(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoComecandoCom(conteudo));

        } catch (Exception e){
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    public ResponseEntity<List<Acompanhamento>> buscarAcompanhamentoTerminando(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoTerminandoCom(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    public ResponseEntity<List<Acompanhamento>> buscarAcompanhamentoContendo(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoQueContenha(conteudo));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Acompanhamento>> listarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Acompanhamento> atualizar(@RequestParam("id") final Long id, @Valid @RequestBody final AcompanhamentoDTO acompanhamentoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,acompanhamentoDTO));

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "{acompanhamento.delete-mapping-failed}");
        }
    }
}
