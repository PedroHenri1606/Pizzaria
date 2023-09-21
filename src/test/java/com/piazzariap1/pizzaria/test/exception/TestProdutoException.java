package com.piazzariap1.pizzaria.test.exception;

import com.piazzariap1.pizzaria.controller.ProdutoController;
import com.piazzariap1.pizzaria.repository.ProdutoRepository;
import com.piazzariap1.pizzaria.test.implementada.ProdutoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestProdutoException {

    @MockBean
    ProdutoRepository repository;

    @Autowired
    ProdutoController controller;

    @Autowired
    ProdutoServiceImpl service;

    @Test
    @DisplayName("Cadastrar produto (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou produto por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou produto por valor (Teste Exception não localizado controller)!")
    void buscarPorValorTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeValor(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou produto por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals("{produto.exception.nao-localizado}", exception.getMessage());
    }

    @Test
    @DisplayName("Buscou produto por descricao (Teste Exception não localizado controller)!")
    void buscarPorDescricaoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeDescricao(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou produto comecando por (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoComecandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarProdutoComecando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou produto terminando por (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoTerminandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarProdutoTerminando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou produto contendo (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoContendoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarProdutoContendo(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Buscou todos os produtos (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }

    @Test
    @DisplayName("Editar produto (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    @DisplayName("Deletar produto (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
