package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.controller.EnderecoController;
import com.piazzariap1.pizzaria.dto.EnderecoDTO;
import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.repository.EnderecoRepository;
import com.piazzariap1.pizzaria.service.implementada.EnderecoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestEndereco {
    @MockBean
    EnderecoRepository repository;

    @Autowired
    EnderecoController controller;

    @Autowired
    EnderecoServiceImpl service;

    @BeforeEach
    void injectData(){

        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");

        //BANCO DE DADOS
        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2,cliente);

        //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
        when(repository.save(Mockito.any(Endereco.class))).thenAnswer(invocation -> {
            Endereco enderecoSalvo = invocation.getArgument(0);
            enderecoSalvo.setId(1L);
            return enderecoSalvo;
        });

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);

        //TESTAR BUSCAR POR ID
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.of(endereco));

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(enderecos);

        //TESTAR ATUALIZAR
        Endereco enderecoNovo = new Endereco(1L,"85859340","MORUMBI III","BELMIRO",2,cliente);
        when(repository.save(enderecoNovo)).thenReturn(enderecos.get(0));
    }

    @Test
    @DisplayName("Cadastrou endereco com sucesso!")
    void salvarTeste(){

        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");

        var endereco = controller.salvar(new EnderecoDTO(1L,"85859340","MORUMBI II","BELMIRO",2,cliente));

        Assertions.assertEquals(1L,endereco.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED,endereco.getStatusCode());
    }

    @Test
    @DisplayName("Buscou endereco do pedido por id")
    void buscarPorIdTest(){

        var endereco = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, endereco.getBody().getId());
        Assertions.assertEquals(HttpStatus.OK,endereco.getStatusCode());
    }

    @Test
    @DisplayName("Listar todos os enderecos")
    void listarTodosTest(){

        var endereco = controller.listarTodos();
        List<Endereco> enderecos = endereco.getBody();

        Assertions.assertEquals(HttpStatus.OK, endereco.getStatusCode());
        Assertions.assertEquals("MORUMBI II", enderecos.get(0).getBairro());
        Assertions.assertEquals(1,enderecos.size());
    }

    @Test
    @DisplayName("Editou o endereco com sucesso!")
    void atualizarTeste(){

        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        EnderecoDTO enderecoDTO = new EnderecoDTO(1L,"85859340","MORUMBI III","BELMIRO",2,cliente);

        var endereco = controller.atualizar(enderecoDTO.getId(),enderecoDTO);

        Assertions.assertEquals(HttpStatus.OK,endereco.getStatusCode());
        Assertions.assertEquals("MORUMBI III", endereco.getBody().getBairro());

    }

    @Test
    @DisplayName("Deletou o endereco com sucesso!")
    void deletarTest(){

        var endereco = controller.deletar(1L);

        Assertions.assertEquals(HttpStatus.OK, endereco.getStatusCode());
    }
}
