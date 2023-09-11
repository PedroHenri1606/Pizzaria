package com.piazzariap1.pizzaria.service.Implementada;

import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.repository.ClienteRepository;
import com.piazzariap1.pizzaria.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente cadastrar(ClienteDTO clienteDTO) {
        if (!repository.findByCpf(clienteDTO.getCpf()).isEmpty()) {
            throw new RuntimeException("o cpf informado já esta cadastrado!");
        } else {

            Cliente cliente = new Cliente();

            BeanUtils.copyProperties(clienteDTO, cliente);
            cliente.setNome(clienteDTO.getNome().toUpperCase());

            return repository.save(cliente);
        }
    }

    public Cliente buscarPorId(Long id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        } else {
            return cliente.get();
        }
    }

    public List<Cliente> buscarPorNome(String nome) {
        if(nome.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        } else if(repository.findByNome(nome.toUpperCase()).isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum cliente!");
        } else {
            return repository.findByNome(nome.toUpperCase());
        }
    }

    public List<Cliente> buscarPorCpf(String cpf) {
        if (cpf == null || cpf.equals(0)){
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        } else if(repository.findByCpf(cpf).isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum cliente!");
        } else {
            return repository.findByCpf(cpf);
        }
    }

    public List<Cliente> buscarClienteComecandoCom(String nome) {
        if(nome.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        } else if(repository.findByNomeStartingWith(nome.toUpperCase()).isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum cliente!");
        } else {
            return repository.findByNomeStartingWith(nome.toUpperCase());
        }
    }

    public List<Cliente> buscarClienteTerminandoCom(String nome) {
        if(nome.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        } else if(repository.findByNomeEndingWith(nome.toUpperCase()).isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum cliente!");
        } else {
            return repository.findByNomeEndingWith(nome.toUpperCase());
        }
    }


    public List<Cliente> buscarClienteQueContenha(String nome) {
        if (nome.isEmpty()) {
            throw new RuntimeException("não foi possivel localizar o cliente informado!");
        } else if (repository.findByNomeContaining(nome.toUpperCase()).isEmpty()) {
            throw new RuntimeException("não foi possivel localizar nenhum cliente!");
        } else {
            return repository.findByNomeContaining(nome.toUpperCase());
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
