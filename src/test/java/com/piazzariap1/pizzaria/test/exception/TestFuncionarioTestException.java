package com.piazzariap1.pizzaria.test.exception;

import com.piazzariap1.pizzaria.controller.FuncionarioController;
import com.piazzariap1.pizzaria.repository.FuncionarioRepository;

import com.piazzariap1.pizzaria.test.implementada.FuncionarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestFuncionarioTestException {

    @MockBean
    FuncionarioRepository repository;

    @Autowired
    FuncionarioController controller;

    @Autowired
    FuncionarioServiceImpl service;

    @Test
    @DisplayName("Cadastrar funcionario (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou funcionario por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou funcionario por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals("{funcionario.exception.nao-localizado}", exception.getMessage());
    }

    @Test
    @DisplayName("Buscou funcionario por nome (Teste Exception não localizado controller)!")
    void buscarPorNomeTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeNome(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou funcionario por CPF (Teste Exception não localizado controller)!")
    void buscarPorCPFTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeCpf(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou funcionario comecando por (Teste Exception não localizado controller)!")
    void buscarFuncionarioComecandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarFuncionarioComecando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou funcionario terminando por (Teste Exception não localizado controller)!")
    void buscarFuncionarioTerminandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarFuncionarioTerminando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou funcionario contendo (Teste Exception não localizado controller)!")
    void buscarFuncionarioContendoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarFuncionarioContendo(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou todos os funcionarios (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Editar Funcionario (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    @DisplayName("Deletar Funcionario (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
