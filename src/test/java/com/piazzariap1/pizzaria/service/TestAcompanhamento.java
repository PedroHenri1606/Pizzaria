package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.controller.AcompanhamentoController;
import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.repository.AcompanhamentoRepository;
import com.piazzariap1.pizzaria.service.implementada.AcompanhamentoServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestAcompanhamento {

    @MockBean
    AcompanhamentoRepository repository;

    @Autowired
    AcompanhamentoController controller;

    @Autowired
    AcompanhamentoServiceImpl service;


    @BeforeEach
    void injectData(){

        //BANCO DE DADOS
        Acompanhamento acompanhamento = new Acompanhamento(1L,"COCA COLA 1L", 12L);


            //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
            when(repository.save(Mockito.any(Acompanhamento.class))).thenAnswer(invocation -> {
                Acompanhamento acompanhamentoSalvo = invocation.getArgument(0);
                acompanhamentoSalvo.setId(2L);
                return acompanhamentoSalvo;
            });

        List<Acompanhamento> acompanhamentos = new ArrayList<>();
        acompanhamentos.add(acompanhamento);

        //TESTAR BUSCAR POR ID
        when(repository.findById(acompanhamento.getId())).thenReturn(Optional.of(acompanhamento));

        //TESTAR BUSCAR POR DESCRICAO
        when(repository.findByDescricao(acompanhamento.getDescricao())).thenReturn(acompanhamentos);

        //TESTAR BUSCAR POR VALOR
        when(repository.findByValor(acompanhamento.getValor())).thenReturn(acompanhamentos);

        //TESTAR BUSCAR COMECANDO POR
        String comecando = "COCA";
        when(repository.findByDescricaoStartingWith(comecando)).thenReturn(acompanhamentos);

        //TESTAR BUSCAR TERMINADNO POR
        String terminando = "1L";
        when(repository.findByDescricaoEndingWith(terminando)).thenReturn(acompanhamentos);

        //TESTAR BUSCAR CONTENDO
        String contendo = "1";
        when(repository.findByDescricaoContaining(contendo)).thenReturn(acompanhamentos);

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(acompanhamentos);

        //TESTAR ATUALIZAR
        Acompanhamento acompanhamentoNovo = new Acompanhamento(1L,"COCA COLA 2L", 14L);
        when(repository.save(acompanhamentoNovo)).thenReturn(acompanhamentos.get(0));

    }

    @Test
    @DisplayName("Cadastrou acompanhamento com sucesso!")
    void salvarTest(){

        AcompanhamentoDTO acompanhamentoDTO = new AcompanhamentoDTO(1L,"COCA COLA 1L", 12L);
        var acompanhamento = controller.salvar(acompanhamentoDTO);

        Assertions.assertEquals(HttpStatus.CREATED, acompanhamento.getStatusCode());
        Assertions.assertNotNull(acompanhamento.getBody().getId());
        Assertions.assertEquals("COCA COLA 1L", acompanhamento.getBody().getDescricao());
    }

    @Test
    @DisplayName("Buscou acompanhamento por id!")
    void buscarPorIdTest(){

        var acompanhamento = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, acompanhamento.getBody().getId());
        Assertions.assertEquals(HttpStatus.OK,acompanhamento.getStatusCode());

    }

    @Test
    @DisplayName("Buscou acompanhamentos por descrição!")
    void bucarOndeDescricaoTest(){

        var acompanhamento = controller.buscarOndeDescricao("COCA COLA 1L");
        List<Acompanhamento> acompanhamentos = acompanhamento.getBody();

        Assertions.assertEquals(HttpStatus.OK, acompanhamento.getStatusCode());
        Assertions.assertEquals(1L,acompanhamentos.size());
    }

    @Test
    @DisplayName("Buscou acompanhamentos por valor!")
    void buscarOndeValorTest(){

        var acompanhamento = controller.buscarOndeValor(12L);
        List<Acompanhamento> acompanhamentos = acompanhamento.getBody();

        Assertions.assertEquals(HttpStatus.OK, acompanhamento.getStatusCode());
        Assertions.assertEquals(12L, acompanhamentos.get(0).getValor());
        Assertions.assertEquals(1, acompanhamentos.size());
    }

    @Test
    @DisplayName("Buscou acompanhamento comecando com conteudo!")
    void buscarAcompanhamentoComecandoTest(){

        var acompanhamento = controller.buscarAcompanhamentoComecando("COCA");
        List<Acompanhamento> acompanhamentos = acompanhamento.getBody();

        Assertions.assertEquals(HttpStatus.OK, acompanhamento.getStatusCode());
        Assertions.assertEquals("COCA COLA 1L", acompanhamentos.get(0).getDescricao());
        Assertions.assertEquals(1, acompanhamentos.size());
    }

    @Test
    @DisplayName("Buscou acompanhamento terminando com conteudo!")
    void buscarAcompanhamentoTerminandoTest(){

        var acompanhamento = controller.buscarAcompanhamentoTerminando("1L");
        List<Acompanhamento> acompanhamentos = acompanhamento.getBody();

        Assertions.assertEquals(HttpStatus.OK, acompanhamento.getStatusCode());
        Assertions.assertEquals("COCA COLA 1L", acompanhamentos.get(0).getDescricao());
        Assertions.assertEquals(1,acompanhamentos.size());

    }

    @Test
    @DisplayName("Buscou acompanhamento contendo o conteudo!")
    void buscarAcompanhamentoContendoTest(){

        var acompanhamento = controller.buscarAcompanhamentoContendo("1");
        List<Acompanhamento> acompanhamentos = acompanhamento.getBody();

        Assertions.assertEquals(HttpStatus.OK, acompanhamento.getStatusCode());
        Assertions.assertEquals("COCA COLA 1L", acompanhamentos.get(0).getDescricao());
        Assertions.assertEquals(1,acompanhamentos.size());

    }

    @Test
    @DisplayName("Buscou todos os acompanhamentos!")
    void listarTodosTest(){

        var acompanhamento = controller.listarTodos();
        List<Acompanhamento> acompanhamentos = acompanhamento.getBody();

        Assertions.assertEquals(HttpStatus.OK, acompanhamento.getStatusCode());
        Assertions.assertEquals("COCA COLA 1L", acompanhamentos.get(0).getDescricao());
        Assertions.assertEquals(1,acompanhamentos.size());

    }

    @Test
    @DisplayName("Editou o acompanhamento som sucesso!")
    void atualizarTest(){

        var acompanhamentoNovo = controller.atualizar(1L,new AcompanhamentoDTO(1L,"COCA COLA 2L", 14L));

        Assertions.assertEquals(HttpStatus.OK,acompanhamentoNovo.getStatusCode());
        Assertions.assertEquals("COCA COLA 2L", acompanhamentoNovo.getBody().getDescricao());
    }

    @Test
    @DisplayName("Deletou o acompanhamento com sucesso!")
    void deletarTest(){

        var acompanhamentoDeletado = controller.deletar(1L);

        Assertions.assertEquals(HttpStatus.OK, acompanhamentoDeletado.getStatusCode());
    }
}
