package com.piazzariap1.pizzaria.test.implementada;

import com.piazzariap1.pizzaria.dto.EnderecoDTO;
import com.piazzariap1.pizzaria.entity.Endereco;
import com.piazzariap1.pizzaria.repository.EnderecoRepository;
import com.piazzariap1.pizzaria.test.EnderecoService;
import com.piazzariap1.pizzaria.test.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    public EnderecoRepository repository;

    private static final String NAO_LOCALIZADO = "{endereco.exception.nao-localizado}";
    private static final String NAO_CADASTRADO = "{endereco.exception.nao-cadastrado}";

    @Transactional
    public Endereco cadastrar(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco();

        BeanUtils.copyProperties(enderecoDTO,endereco);

        return repository.save(endereco);
    }

    public Endereco buscarPorId(Long id){
        Optional<Endereco> endereco = repository.findById(id);
        if(endereco.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return endereco.get();
        }
    }

    public List<Endereco> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Endereco editar(Long id, EnderecoDTO enderecoNovo){
        Endereco enderecoBanco = this.buscarPorId(id);

        if(id == 0 || !enderecoNovo.getId().equals(enderecoBanco.getId())){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
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
