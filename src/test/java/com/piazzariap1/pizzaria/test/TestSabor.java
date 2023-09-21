package com.piazzariap1.pizzaria.test;

import com.piazzariap1.pizzaria.controller.SaborController;
import com.piazzariap1.pizzaria.dto.SaborDTO;
import com.piazzariap1.pizzaria.entity.Sabor;
import com.piazzariap1.pizzaria.repository.SaborRepository;
import com.piazzariap1.pizzaria.test.implementada.SaborServiceImpl;
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
class TestSabor {

    @MockBean
    SaborRepository repository;

    @Autowired
    SaborServiceImpl service;

    @Autowired
    SaborController controller;

    @BeforeEach
    void injectData(){

        Sabor sabor = new Sabor(1L, "4 QUEIJOS","QUEIJO QUEIJO QUEIJO E QUEIJO");

        //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
        when(repository.save(Mockito.any(Sabor.class))).thenAnswer(invocation -> {
            Sabor saborSalvo = invocation.getArgument(0);
            saborSalvo.setId(1L);
            return saborSalvo;
        });

        List<Sabor> sabores = new ArrayList<>();
        sabores.add(sabor);

        //TESTAR BUSCAR POR ID
        when(repository.findById(sabor.getId())).thenReturn(Optional.of(sabor));

        //TESTAR BUSCAR POR NOME
        when(repository.findByNome(sabor.getNome())).thenReturn(sabores);

        //TESTAR BUSCAR COMECANDO COM
        String comecando = "4";
        when(repository.findByNomeStartingWith(comecando)).thenReturn(sabores);

        //TESTAR BUSCAR TERMINANDO COM
        String terminando = "QUEIJOS";
        when(repository.findByNomeEndingWith(terminando)).thenReturn(sabores);

        //TESTAR BUSCAR CONTENDO
        String contendo = "IJ";
        when(repository.findByNomeContaining(contendo)).thenReturn(sabores);

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(sabores);

        //TESTAR ATUALIZAR
        Sabor saborNovo = new Sabor(1L, "3 QUEIJOS","QUEIJO QUEIJO E QUEIJO");
        when(repository.save(saborNovo)).thenReturn(sabores.get(0));
    }

    @Test
    @DisplayName("Cadastrou sabor com sucesso!")
    void salvarTest(){

        SaborDTO sabor = new SaborDTO(1L, "4 QUEIJOS","QUEIJO QUEIJO QUEIJO E QUEIJO");
        var produto = controller.salvar(sabor);

        Assertions.assertEquals(HttpStatus.CREATED, produto.getStatusCode());
        Assertions.assertNotNull(produto.getBody().getId());
        Assertions.assertEquals("4 QUEIJOS", produto.getBody().getNome());
    }

    @Test
    @DisplayName("Buscou sabor por id!")
    void buscarPorIdTest(){

        var sabor = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, sabor.getBody().getId());
        Assertions.assertEquals(HttpStatus.OK,sabor.getStatusCode());

    }

    @Test
    @DisplayName("Buscou sabor por nome!")
    void bucarOndeNomeTest(){

        var sabor = controller.buscarOndeNome("4 QUEIJOS");
        List<Sabor> sabores = sabor.getBody();

        Assertions.assertEquals(HttpStatus.OK, sabor.getStatusCode());
        Assertions.assertEquals(1L,sabores.size());
    }

    @Test
    @DisplayName("Buscou sabor comecando com conteudo!")
    void buscarSaborComecandoTest(){

        var sabor = controller.buscarSaborComecando("4");
        List<Sabor> sabores = sabor.getBody();

        Assertions.assertEquals(HttpStatus.OK, sabor.getStatusCode());
        Assertions.assertEquals("4 QUEIJOS", sabores.get(0).getNome());
        Assertions.assertEquals(1, sabores.size());
    }

    @Test
    @DisplayName("Buscou sabor terminando com conteudo!")
    void buscarSaborTerminandoTest(){

        var sabor = controller.buscarSaborTerminando("QUEIJOS");
        List<Sabor> produtos = sabor.getBody();

        Assertions.assertEquals(HttpStatus.OK, sabor.getStatusCode());
        Assertions.assertEquals("4 QUEIJOS", produtos.get(0).getNome());
        Assertions.assertEquals(1,produtos.size());

    }

    @Test
    @DisplayName("Buscou produto contendo o conteudo!")
    void buscarSaborContendoTest(){

        var sabor = controller.buscarSaborContendo("IJ");
        List<Sabor> sabores = sabor.getBody();

        Assertions.assertEquals(HttpStatus.OK, sabor.getStatusCode());
        Assertions.assertEquals("4 QUEIJOS", sabores.get(0).getNome());
        Assertions.assertEquals(1,sabores.size());

    }

    @Test
    @DisplayName("Buscou todos os sabores!")
    void listarTodosTest(){

        var sabor = controller.listarTodos();
        List<Sabor> sabores = sabor.getBody();

        Assertions.assertEquals(HttpStatus.OK, sabor.getStatusCode());
        Assertions.assertEquals("4 QUEIJOS", sabores.get(0).getNome());
        Assertions.assertEquals(1,sabores.size());

    }

    @Test
    @DisplayName("Editou o sabor som sucesso!")
    void atualizarTest(){

        SaborDTO saborNovo = new SaborDTO(1L, "3 QUEIJOS","QUEIJO QUEIJO E QUEIJO");


        var produtoNovo = controller.atualizar(saborNovo.getId(),saborNovo);


        Assertions.assertEquals(HttpStatus.OK,produtoNovo.getStatusCode());
        Assertions.assertEquals("3 QUEIJOS", produtoNovo.getBody().getNome());
    }

    @Test
    @DisplayName("Deletou o sabor com sucesso!")
    void deletarTest(){

        var saborDeletado = controller.deletar(1L);

        Assertions.assertEquals(HttpStatus.OK, saborDeletado.getStatusCode());
    }

}
