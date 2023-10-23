package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.FormaDePagamento;
import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
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
class TestProdutoPedido {

    @MockBean
    ProdutoPedidoRepository repository;

    @Autowired
    ProdutoPedidoServiceImpl service;

    @Autowired
    ProdutoPedidoController controller;

    @BeforeEach
    void injectData(){

        Produto produto = new Produto(1L,"PIZZA GG",65L, TamanhoProduto.GG);
        Sabor sabor = new Sabor(1L,"4 QUEIJOS","QUEIJO, QUEIJO, QUEIJO E QUEIJO");
        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Funcionario funcionario = new Funcionario(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Pedido pedido = new Pedido(1L,cliente,funcionario,"",true, FormaDePagamento.PIX);

        Set<Sabor> sabores = new HashSet<>();
        sabores.add(sabor);

        //BANCO DE DADOS
        ProdutoPedido produtoPedido = new ProdutoPedido(1L,produto,2,sabores,pedido);

        //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
        when(repository.save(Mockito.any(ProdutoPedido.class))).thenAnswer(invocation -> {
            ProdutoPedido produtoPedidoSalvo = invocation.getArgument(0);
            produtoPedidoSalvo.setId(1L);
            return produtoPedidoSalvo;
        });

        //TESTAR BUSCAR POR ID
        when(repository.findById(produtoPedido.getId())).thenReturn(Optional.of(produtoPedido));

        List<ProdutoPedido> produtosPedido = new ArrayList<>();
        produtosPedido.add(produtoPedido);

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(produtosPedido);

        //TESTAR ATUALIZAR
        ProdutoPedido produtoPedidoNovo = new ProdutoPedido(1L,produto,3,sabores,pedido);
        when(repository.save(produtoPedidoNovo)).thenReturn(produtosPedido.get(0));

    }

    @Test
    @DisplayName("Cadastrou produto do pedido com sucesso!")
    void salvarTeste(){

        Produto produto = new Produto(1L,"PIZZA GG",65L, TamanhoProduto.GG);
        Sabor sabor = new Sabor(1L,"4 QUEIJOS","QUEIJO, QUEIJO, QUEIJO E QUEIJO");
        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Funcionario funcionario = new Funcionario(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Pedido pedido = new Pedido(1L,cliente,funcionario,"",true, FormaDePagamento.PIX);

        Set<Sabor> sabores = new HashSet<>();
        sabores.add(sabor);

        ProdutoPedidoDTO produtoPedidoDTO = new ProdutoPedidoDTO(1L,produto,2,sabores,pedido);

        var produtoPedido = controller.salvar(produtoPedidoDTO);

        Assertions.assertEquals(1L,produtoPedido.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED,produtoPedido.getStatusCode());
    }

    @Test
    @DisplayName("Buscou produto do pedido por id")
    void buscarPorIdTest(){

        var acompanhamentoPedido = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, acompanhamentoPedido.getBody().getId());
        Assertions.assertEquals(HttpStatus.OK,acompanhamentoPedido.getStatusCode());
    }

    @Test
    @DisplayName("Listar todos os produto do pedido")
    void listarTodosTest(){

        var produtoPedido = controller.listarTodos();
        List<ProdutoPedido> produtosPedido = produtoPedido.getBody();

        Assertions.assertEquals(HttpStatus.OK, produtoPedido.getStatusCode());
        Assertions.assertEquals("PIZZA GG", produtosPedido.get(0).getProduto().getDescricao());
        Assertions.assertEquals(1,produtosPedido.size());
    }

    @Test
    @DisplayName("Editou o produto do pedido com sucesso!")
    void atualizarTeste(){

        Produto produto = new Produto(1L,"PIZZA GG",65L, TamanhoProduto.GG);
        Sabor sabor = new Sabor(1L,"4 QUEIJOS","QUEIJO, QUEIJO, QUEIJO E QUEIJO");
        Cliente cliente = new Cliente(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Funcionario funcionario = new Funcionario(1L,"Pedro Henrique Vieira","10250870975","45998265476");
        Pedido pedido = new Pedido(1L,cliente,funcionario,"",true, FormaDePagamento.PIX);

        Set<Sabor> sabores = new HashSet<>();
        sabores.add(sabor);

        ProdutoPedidoDTO produtoPedidoDTO = new ProdutoPedidoDTO(1L,produto,1,sabores,pedido);

        var acompanhamentoPedido = controller.atualizar(produtoPedidoDTO.getId(),produtoPedidoDTO);

        Assertions.assertEquals(HttpStatus.OK,acompanhamentoPedido.getStatusCode());
        Assertions.assertEquals("PIZZA GG", acompanhamentoPedido.getBody().getProduto().getDescricao());
        Assertions.assertEquals(1L, acompanhamentoPedido.getBody().getQuantidade(),0);

    }

    @Test
    @DisplayName("Deletou o produto do pedido com sucesso!")
    void deletarTest(){

        var acompanhamentoPedidoDeletado = controller.deletar(1L);

        Assertions.assertEquals(HttpStatus.OK, acompanhamentoPedidoDeletado.getStatusCode());
    }
}
