package com.piazzariap1.pizzaria.service.exception;

import com.piazzariap1.pizzaria.controller.ProdutoPedidoController;
import com.piazzariap1.pizzaria.repository.ProdutoPedidoRepository;
import com.piazzariap1.pizzaria.service.implementada.ProdutoPedidoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestProdutoPedidoException {

    @MockBean
    ProdutoPedidoRepository repository;

    @Autowired
    ProdutoPedidoController controller;

    @Autowired
    ProdutoPedidoServiceImpl service;

    //CADASTRAR
    @Test
    @DisplayName("Cadastrar produto do pedido (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


    //BUSCAR POR ID
    @Test
    @DisplayName("Buscou produto do pedido por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou produto do pedido por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals("{produto-pedido.exception.nao-localizado}", exception.getMessage());
    }


    //LISTAR TODOS
    @Test
    @DisplayName("Buscou todos os produtos do pedido (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }


    //ATUALIZAR
    @Test
    @DisplayName("Editar produto do pedido (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
    @DisplayName("Editar Produto do pedido (Teste Exception não localizado service)!")
    void atualizarTestExpectionService(){


        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.editar(0L,null));

        Assertions.assertEquals("{produto-pedido.exception.nao-localizado}", exception.getMessage());
    }


    //DELETAR
    @Test
    @DisplayName("Deletar produto do pedido (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
