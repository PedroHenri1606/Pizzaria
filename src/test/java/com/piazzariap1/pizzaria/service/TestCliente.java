package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.controller.ClienteController;
import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.entity.Endereco;
import com.piazzariap1.pizzaria.entity.UserEntity;
import com.piazzariap1.pizzaria.entity.enuns.Roles;
import com.piazzariap1.pizzaria.repository.ClienteRepository;
import com.piazzariap1.pizzaria.service.implementada.ClienteServiceImpl;
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
class TestCliente {

    @MockBean
    ClienteRepository repository;

    @Autowired
    ClienteController controller;

    @Autowired
    ClienteServiceImpl service;

    @BeforeEach
    void injectData(){

        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);

        //BANCO DE DADOS
        Cliente cliente = new Cliente(1L,true,"PEDRO HENRIQUE VIEIRA","10250870975","45998265476",enderecos,user);


        //INSERÇÃO MANUAL PARA TESTAR CADASTRAR
        when(repository.save(Mockito.any(Cliente.class))).thenAnswer(invocation -> {
            Cliente clienteSalvo = invocation.getArgument(0);
            clienteSalvo.setId(2L);
            return clienteSalvo;
        });

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);

        //TESTAR BUSCAR POR ID
        when(repository.findById(cliente.getId())).thenReturn(Optional.of(cliente));

        //TESTAR BUSCAR POR NOME
        when(repository.findByNome(cliente.getNome())).thenReturn(clientes);

        //TESTAR BUSCAR POR CPF
        when(repository.findByCpf(cliente.getCpf())).thenReturn(clientes);

        //TESTAR BUSCAR COMECANDO COM
        String comecando = "PEDRO";
        when(repository.findByNomeStartingWith(comecando)).thenReturn(clientes);

        //TESTAR BUSCAR TERMINANDO COM
        String terminando = "VIEIRA";
        when(repository.findByNomeEndingWith(terminando)).thenReturn(clientes);

        //TESTAR BUSCAR CONTENDO
        String contendo = "HENRIQUE";
        when(repository.findByNomeContaining(contendo)).thenReturn(clientes);

        //TESTAR LISTAR TODOS
        when(repository.findAll()).thenReturn(clientes);

        //TESTAR ATUALIZAR
        Cliente clienteNovo = new Cliente(1L,true,"PEDRO HENRIQUE", "10250870975","45998111111",enderecos,user);
        when(repository.save(clienteNovo)).thenReturn(clientes.get(0));
    }

    @Test
    @DisplayName("Cadastrou cliente com sucesso!")
    void cadastrarTest(){

        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);

        var clienteDTO = controller.salvar(new ClienteDTO(1L,true,"PEDRO HENRIQUE", "51454781009","45998111111",enderecos,user));

        Assertions.assertEquals(HttpStatus.CREATED, clienteDTO.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE", clienteDTO.getBody().getNome());
        Assertions.assertNotNull(clienteDTO.getBody().getId());
    }

    @Test
    @DisplayName("Buscou cliente por id!")
    void buscarPorIdTest(){

        var cliente = controller.buscarOndeId(1L);

        Assertions.assertEquals(1L, cliente.getBody().getId());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", cliente.getBody().getNome());
        Assertions.assertEquals(HttpStatus.OK,cliente.getStatusCode());
    }

    @Test
    @DisplayName("Buscou cliente por nome!")
    void bucarOndeNomeTest(){

        var cliente = controller.buscarOndeNome("PEDRO HENRIQUE VIEIRA");
        List<Cliente> clientes = cliente.getBody();

        Assertions.assertEquals(HttpStatus.OK, cliente.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", clientes.get(0).getNome());
        Assertions.assertEquals(1L,clientes.size());
    }

    @Test
    @DisplayName("Buscou cliente por cpf!")
    void bucarOndeCPFTest(){

        var cliente = controller.buscarOndeCpf("10250870975");
        List<Cliente> clientes = cliente.getBody();

        Assertions.assertEquals(HttpStatus.OK, cliente.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", clientes.get(0).getNome());
        Assertions.assertEquals(1L,clientes.size());
    }

    @Test
    @DisplayName("Buscou cliente comecando pelo conteudo!")
    void bucarClienteComecandoTest(){

        var cliente = controller.buscarClienteComecando("PEDRO");
        List<Cliente> clientes = cliente.getBody();

        Assertions.assertEquals(HttpStatus.OK, cliente.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", clientes.get(0).getNome());
        Assertions.assertEquals(1L,clientes.size());
    }

    @Test
    @DisplayName("Buscou cliente terminando pelo conteudo!")
    void bucarClienteTerminandoTest(){

        var cliente = controller.buscarClienteTerminando("VIEIRA");
        List<Cliente> clientes = cliente.getBody();

        Assertions.assertEquals(HttpStatus.OK, cliente.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", clientes.get(0).getNome());
        Assertions.assertEquals(1L,clientes.size());
    }

    @Test
    @DisplayName("Buscou cliente contendo o conteudo!")
    void bucarClienteContendoTest(){

        var cliente = controller.buscarClienteContendo("HENRIQUE");
        List<Cliente> clientes = cliente.getBody();

        Assertions.assertEquals(HttpStatus.OK, cliente.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", clientes.get(0).getNome());
        Assertions.assertEquals(1L,clientes.size());
    }

    @Test
    @DisplayName("Buscou todos os clientes!")
    void listarTodosTest(){

        var cliente = controller.listarTodos();
        List<Cliente> clientes = cliente.getBody();

        Assertions.assertEquals(HttpStatus.OK, cliente.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE VIEIRA", clientes.get(0).getNome());
        Assertions.assertEquals(1L,clientes.size());
    }

    @Test
    @DisplayName("Editou o cliente som sucesso!")
    void atualizarTest(){

        Endereco endereco = new Endereco(1L,"85859340","MORUMBI II","BELMIRO",2);
        Set<Endereco> enderecos = new HashSet<>();
        enderecos.add(endereco);
        UserEntity user = new UserEntity(1L,"pedro","123", Roles.CLIENTE);

        var clienteNovo = controller.atualizar(1L,new ClienteDTO(1L,true,"PEDRO HENRIQUE", "10250870975","45998111111",enderecos,user));

        Assertions.assertEquals(HttpStatus.OK, clienteNovo.getStatusCode());
        Assertions.assertEquals("PEDRO HENRIQUE", clienteNovo.getBody().getNome());
    }

    @Test
    @DisplayName("Deletou o cliente com sucesso!")
    void deletarTest(){

        var clienteDeletado = controller.deletar(1L);

        Assertions.assertEquals(HttpStatus.OK, clienteDeletado.getStatusCode());
    }
}
