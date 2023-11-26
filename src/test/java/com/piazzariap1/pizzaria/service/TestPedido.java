package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.controller.PedidoController;
import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.Roles;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;
import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
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

import java.util.*;

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

        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);
        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        Cliente cliente = new Cliente(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",enderecos,user);
        Funcionario funcionario = new Funcionario(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",user);

        Sabor sabor = new Sabor(1L,true, "4 QUEIJOS","QUEIJO QUEIJO QUEIJO E QUEIJO");
        Set<Sabor> sabores = new HashSet<>();
        sabores.add(sabor);

        Produto produto = new Produto(1L,true,"PIZZA GG",65L, TamanhoProduto.GG);
        ProdutoPedido produtoPedido = new ProdutoPedido(1L,produto,1,"",sabores);
        Set<ProdutoPedido> produtoPedidos = new HashSet<>();
        produtoPedidos.add(produtoPedido);

        Acompanhamento acompanhamento = new Acompanhamento(1L,true,"COCA COLA 1L", 12L);
        AcompanhamentoPedido acompanhamentoPedido = new AcompanhamentoPedido(1L,acompanhamento,2,"");
        Set<AcompanhamentoPedido> acompanhamentoPedidos = new HashSet<>();
        acompanhamentoPedidos.add(acompanhamentoPedido);

        //BANCO DE DADOS
        Pedido pedido = new Pedido(1L,cliente,produtoPedidos,acompanhamentoPedidos,endereco,funcionario,"",true,true, SituacaoPedido.EM_ABERTO,FormaDePagamento.PIX,100L);

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
        Pedido pedidoNovo = new Pedido(1L,cliente,produtoPedidos,acompanhamentoPedidos,endereco,funcionario,"",true,true, SituacaoPedido.EM_ABERTO,FormaDePagamento.PIX,100L);
        when(repository.save(pedidoNovo)).thenReturn(pedidos.get(0));
    }

    @Test
    @DisplayName("Cadastrou pedido com sucesso!")
    void salvarTeste(){

        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);
        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        Cliente cliente = new Cliente(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",enderecos,user);
        Funcionario funcionario = new Funcionario(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",user);

        Sabor sabor = new Sabor(1L,true, "4 QUEIJOS","QUEIJO QUEIJO QUEIJO E QUEIJO");
        Set<Sabor> sabores = new HashSet<>();
        sabores.add(sabor);

        Produto produto = new Produto(1L,true,"PIZZA GG",65L, TamanhoProduto.GG);
        ProdutoPedido produtoPedido = new ProdutoPedido(1L,produto,1,"",sabores);
        Set<ProdutoPedido> produtoPedidos = new HashSet<>();
        produtoPedidos.add(produtoPedido);

        Acompanhamento acompanhamento = new Acompanhamento(1L,true,"COCA COLA 1L", 12L);
        AcompanhamentoPedido acompanhamentoPedido = new AcompanhamentoPedido(1L,acompanhamento,2,"");
        Set<AcompanhamentoPedido> acompanhamentoPedidos = new HashSet<>();
        acompanhamentoPedidos.add(acompanhamentoPedido);

        var pedido = controller.salvar(new PedidoDTO(1L,cliente,produtoPedidos,acompanhamentoPedidos,endereco,funcionario,"",true,true, SituacaoPedido.EM_ABERTO,FormaDePagamento.PIX,100L));

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

        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);
        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        Cliente cliente = new Cliente(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",enderecos,user);
        Funcionario funcionario = new Funcionario(1L,true,"Pedro Henrique Vieira","10250870975","45998265476",user);

        Sabor sabor = new Sabor(1L,true, "4 QUEIJOS","QUEIJO QUEIJO QUEIJO E QUEIJO");
        Set<Sabor> sabores = new HashSet<>();
        sabores.add(sabor);

        Produto produto = new Produto(1L,true,"PIZZA GG",65L, TamanhoProduto.GG);
        ProdutoPedido produtoPedido = new ProdutoPedido(1L,produto,1,"",sabores);
        Set<ProdutoPedido> produtoPedidos = new HashSet<>();
        produtoPedidos.add(produtoPedido);

        Acompanhamento acompanhamento = new Acompanhamento(1L,true,"COCA COLA 1L", 12L);
        AcompanhamentoPedido acompanhamentoPedido = new AcompanhamentoPedido(1L,acompanhamento,2,"");
        Set<AcompanhamentoPedido> acompanhamentoPedidos = new HashSet<>();
        acompanhamentoPedidos.add(acompanhamentoPedido);

        PedidoDTO pedidoDTO = new PedidoDTO(1L,cliente,produtoPedidos,acompanhamentoPedidos,endereco,funcionario,"",true,true, SituacaoPedido.EM_ABERTO,FormaDePagamento.CARTAO_DEBITO,100L);;

        var pedido = controller.atualizar(pedidoDTO.id(),pedidoDTO);

        Assertions.assertEquals(HttpStatus.OK,pedido.getStatusCode());
        Assertions.assertEquals(FormaDePagamento.CARTAO_DEBITO, pedido.getBody().getFormaDePagamento());
    }
}
