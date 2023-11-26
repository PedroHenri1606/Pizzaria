package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.controller.AcompanhamentoPedidoController;
import com.piazzariap1.pizzaria.dto.AcompanhamentoPedidoDTO;
import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.Roles;
import com.piazzariap1.pizzaria.repository.AcompanhamentoPedidoRepository;
import com.piazzariap1.pizzaria.service.implementada.AcompanhamentoPedidoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.*;

import static org.mockito.Mockito.when;

@SpringBootTest
class TestAcompanhamentoPedido {

    @MockBean
    AcompanhamentoPedidoRepository repository;

    @Autowired
    AcompanhamentoPedidoController controller;

    @Autowired
    AcompanhamentoPedidoServiceImpl service;

    @BeforeEach
    void injectData(){

        Acompanhamento acompanhamento = new Acompanhamento(1L,true,"COCA COLA 1L", 12L);
        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);
        Cliente cliente = new Cliente(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",enderecos,user);
        Funcionario funcionario = new Funcionario(1L,true,"Pedro Henrique Vieira","10250870975","45998265476", user);
        Pedido pedido = new Pedido();

        //BANCO DE DADOS
        AcompanhamentoPedido acompanhamentoPedido = new AcompanhamentoPedido(1L,acompanhamento,2,"");

        //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
        when(repository.save(Mockito.any(AcompanhamentoPedido.class))).thenAnswer(invocation -> {
            AcompanhamentoPedido acompanhamentoSalvo = invocation.getArgument(0);
            acompanhamentoSalvo.setId(1L);
            return acompanhamentoSalvo;
        });

        List<AcompanhamentoPedido> acompanhamentoPedidos = new ArrayList<>();
        acompanhamentoPedidos.add(acompanhamentoPedido);

        //TESTAR BUSCAR POR ID
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.of(acompanhamentoPedido));

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(acompanhamentoPedidos);

        //TESTAR ATUALIZAR
        AcompanhamentoPedido acompanhamentoPedidoNovo = new AcompanhamentoPedido(1L,acompanhamento,3,"");
        when(repository.save(acompanhamentoPedidoNovo)).thenReturn(acompanhamentoPedidos.get(0));
    }

    @Test
    @DisplayName("Cadastrou acompanhamento do pedido com sucesso!")
    void salvarTeste(){

        Acompanhamento acompanhamento = new Acompanhamento(1L,true,"COCA COLA 1L", 12L);
        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);
        Cliente cliente = new Cliente(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",enderecos,user);
        Funcionario funcionario = new Funcionario(1L,true,"Pedro Henrique Vieira","10250870975","45998265476", user);
        Pedido pedido = new Pedido();

        AcompanhamentoPedidoDTO acompanhamentoPedidoDTO = new AcompanhamentoPedidoDTO(1L,acompanhamento,2,"");

        var acompanhamentoPedido = controller.salvar(acompanhamentoPedidoDTO);

        Assertions.assertEquals(1L,acompanhamentoPedido.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED,acompanhamentoPedido.getStatusCode());
    }

    @Test
    @DisplayName("Buscou acompanhamento do pedido por id")
    void buscarPorIdTest(){

        var acompanhamentoPedido = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, acompanhamentoPedido.getBody().getId());
        Assertions.assertEquals(HttpStatus.OK,acompanhamentoPedido.getStatusCode());
    }

    @Test
    @DisplayName("Listar todos os acompanhamentos do pedido")
    void listarTodosTest(){

        var acompanhamentoPedido = controller.listarTodos();
        List<AcompanhamentoPedido> acompanhamentoPedidos = acompanhamentoPedido.getBody();

        Assertions.assertEquals(HttpStatus.OK, acompanhamentoPedido.getStatusCode());
        Assertions.assertEquals("COCA COLA 1L", acompanhamentoPedidos.get(0).getAcompanhamento().getDescricao());
        Assertions.assertEquals(1,acompanhamentoPedidos.size());
    }

    @Test
    @DisplayName("Editou o acompanhamento do pedido com sucesso!")
    void atualizarTeste(){

        Acompanhamento acompanhamento = new Acompanhamento(1L,true,"COCA COLA 1L", 12L);
        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);
        Cliente cliente = new Cliente(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",enderecos,user);
        Funcionario funcionario = new Funcionario(1L,true,"Pedro Henrique Vieira","10250870975","45998265476", user);
        Pedido pedido = new Pedido();

        AcompanhamentoPedidoDTO acompanhamentoPedidoDTO = new AcompanhamentoPedidoDTO(1L,acompanhamento,3,"");

        var acompanhamentoPedido = controller.atualizar(acompanhamentoPedidoDTO.id(),acompanhamentoPedidoDTO);

        Assertions.assertEquals(HttpStatus.OK,acompanhamentoPedido.getStatusCode());
        Assertions.assertEquals("COCA COLA 1L", acompanhamentoPedido.getBody().getAcompanhamento().getDescricao());
        Assertions.assertEquals(3L, acompanhamentoPedido.getBody().getQuantidade(),0);

    }

    @Test
    @DisplayName("Deletou o acompanhamento do pedido com sucesso!")
    void deletarTest(){

        var acompanhamentoPedidoDeletado = controller.deletar(1L);

        Assertions.assertEquals(HttpStatus.OK, acompanhamentoPedidoDeletado.getStatusCode());
    }
}
