package com.piazzariap1.pizzaria.test.exception;

import com.piazzariap1.pizzaria.controller.ClienteController;
import com.piazzariap1.pizzaria.repository.ClienteRepository;
import com.piazzariap1.pizzaria.test.implementada.ClienteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestClienteException {

    @MockBean
    ClienteRepository repository;

    @Autowired
    ClienteController controller;

    @Autowired
    ClienteServiceImpl service;

    @Test
    @DisplayName("Cadastrar cliente (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou cliente por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou cliente por cpf (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorCpf(null));

        Assertions.assertEquals("{cliente.exception.nao-localizado}", exception.getMessage());
    }

    @Test
    @DisplayName("Buscou cliente por descricao (Teste Exception não localizado controller)!")
    void buscarPorNomeTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeNome(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou cliente comecando por (Teste Exception não localizado controller)!")
    void buscarClienteComecandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarClienteComecando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou cliente terminando por (Teste Exception não localizado controller)!")
    void buscarClienteTerminandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarClienteTerminando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou cliente contendo (Teste Exception não localizado controller)!")
    void buscarClienteContendoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarClienteContendo(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou todos os clientes (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Editar cliente (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    @DisplayName("Deletar cliente (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
