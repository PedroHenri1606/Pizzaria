package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.controller.ClienteController;
import com.piazzariap1.pizzaria.controller.FuncionarioController;
import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.entity.Funcionario;
import com.piazzariap1.pizzaria.repository.FuncionarioRepository;
import com.piazzariap1.pizzaria.service.implementada.FuncionarioServiceImpl;
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
class FuncionarioTest {

    @MockBean
    FuncionarioRepository repository;

    @Autowired
    FuncionarioController controller;

    @Autowired
    FuncionarioServiceImpl service;

    @BeforeEach
    void injectData(){

        //BANCO DE DADOS
        Funcionario funcionario = new Funcionario(1L,"PEDRO HENRIQUE VIEIRA","10250870975","45998265476");

        //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
        when(repository.save(Mockito.any(Funcionario.class))).thenAnswer(invocation -> {
            Funcionario funcionarioSalvo = invocation.getArgument(0);
            funcionarioSalvo.setId(2L);
            return funcionarioSalvo;
        });

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario);

        //TESTAR BUSCAR POR ID
        when(repository.findById(funcionario.getId())).thenReturn(Optional.of(funcionario));

        //TESTAR BUSCAR POR NOME
        when(repository.findByNome(funcionario.getNome())).thenReturn(funcionarios);

        //TESTAR BUSCAR POR CPF
        when(repository.findByCpf(funcionario.getCpf())).thenReturn(funcionarios);

        //TESTAR BUSCAR COMECANDO COM
        String comecando = "PEDRO";
        when(repository.findByNomeStartingWith(comecando)).thenReturn(funcionarios);

        //TESTAR BUSCAR TERMINANDO COM
        String terminando = "VIEIRA";
        when(repository.findByNomeEndingWith(terminando)).thenReturn(funcionarios);

        //TESTAR BUSCAR CONTENDO
        String contendo = "HENRIQUE";
        when(repository.findByNomeContaining(contendo)).thenReturn(funcionarios);

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(funcionarios);

        //TESTAR ATUALIZAR
        Funcionario funcionarioNovo = new Funcionario(1L,"PEDRO HENRIQUE", "10250870975","45998111111");
        when(repository.save(funcionarioNovo)).thenReturn(funcionarios.get(0));
    }

    @Test
    @DisplayName("Cadastrou funcionario com sucesso!")
    void cadastrarTest(){

        var funcionarioDTO = controller.salvar(new FuncionarioDTO(1L,"PEDRO HENRIQUE VIEIRA","91148302999","45998265476"));

        Assertions.assertEquals(HttpStatus.CREATED, funcionarioDTO.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", funcionarioDTO.getBody().getNome());
        Assertions.assertNotNull(funcionarioDTO.getBody().getId());
    }

    @Test
    @DisplayName("Buscou funcionario por id!")
    void buscarPorIdTest(){

        var cliente = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, cliente.getBody().getId());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", cliente.getBody().getNome());
        Assertions.assertEquals(HttpStatus.OK,cliente.getStatusCode());
    }

    @Test
    @DisplayName("Buscou funcionario por nome!")
    void bucarOndeNomeTest(){

        var funcionario = controller.buscarOndeNome("PEDRO HENRIQUE VIEIRA");
        List<Funcionario> funcionarios = funcionario.getBody();

        Assertions.assertEquals(HttpStatus.OK, funcionario.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", funcionarios.get(0).getNome());
        Assertions.assertEquals(1L,funcionarios.size());
    }

    @Test
    @DisplayName("Buscou funcionario por cpf!")
    void bucarOndeCPFTest(){

        var funcionario = controller.buscarOndeCpf("10250870975");
        List<Funcionario> funcionarios = funcionario.getBody();

        Assertions.assertEquals(HttpStatus.OK, funcionario.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", funcionarios.get(0).getNome());
        Assertions.assertEquals(1L,funcionarios.size());
    }

    @Test
    @DisplayName("Buscou funcionario comecando pelo conteudo!")
    void bucarClienteComecandoTest(){

        var funcionario = controller.buscarFuncionarioComecando("PEDRO");
        List<Funcionario> funcionarios = funcionario.getBody();

        Assertions.assertEquals(HttpStatus.OK, funcionario.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", funcionarios.get(0).getNome());
        Assertions.assertEquals(1L,funcionarios.size());
    }

    @Test
    @DisplayName("Buscou funcionario terminando pelo conteudo!")
    void bucarClienteTerminandoTest(){

        var funcionario = controller.buscarFuncionarioTerminando("VIEIRA");
        List<Funcionario> funcionarios = funcionario.getBody();

        Assertions.assertEquals(HttpStatus.OK, funcionario.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", funcionarios.get(0).getNome());
        Assertions.assertEquals(1L,funcionarios.size());
    }

    @Test
    @DisplayName("Buscou funcionario contendo o conteudo!")
    void bucarClienteContendoTest(){

        var funcionario = controller.buscarFuncionarioContendo("HENRIQUE");
        List<Funcionario> funcionarios = funcionario.getBody();

        Assertions.assertEquals(HttpStatus.OK, funcionario.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", funcionarios.get(0).getNome());
        Assertions.assertEquals(1L,funcionarios.size());
    }

    @Test
    @DisplayName("Buscou todos os funcionario!")
    void listarTodosTest(){

        var funcionario = controller.listarTodos();
        List<Funcionario> funcionarios = funcionario.getBody();

        Assertions.assertEquals(HttpStatus.OK, funcionario.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", funcionarios.get(0).getNome());
        Assertions.assertEquals(1L,funcionarios.size());
    }

    @Test
    @DisplayName("Editou o funcionario som sucesso!")
    void atualizarTest(){

        var funcioanarioNovo = controller.atualizar(1L,new FuncionarioDTO(1L,"PEDRO HENRIQUE", "10250870975","45998111111"));

        Assertions.assertEquals(HttpStatus.OK, funcioanarioNovo.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE", funcioanarioNovo.getBody().getNome());
    }

    @Test
    @DisplayName("Deletou o funcionario com sucesso!")
    void deletarTest(){

        var funcionarioDeletado = controller.deletar(1L);

        Assertions.assertEquals(HttpStatus.OK, funcionarioDeletado.getStatusCode());
    }
}
