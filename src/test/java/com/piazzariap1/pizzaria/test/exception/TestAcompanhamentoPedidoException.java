package com.piazzariap1.pizzaria.test.exception;

import com.piazzariap1.pizzaria.controller.AcompanhamentoPedidoController;
import com.piazzariap1.pizzaria.repository.AcompanhamentoPedidoRepository;
import com.piazzariap1.pizzaria.test.implementada.AcompanhamentoPedidoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestAcompanhamentoPedidoException {

    @MockBean
    AcompanhamentoPedidoRepository repository;

    @Autowired
    AcompanhamentoPedidoController controller;

    @Autowired
    AcompanhamentoPedidoServiceImpl service;

    @Test
    @DisplayName("Cadastrar acompanhamento do pedido (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou acompanhamento do pedido por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou acompanhamento do pedido por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals("{acompanhamento.exception.nao-localizado}", exception.getMessage());
    }

    @Test
    @DisplayName("Buscou todos os acompanhamentos do pedido  (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Editar acompanhamento do pedido (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    @DisplayName("Deletar acompanhamento do pedido (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
