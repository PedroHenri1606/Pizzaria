package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente cadastrar(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();

        BeanUtils.copyProperties(clienteDTO,cliente);

        return repository.save(cliente);
    }

    public Cliente buscarPorId(Long id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        } else {
            return cliente.get();
        }
    }

    public List<Cliente> listar(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum cliente cadastrado!");
        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Cliente editar(Long id, ClienteDTO clienteNovo){
        Cliente clienteBanco = this.buscarPorId(id);

        if(id == 0 || !clienteNovo.getId().equals(clienteBanco.getId())){
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        }

        clienteBanco.setNome(clienteNovo.getNome());
        clienteBanco.setTelefone(clienteNovo.getTelefone());
        clienteBanco.setCpf(clienteNovo.getCpf());

        return repository.save(clienteBanco);
    }

    @Transactional
    public void delete(Long id){
        Cliente cliente = this.buscarPorId(id);

        repository.delete(cliente);
    }
}
