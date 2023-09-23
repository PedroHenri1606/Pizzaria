package com.piazzariap1.pizzaria.service.exception;

import com.piazzariap1.pizzaria.controller.ClienteController;
import com.piazzariap1.pizzaria.repository.ClienteRepository;
import com.piazzariap1.pizzaria.service.implementada.ClienteServiceImpl;
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

    //CADASTRAR
    @Test
    @DisplayName("Cadastrar cliente (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


    //BUSCAR POR ID
    @Test
    @DisplayName("Buscou cliente por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou cliente por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(0L));

        Assertions.assertEquals("{cliente.exception.nao-localizado}", exception.getMessage());
    }


    //BUSCAR POR CPF
    @Test
    @DisplayName("Buscou cliente por cpf (Teste Exception não localizado controller)!")
    void buscarPorCpfTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeCpf(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou cliente por cpf (Teste Exception não localizado service)!")
    void buscarPorCpfTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorCpf(null));

        Assertions.assertEquals("{cliente.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou cliente por cpf (Teste Exception não localizado2 service)!")
    void buscarPorCpfTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorCpf("aaa"));

        Assertions.assertEquals("{cliente.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR POR DESCRICAO
    @Test
    @DisplayName("Buscou cliente por descricao (Teste Exception não localizado controller)!")
    void buscarPorNomeTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeNome(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou cliente por descricao (Teste Exception não localizado service)!")
    void buscarPorNomeTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorNome(""));

        Assertions.assertEquals("{cliente.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou cliente por descricao (Teste Exception não localizado2 service)!")
    void buscarPorNomeTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorNome("aaa"));

        Assertions.assertEquals("{cliente.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR COMECANDO COM
    @Test
    @DisplayName("Buscou cliente comecando por (Teste Exception não localizado controller)!")
    void buscarClienteComecandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarClienteComecando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou cliente comecando por (Teste Exception não localizado service)!")
    void buscarClienteComecandoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarClienteComecandoCom(""));

        Assertions.assertEquals("{cliente.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou cliente comecando por (Teste Exception não localizado2 service)!")
    void buscarClienteComecandoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarClienteComecandoCom("aaa"));

        Assertions.assertEquals("{cliente.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR TERMINANDO COM
    @Test
    @DisplayName("Buscou cliente terminando por (Teste Exception não localizado controller)!")
    void buscarClienteTerminandoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarClienteTerminando(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou cliente terminando por (Teste Exception não localizado service)!")
    void buscarClienteTerminandoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarClienteTerminandoCom(""));

        Assertions.assertEquals("{cliente.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou cliente terminando por (Teste Exception não localizado2 service)!")
    void buscarClienteTerminandoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarClienteTerminandoCom("aaa"));

        Assertions.assertEquals("{cliente.exception.nao-localizado2}", exception.getMessage());
    }


    //BUSCAR CONTENDO
    @Test
    @DisplayName("Buscou cliente contendo (Teste Exception não localizado controller)!")
    void buscarClienteContendoTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarClienteContendo(null));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou cliente contendo (Teste Exception não localizado service)!")
    void buscarClienteContendoTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarClienteQueContenha(""));

        Assertions.assertEquals("{cliente.exception.nao-localizado}", exception.getMessage());
    }
    @Test
    @DisplayName("Buscou cliente contendo (Teste Exception não localizado2 service)!")
    void buscarClienteContendoTest2ExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarClienteQueContenha("aaa"));

        Assertions.assertEquals("{cliente.exception.nao-localizado2}", exception.getMessage());
    }


    //LISTAR TODOS
    @Test
    @DisplayName("Buscou todos os clientes (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou todos os clientes (Teste Exception não cadastrado service)!")
    void listarTodosTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.listar());

        Assertions.assertEquals("{cliente.exception.nao-cadastrado}", exception.getMessage());
    }


    //ATUALIZAR
    @Test
    @DisplayName("Editar cliente (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
    @DisplayName("Editar cliente (Teste Exception não localizado service)!")
    void atualizarTestExpectionService(){


        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.editar(0L,null));

        Assertions.assertEquals("{cliente.exception.nao-localizado}", exception.getMessage());
    }


    //DELETAR
    @Test
    @DisplayName("Deletar cliente (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
