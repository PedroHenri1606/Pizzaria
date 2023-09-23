package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.controller.PedidoController;
import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.repository.PedidoRepository;
import com.piazzariap1.pizzaria.service.implementada.PedidoServiceImpl;
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
class TestPedido {

    @MockBean
    PedidoRepository repository;

    @Autowired
    PedidoServiceImpl service;

    @Autowired
    PedidoController controller;

    @BeforeEach
    void injectData(){

        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Funcionario funcionario = new Funcionario(1L,"Pedro Henrique Vieira","10250870975","45998265476");

        //BANCO DE DADOS
        Pedido pedido = new Pedido(1L,cliente,funcionario,"",true, FormaDePagamento.PIX);

        //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
        when(repository.save(Mockito.any(Pedido.class))).thenAnswer(invocation -> {
            Pedido pedidoSalvo = invocation.getArgument(0);
            pedidoSalvo.setId(1L);
            return pedidoSalvo;
        });

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);

        //TESTAR BUSCAR POR ID
        when(repository.findById(pedido.getId())).thenReturn(Optional.of(pedido));

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(pedidos);

        //TESTAR ATUALIZAR
        Pedido pedidoNovo = new Pedido(1L,cliente,funcionario,"",true,FormaDePagamento.CARTAO_DEBITO);
        when(repository.save(pedidoNovo)).thenReturn(pedidos.get(0));
    }

    @Test
    @DisplayName("Cadastrou pedido com sucesso!")
    void salvarTeste(){

        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Funcionario funcionario = new Funcionario(1L,"Pedro Henrique Vieira","10250870975","45998265476");

        var pedido = controller.salvar(new PedidoDTO(1L,cliente,funcionario,"",true, FormaDePagamento.PIX));

        Assertions.assertEquals(1L,pedido.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED,pedido.getStatusCode());
    }

    @Test
    @DisplayName("Buscou pedido por id")
    void buscarPorIdTest(){

        var pedido = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, pedido.getBody().getId());
        Assertions.assertEquals(HttpStatus.OK,pedido.getStatusCode());
    }

    @Test
    @DisplayName("Listar todos os pedidos")
    void listarTodosTest(){

        var pedido = controller.listarTodos();
        List<Pedido> pedidos = pedido.getBody();

        Assertions.assertEquals(HttpStatus.OK, pedido.getStatusCode());
        Assertions.assertEquals(FormaDePagamento.PIX, pedidos.get(0).getFormaDePagamento());
        Assertions.assertEquals(1,pedidos.size());
    }

    @Test
    @DisplayName("Editou o pedido com sucesso!")
    void atualizarTeste(){

        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Funcionario funcionario = new Funcionario(1L,"Pedro Henrique Vieira","10250870975","45998265476");

        PedidoDTO pedidoDTO = new PedidoDTO(1L,cliente,funcionario,"",true, FormaDePagamento.CARTAO_DEBITO);

        var pedido = controller.atualizar(pedidoDTO.getId(),pedidoDTO);

        Assertions.assertEquals(HttpStatus.OK,pedido.getStatusCode());
        Assertions.assertEquals(FormaDePagamento.CARTAO_DEBITO, pedido.getBody().getFormaDePagamento());
    }
}
