package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente cadastrar(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();

        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(cliente.getTelefone());

        if(repository.verificaCPF(cliente.getCpf()).isEmpty()){
            return repository.save(cliente);
        } else{
            throw new RuntimeException("cliente informado já esta cadastrado!");
        }
    }

    public ClienteDTO buscarPorId(Long id) {

        if (id == 0) {
            throw new RuntimeException("por favor, informe um valor valido!");
        } else if (repository.findById(id).isEmpty()) {
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        } else {

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
    }

    public List<ClienteDTO> listar(){
        List<Cliente> clientes = repository.findAll();
        if(clientes.isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum cliente cadastrado!");
        }
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

    @Transactional
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

    @Transactional
    public String deletar(Long id){
         repository.deleteById(id);
         return ("Cliente deletado com sucesso!");
    }
}
