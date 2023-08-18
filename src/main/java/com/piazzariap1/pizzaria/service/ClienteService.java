package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrar(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();

        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(cliente.getTelefone());

        return repository.save(cliente);
    }

    public ClienteDTO buscarPorId(Long id){

        Cliente cliente = repository.findById(id).orElse(null);
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setAtivo(cliente.isAtivo());
        clienteDTO.setCadastro(cliente.getCadastro());

        return clienteDTO;
    }

    public List<ClienteDTO> listar(){
        List<Cliente> clientes = repository.findAll();

        return clientes.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }
    private ClienteDTO converterParaDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setAtivo(cliente.isAtivo());
        clienteDTO.setCadastro(cliente.getCadastro());
        return clienteDTO;
    }

    public ClienteDTO editar(Long id, ClienteDTO clienteNovo){

        Cliente clienteBanco = repository.findById(id).orElse(null);

        if(clienteNovo.getId() == 0 || !clienteNovo.getId().equals(clienteBanco.getId())) {
            throw new RuntimeException("Não foi possivel localizar cliente informado!");
        }

        clienteBanco.setNome(clienteNovo.getNome());
        clienteBanco.setCpf(clienteNovo.getCpf());
        clienteBanco.setTelefone(clienteNovo.getTelefone());
        clienteBanco.setAtivo(clienteNovo.isAtivo());

        repository.save(clienteBanco);

        return converterParaDTO(clienteBanco);
    }

    public String deletar(Long id){
         repository.deleteById(id);
         return ("Cliente deletado com sucesso!");
    }
}
