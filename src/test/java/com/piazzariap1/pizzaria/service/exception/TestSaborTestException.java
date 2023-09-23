package com.piazzariap1.pizzaria.service.exception;

import com.piazzariap1.pizzaria.controller.SaborController;
import com.piazzariap1.pizzaria.repository.SaborRepository;
import com.piazzariap1.pizzaria.service.implementada.SaborServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestSaborTestException {

    @MockBean
    SaborRepository repository;

    @Autowired
    SaborController controller;

    @Autowired
    SaborServiceImpl service;


    //CADASTRAR
    @Test
    @DisplayName("Cadastrar sabor (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


    //BUSCAR POR ID
    @Test
    @DisplayName("Buscou sabor por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou sabor por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals("{sabor.exception.nao-localizado}", exception.getMessage());
    }


    //BUSCAR POR NOME
    @Test
    @DisplayName("Buscou sabor por nome (Teste Exception não localizado controller)!")
    void buscarPorNomeTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeNome(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou sabor por nome (Teste Exception não localizado service)!")
    void buscarPorNomeTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorNome(""));

        Assertions.assertEquals("{sabor.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou sabor por nome (Teste Exception não localizado2 service)!")
    void buscarPorNomeTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorNome("aaa"));

        Assertions.assertEquals("{sabor.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR COMECANDO COM
    @Test
    @DisplayName("Buscou sabor comecando por (Teste Exception não localizado controller)!")
    void buscarSaborComecandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarSaborComecando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou sabor comecando por (Teste Exception não localizado service)!")
    void buscarPorComecandoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarSaborComecandoCom(""));

        Assertions.assertEquals("{sabor.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou sabor comecando por (Teste Exception não localizado2 service)!")
    void buscarPorComecandoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarSaborComecandoCom("aaa"));

        Assertions.assertEquals("{sabor.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR TERMINANDO POR
    @Test
    @DisplayName("Buscou sabor terminando por (Teste Exception não localizado controller)!")
    void buscarSaborTerminandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarSaborTerminando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou sabor terminando por (Teste Exception não localizado service)!")
    void buscarPorTerminandoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarSaborTerminandoCom(""));

        Assertions.assertEquals("{sabor.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou sabor terminando por (Teste Exception não localizado2 service)!")
    void buscarPorTerminandoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarSaborTerminandoCom("aaa"));

        Assertions.assertEquals("{sabor.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR CONTENDO
    @Test
    @DisplayName("Buscou sabor contendo (Teste Exception não localizado controller)!")
    void buscarSaborContendoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarSaborContendo(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou sabor contendo (Teste Exception não localizado service)!")
    void buscarPorContendoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarSaborQueContenha(""));

        Assertions.assertEquals("{sabor.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou sabor contendo (Teste Exception não localizado2 service)!")
    void buscarPorContendoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarSaborQueContenha("aaa"));

        Assertions.assertEquals("{sabor.exception.nao-localizado2}", exception.getMessage());
    }


    //LISTAR TODOS
    @Test
    @DisplayName("Buscou todos os sabores (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou todos os sabores (Teste Exception não cadastrado service)!")
    void listarTodosTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.listar());

        Assertions.assertEquals("{sabor.exception.nao-cadastrado}", exception.getMessage());
    }


    //EDITAR
    @Test
    @DisplayName("Editar sabor (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
    @DisplayName("Editar sabor (Teste Exception não localizado service)!")
    void atualizarTestExpectionService(){


        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.editar(0L,null));

        Assertions.assertEquals("{sabor.exception.nao-localizado}", exception.getMessage());
    }


    //DELETAR
    @Test
    @DisplayName("Deletar sabor (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
