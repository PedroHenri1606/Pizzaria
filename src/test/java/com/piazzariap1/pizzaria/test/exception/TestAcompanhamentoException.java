package com.piazzariap1.pizzaria.test.exception;

import com.piazzariap1.pizzaria.controller.AcompanhamentoController;
import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.repository.AcompanhamentoRepository;
import com.piazzariap1.pizzaria.test.implementada.AcompanhamentoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestAcompanhamentoException {

    @MockBean
    AcompanhamentoRepository repository;

    @Autowired
    AcompanhamentoController controller;

    @Autowired
    AcompanhamentoServiceImpl service;

    //CADASTRAR
    @Test
    @DisplayName("Cadastrar acompanhamento (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


    //BUSCAR POR ID
    @Test
    @DisplayName("Buscou acompanhamento por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }


    //BUSCAR POR VALOR
    @Test
    @DisplayName("Buscou acompanhamento por valor (Teste Exception não localizado service)!")
    void buscarPorValorTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorValor(null));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou acompanhamento por valor (Teste Exception não localizado controller)!")
    void buscarPorValorTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeValor(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou acompanhamento por valor (Teste Exception não localizado2 service)!")
    void buscarPorValorTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorValor(0L));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado2}", exception.getMessage());
    }

    //BUSCAR POR DESCRICAO
    @Test
    @DisplayName("Buscou acompanhamento por descricao (Teste Exception não localizado controller)!")
    void buscarPorDescricaoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeDescricao(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou acompanhamento por descricao (Teste Exception não localizado service)!")
    void buscarPorDescricaoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorDescricao(""));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou acompanhamento por descricao (Teste Exception não localizado2 service)!")
    void buscarPorDescricaoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorDescricao("aaa"));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR COMECANDO COM
    @Test
    @DisplayName("Buscou acompanhamento comecando por (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoComecandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarAcompanhamentoComecando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou acompanhamento comecando por (Teste Exception não localizado service)!")
    void buscarAcompanhamentoComecandoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarAcompanhamentoComecandoCom(""));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou acompanhamento comecando por (Teste Exception não localizado2 service)!")
    void buscarAcompanhamentoComecandoTestExpection2Service(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarAcompanhamentoComecandoCom("aaa"));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR TERMINANDO COM
    @Test
    @DisplayName("Buscou acompanhamento terminando por (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoTerminandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarAcompanhamentoTerminando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou acompanhamento terminando por (Teste Exception não localizado service)!")
    void buscarAcompanhamentoTerminandoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarAcompanhamentoTerminandoCom(""));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou acompanhamento terminando por (Teste Exception não localizado2 service)!")
    void buscarAcompanhamentoTerminandoTestExpection2Service(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarAcompanhamentoTerminandoCom("aaa"));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR CONTENDO
    @Test
    @DisplayName("Buscou acompanhamento contendo (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoContendoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarAcompanhamentoContendo(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou acompanhamento contendo (Teste Exception não localizado service)!")
    void buscarAcompanhamentoContendoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarAcompanhamentoQueContenha(""));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou acompanhamento contendo (Teste Exception não localizado2 service)!")
    void buscarAcompanhamentoContendoTestExpection2Service(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarAcompanhamentoQueContenha("aaa"));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado2}", exception.getMessage());
    }


    //LISTAR TODOS
    @Test
    @DisplayName("Buscou todos os acompanhamentos (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }


    //ATUALIZAR
    @Test
    @DisplayName("Editar acompanhamento (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou acompanhamento (Teste Exception não localizado service)!")
    void atualizarTestExpectionService(){

        AcompanhamentoDTO acompanhamentoDTO = new AcompanhamentoDTO(1L,"teste",1L);
        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.editar(0L,acompanhamentoDTO));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado}", exception.getMessage());
    }


    //DELETAR
    @Test
    @DisplayName("Deletar acompanhamento (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
