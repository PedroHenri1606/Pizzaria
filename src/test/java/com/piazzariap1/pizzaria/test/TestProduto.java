package com.piazzariap1.pizzaria.test;

import com.piazzariap1.pizzaria.controller.ProdutoController;
import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.*;
import com.piazzariap1.pizzaria.entity.enuns.TamanhoProduto;
import com.piazzariap1.pizzaria.repository.ProdutoRepository;
import com.piazzariap1.pizzaria.test.implementada.ProdutoServiceImpl;
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
class TestProduto {

    @MockBean
    ProdutoRepository repository;

    @Autowired
    ProdutoServiceImpl service;

    @Autowired
    ProdutoController controller;

    @BeforeEach
    void injectData(){

        //BANCO DE DADOS
        Produto produto = new Produto(1L, "PIZZA GG",65L, TamanhoProduto.GG);

        //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
        when(repository.save(Mockito.any(Produto.class))).thenAnswer(invocation -> {
            Produto produtoSalvo = invocation.getArgument(0);
            produtoSalvo.setId(1L);
            return produtoSalvo;
        });

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);

        //TESTAR BUSCAR POR ID
        when(repository.findById(produto.getId())).thenReturn(Optional.of(produto));

        //TESTAR BUSCAR POR VALOR
        when(repository.findByValor(produto.getValor())).thenReturn(produtos);

        //TESTAR BUSCAR POR DESCRICAO
        when(repository.findByDescricao(produto.getDescricao())).thenReturn(produtos);

        //TESTAR BUSCAR COMECANDO COM
        String comecando = "PIZ";
        when(repository.findByDescricaoStartingWith(comecando)).thenReturn(produtos);

        //TESTAR BUSCAR TERMINANDO COM
        String terminando = "GG";
        when(repository.findByDescricaoEndingWith(terminando)).thenReturn(produtos);

        //TESTAR BUSCAR CONTENDO
        String contendo = "ZZA";
        when(repository.findByDescricaoContaining(contendo)).thenReturn(produtos);

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(produtos);

        //TESTAR ATUALIZAR
        Produto produtoNovo = new Produto(1L, "PIZZA M",40L, TamanhoProduto.M);
        when(repository.save(produtoNovo)).thenReturn(produtos.get(0));
    }

    @Test
    @DisplayName("Cadastrou produto com sucesso!")
    void salvarTest(){

        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "PIZZA GG",65L, TamanhoProduto.GG);
        var produto = controller.salvar(produtoDTO);

        Assertions.assertEquals(HttpStatus.CREATED, produto.getStatusCode());
        Assertions.assertNotNull(produto.getBody().getId());
        Assertions.assertEquals("PIZZA GG", produto.getBody().getDescricao());
    }

    @Test
    @DisplayName("Buscou produto por id!")
    void buscarPorIdTest(){

        var produto = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, produto.getBody().getId());
        Assertions.assertEquals(HttpStatus.OK,produto.getStatusCode());

    }

    @Test
    @DisplayName("Buscou produto por descrição!")
    void bucarOndeDescricaoTest(){

        var produto = controller.buscarOndeDescricao("PIZZA GG");
        List<Produto> produtos = produto.getBody();

        Assertions.assertEquals(HttpStatus.OK, produto.getStatusCode());
        Assertions.assertEquals(1L,produtos.size());
    }

    @Test
    @DisplayName("Buscou produto por valor!")
    void buscarOndeValorTest(){

        var produto = controller.buscarOndeValor(65L);
        List<Produto> produtos = produto.getBody();

        Assertions.assertEquals(HttpStatus.OK, produto.getStatusCode());
        Assertions.assertEquals(65L, produtos.get(0).getValor());
        Assertions.assertEquals(1, produtos.size());
    }

    @Test
    @DisplayName("Buscou produto comecando com conteudo!")
    void buscarProdutoComecandoTest(){

        var produto = controller.buscarProdutoComecando("PIZ");
        List<Produto> produtos = produto.getBody();

        Assertions.assertEquals(HttpStatus.OK, produto.getStatusCode());
        Assertions.assertEquals("PIZZA GG", produtos.get(0).getDescricao());
        Assertions.assertEquals(1, produtos.size());
    }

    @Test
    @DisplayName("Buscou produto terminando com conteudo!")
    void buscarProdutoTerminandoTest(){

        var produto = controller.buscarProdutoTerminando("GG");
        List<Produto> produtos = produto.getBody();

        Assertions.assertEquals(HttpStatus.OK, produto.getStatusCode());
        Assertions.assertEquals("PIZZA GG", produtos.get(0).getDescricao());
        Assertions.assertEquals(1,produtos.size());

    }

    @Test
    @DisplayName("Buscou produto contendo o conteudo!")
    void buscarProdutoContendoTest(){

        var produto = controller.buscarProdutoContendo("ZZA");
        List<Produto> produtos = produto.getBody();

        Assertions.assertEquals(HttpStatus.OK, produto.getStatusCode());
        Assertions.assertEquals("PIZZA GG", produtos.get(0).getDescricao());
        Assertions.assertEquals(1,produtos.size());

    }

    @Test
    @DisplayName("Buscou todos os produto!")
    void listarTodosTest(){

        var produto = controller.listarTodos();
        List<Produto> produtos = produto.getBody();

        Assertions.assertEquals(HttpStatus.OK, produto.getStatusCode());
        Assertions.assertEquals("PIZZA GG", produtos.get(0).getDescricao());
        Assertions.assertEquals(1,produtos.size());

    }

    @Test
    @DisplayName("Editou o produto som sucesso!")
    void atualizarTest(){

        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "PIZZA M",40L, TamanhoProduto.M);

        var produtoNovo = controller.atualizar(produtoDTO.getId(),produtoDTO);



        Assertions.assertEquals(HttpStatus.OK,produtoNovo.getStatusCode());
        Assertions.assertEquals("PIZZA M", produtoNovo.getBody().getDescricao());
    }

    @Test
    @DisplayName("Deletou o produto com sucesso!")
    void deletarTest(){

        var produtoDeletado = controller.deletar(1L);

        Assertions.assertEquals(HttpStatus.OK, produtoDeletado.getStatusCode());
    }
}
