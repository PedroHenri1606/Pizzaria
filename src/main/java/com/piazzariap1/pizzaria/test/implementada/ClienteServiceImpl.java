package com.piazzariap1.pizzaria.test.implementada;

import com.piazzariap1.pizzaria.dto.ClienteDTO;
import com.piazzariap1.pizzaria.entity.Cliente;
import com.piazzariap1.pizzaria.repository.ClienteRepository;
import com.piazzariap1.pizzaria.test.ClienteService;
import com.piazzariap1.pizzaria.test.exception.CadastroNaoRealizadoException;
import com.piazzariap1.pizzaria.test.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    public ClienteRepository repository;

    private static final String NAO_LOCALIZADO = "{cliente.exception.nao-localizado}";
    private static final String NAO_LOCALIZADO2 = "{cliente.exception.nao-localizado2}";
    private static final String NAO_CADASTRADO = "{cliente.exception.nao-cadastrado}";
    private static final String CPF_CADASTRADO = "{cliente.exception.cpf-cadastrado}";

    @Transactional
    public Cliente cadastrar(ClienteDTO clienteDTO) {
        if (!repository.findByCpf(clienteDTO.getCpf()).isEmpty()) {
            throw new CadastroNaoRealizadoException(CPF_CADASTRADO);
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
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return cliente.get();
        }
    }

    public List<Cliente> buscarPorNome(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNome(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNome(nome.toUpperCase());
        }
    }

    public List<Cliente> buscarPorCpf(String cpf) {
        if (cpf == null){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByCpf(cpf).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByCpf(cpf);
        }
    }

    public List<Cliente> buscarClienteComecandoCom(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNomeStartingWith(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeStartingWith(nome.toUpperCase());
        }
    }

    public List<Cliente> buscarClienteTerminandoCom(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNomeEndingWith(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeEndingWith(nome.toUpperCase());
        }
    }


    public List<Cliente> buscarClienteQueContenha(String nome) {
        if (nome.isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if (repository.findByNomeContaining(nome.toUpperCase()).isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeContaining(nome.toUpperCase());
        }
    }

    public List<Cliente> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Cliente editar(Long id, ClienteDTO clienteNovo){
        Cliente clienteBanco = this.buscarPorId(id);

        if(id == 0 || !clienteNovo.getId().equals(clienteBanco.getId())){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        clienteBanco.setNome(clienteNovo.getNome());
        clienteBanco.setTelefone(clienteNovo.getTelefone());

        return repository.save(clienteBanco);
    }

    @Transactional
    public void delete(Long id){
        Cliente cliente = this.buscarPorId(id);

        repository.delete(cliente);
    }
}
