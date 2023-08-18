package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.EnderecoDTO;
import com.piazzariap1.pizzaria.entity.Endereco;
import com.piazzariap1.pizzaria.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco cadastrar(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco();

        endereco.setCep(enderecoDTO.getCep());
        endereco.setLogadouro(enderecoDTO.getLogadouro());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setIdCliente(enderecoDTO.getClienteId());

        return repository.save(endereco);
    }

    public EnderecoDTO buscarPorId(Long id){

        Endereco endereco = repository.findById(id).orElse(null);
        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId(endereco.getId());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setLogadouro(endereco.getLogadouro());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setClienteId(endereco.getIdCliente());

        return enderecoDTO;
    }

    public List<EnderecoDTO> listar(){
        List<Endereco> enderecos = repository.findAll();

        return enderecos.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    public EnderecoDTO converterParaDTO(Endereco endereco){
        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId(endereco.getId());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setLogadouro(endereco.getLogadouro());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setClienteId(endereco.getIdCliente());

        return enderecoDTO;
    }

    public EnderecoDTO editar(Long id, EnderecoDTO enderecoNovo){

        Endereco enderecoBanco = repository.findById(id).orElse(null);

        if(enderecoNovo.getId() == 0 || !enderecoBanco.getId().equals(enderecoNovo.getId())){
            throw new RuntimeException("Não foi possivel localizar o endereço informado!");
        }

        enderecoBanco.setCep(enderecoNovo.getCep());
        enderecoBanco.setLogadouro(enderecoNovo.getLogadouro());
        enderecoBanco.setBairro(enderecoNovo.getBairro());
        enderecoBanco.setNumero(enderecoNovo.getNumero());
        enderecoBanco.setIdCliente(enderecoNovo.getClienteId());

        repository.save(enderecoBanco);

        return converterParaDTO(enderecoBanco);
    }

    public String deletar(Long id){
        repository.deleteById(id);
        return ("Endereço deletado com sucesso!");
    }
}
