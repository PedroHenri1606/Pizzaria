package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.service.implementada.AcompanhamentoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/acompanhamento")
public class AcompanhamentoController {

    @Autowired
    public AcompanhamentoServiceImpl service;


    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody final AcompanhamentoDTO acompanhamentoDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(acompanhamentoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<Object> buscarOndeId(@RequestParam("id") final Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/descricao")
    public ResponseEntity<Object> buscarOndeDescricao(@RequestParam("conteudo") String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorDescricao(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/valor")
    public ResponseEntity<Object> buscarOndeValor(@RequestParam("conteudo") Long valor){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorValor(valor));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/comecando")
    public ResponseEntity<Object> buscarAcompanhamentoComecando(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoComecandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/terminando")
    public ResponseEntity<Object> buscarAcompanhamentoTerminando(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoTerminandoCom(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscar/contendo")
    public ResponseEntity<Object> buscarAcompanhamentoContendo(@RequestParam("conteudo") final String conteudo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.buscarAcompanhamentoQueContenha(conteudo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<Object> listarTodos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listar());

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Object> atualizar(@RequestParam("id") final Long id, @Valid @RequestBody final AcompanhamentoDTO acompanhamentoDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.editar(id,acompanhamentoDTO));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar")
    public ResponseEntity<Object> deletar(@RequestParam("id") final Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("{acompanhamento.delete-mapping-sucesso}");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{acompanhamento.delete-mapping-failed}");
        }
    }
}
