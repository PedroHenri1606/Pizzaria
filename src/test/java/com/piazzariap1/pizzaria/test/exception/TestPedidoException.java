package com.piazzariap1.pizzaria.test.exception;

import com.piazzariap1.pizzaria.controller.PedidoController;
import com.piazzariap1.pizzaria.repository.PedidoRepository;
import com.piazzariap1.pizzaria.test.implementada.PedidoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestPedidoException {

    @MockBean
    PedidoRepository repository;

    @Autowired
    PedidoController controller;

    @Autowired
    PedidoServiceImpl service;

    //CADASTRAR
    @Test
    @DisplayName("Cadastrar pedido (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


    //BUSCAR POR ID
    @Test
    @DisplayName("Buscou pedido por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou pedido por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals("{pedido.exception.nao-localizado}", exception.getMessage());
    }


    //LISTAR TODOS
    @Test
    @DisplayName("Buscou todos os pedidos (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Editar pedido (Teste Exception não localizado service)!")
    void atualizarTestExpectionService(){


        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.editar(0L,null));

        Assertions.assertEquals("{pedido.exception.nao-localizado}", exception.getMessage());
    }


    //EDITAR
    @Test
    @DisplayName("Editar pedido (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
}
