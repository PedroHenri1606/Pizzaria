package com.piazzariap1.pizzaria.service.exception;

import com.piazzariap1.pizzaria.controller.EnderecoController;
import com.piazzariap1.pizzaria.repository.EnderecoRepository;
import com.piazzariap1.pizzaria.service.implementada.EnderecoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class TestEnderecoException {

    @MockBean
    EnderecoRepository repository;

    @Autowired
    EnderecoController controller;

    @Autowired
    EnderecoServiceImpl service;

    //CADASTRAR
    @Test
    @DisplayName("Cadastrar endereco (Teste Exception não localizado controller)!")
    void cadastrarTestExceptionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.salvar(null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


    //BUSCAR POR ID
    @Test
    @DisplayName("Buscou endereco por id (Teste Exception não localizado controller)!")
    void buscarPorIdTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.buscarOndeId(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou endereco por id (Teste Exception não localizado service)!")
    void buscarPorIdTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.buscarPorId(null));

        Assertions.assertEquals("{endereco.exception.nao-localizado}", exception.getMessage());
    }


    //LISTAR TODOS
    @Test
    @DisplayName("Buscou todos os enderecos (Teste Exception não localizado controller)!")
    void listarTodosTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.listarTodos());

        Assertions.assertEquals(HttpStatus.NO_CONTENT, exception.getStatusCode());
    }
    @Test
    @DisplayName("Buscou todos os enderecos (Teste Exception não cadastrado service)!")
    void listarTodosTestExpectionService(){

        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.listar());

        Assertions.assertEquals("{endereco.exception.nao-cadastrado}", exception.getMessage());
    }


    //ATUALIZAR
    @Test
    @DisplayName("Editar endereco (Teste Exception não localizado controller)!")
    void atualizarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.atualizar(null,null));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
    @DisplayName("Editar endereco (Teste Exception não localizado service)!")
    void atualizarTestExpectionService(){


        final NaoLocalizadoException exception = Assertions.assertThrows(NaoLocalizadoException.class, () -> service.editar(0L,null));

        Assertions.assertEquals("{endereco.exception.nao-localizado}", exception.getMessage());
    }


    //DELETAR
    @Test
    @DisplayName("Deletar endereco (Teste Exception não localizado controller)!")
    void deletarTestExpectionController(){

        final ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> controller.deletar(null));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
