package com.piazzariap1.pizzaria.service.Implementada;

import com.piazzariap1.pizzaria.dto.EnderecoDTO;
import com.piazzariap1.pizzaria.entity.Endereco;
import com.piazzariap1.pizzaria.repository.EnderecoRepository;
import com.piazzariap1.pizzaria.service.EnderecoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Transactional
    public Endereco cadastrar(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco();

        BeanUtils.copyProperties(enderecoDTO,endereco);

        return repository.save(endereco);
    }

    public Endereco buscarPorId(Long id){
        Optional<Endereco> endereco = repository.findById(id);
        if(endereco.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o endereco informado!");
        } else {
            return endereco.get();
        }
    }

    public List<Endereco> listar(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum endereco cadastrado!");
        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Endereco editar(Long id, EnderecoDTO enderecoNovo){
        Endereco enderecoBanco = this.buscarPorId(id);

        if(id == 0 || !enderecoNovo.getId().equals(enderecoBanco.getId())){
            throw new RuntimeException("não foi possivel localizar o endereco informado!");
        }

        enderecoBanco.setNumero(enderecoNovo.getNumero());
        enderecoBanco.setBairro(enderecoNovo.getBairro());
        enderecoBanco.setLogadouro(enderecoNovo.getLogadouro());
        enderecoBanco.setCep(enderecoNovo.getCep());

        return repository.save(enderecoBanco);
    }

    @Transactional
    public void delete(Long id){
        Endereco endereco = this.buscarPorId(id);

        repository.delete(endereco);
    }
}