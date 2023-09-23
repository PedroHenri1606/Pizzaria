package com.piazzariap1.pizzaria.service.exception;

import com.piazzariap1.pizzaria.controller.ProdutoController;
import com.piazzariap1.pizzaria.repository.ProdutoRepository;
import com.piazzariap1.pizzaria.service.implementada.ProdutoServiceImpl;
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

    //CADASTRAR
    @Test
    @DisplayName("Cadastrar produto (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


    //BUSCAR POR ID
    @Test
    @DisplayName("Buscou produto por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou produto por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals("{produto.exception.nao-localizado}", exception.getMessage());
    }


    //BUSCAR POR VALOR
    @Test
    @DisplayName("Buscou produto por valor (Teste Exception não localizado controller)!")
    void buscarPorValorTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeValor(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou produto por valor (Teste Exception não localizado service)!")
    void buscarPorValorTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorValor(null));

        Assertions.assertEquals("{produto.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou produto por valor (Teste Exception não localizado2 service)!")
    void buscarPorValorTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorValor(0L));

        Assertions.assertEquals("{produto.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR POR DESCRICAO
    @Test
    @DisplayName("Buscou produto por descricao (Teste Exception não localizado controller)!")
    void buscarPorDescricaoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeDescricao(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou produto por descricao (Teste Exception não localizado service)!")
    void buscarPorDescricaoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorDescricao(""));

        Assertions.assertEquals("{produto.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou produto por descricao (Teste Exception não localizado2 service)!")
    void buscarPorDescricaoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorDescricao("aaa"));

        Assertions.assertEquals("{produto.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR COMECANCO COM
    @Test
    @DisplayName("Buscou produto comecando por (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoComecandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarProdutoComecando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou produto comecando por (Teste Exception não localizado service)!")
    void buscarAcompanhamentoComecandooTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarProdutoComecandoCom(""));

        Assertions.assertEquals("{produto.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou produto comecando por (Teste Exception não localizado2 service)!")
    void buscarAcompanhamentoComecandoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarProdutoComecandoCom("aaa"));

        Assertions.assertEquals("{produto.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR TERMINANDO COM
    @Test
    @DisplayName("Buscou produto terminando por (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoTerminandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarProdutoTerminando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou produto terminando por (Teste Exception não localizado service)!")
    void buscarAcompanhamentoTerminandoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarProdutoTerminandoCom(""));

        Assertions.assertEquals("{produto.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou produto terminando por (Teste Exception não localizado2 service)!")
    void buscarAcompanhamentoTerminandoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarProdutoTerminandoCom("aaa"));

        Assertions.assertEquals("{produto.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR CONTENDO
    @Test
    @DisplayName("Buscou produto contendo (Teste Exception não localizado controller)!")
    void buscarAcompanhamentoContendoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarProdutoContendo(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou produto terminando por (Teste Exception não localizado service)!")
    void buscarAcompanhamentoContendoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarProdutoQueContenha(""));

        Assertions.assertEquals("{produto.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou produto terminando por (Teste Exception não localizado2 service)!")
    void buscarAcompanhamentoContendoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarProdutoQueContenha("aaa"));

        Assertions.assertEquals("{produto.exception.nao-localizado2}", exception.getMessage());
    }


    //LISTAR TODOS
    @Test
    @DisplayName("Buscou todos os produtos (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou todos os produtos (Teste Exception não cadastrado service)!")
    void listarTodosTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.listar());

        Assertions.assertEquals("{produto.exception.nao-cadastrado}", exception.getMessage());
    }


    //ATUALIZAR
    @Test
    @DisplayName("Editar produto (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
    @DisplayName("Editar Produto (Teste Exception não localizado service)!")
    void atualizarTestExpectionService(){


        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.editar(0L,null));

        Assertions.assertEquals("{produto.exception.nao-localizado}", exception.getMessage());
    }


    //DELETAR
    @Test
    @DisplayName("Deletar produto (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
