package com.piazzariap1.pizzaria.test.implementada;

import com.piazzariap1.pizzaria.dto.SaborDTO;

import com.piazzariap1.pizzaria.entity.Sabor;
import com.piazzariap1.pizzaria.repository.SaborRepository;
import com.piazzariap1.pizzaria.test.SaborService;
import com.piazzariap1.pizzaria.test.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaborServiceImpl implements SaborService {

    @Autowired
    public SaborRepository repository;

    private static final String NAO_CADASTRADO = "{sabor.exception.nao-cadastrado}";
    private static final String NAO_LOCALIZADO = "{sabor.exception.nao-localizado}";
    private static final String NAO_LOCALIZADO2 = "{sabor.exception.nao-localizado2}";

    @Transactional
    public Sabor cadastrar(SaborDTO saborDTO){
        Sabor sabor = new Sabor();

        BeanUtils.copyProperties(saborDTO,sabor);
        sabor.setNome(saborDTO.getNome().toUpperCase());

        return repository.save(sabor);
    }

    public Sabor buscarPorId(Long id){
        Optional<Sabor> sabor = repository.findById(id);
        if(sabor.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return sabor.get();
        }
    }

    public List<Sabor> buscarPorNome(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNome(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNome(nome.toUpperCase());
        }
    }

    public List<Sabor> buscarSaborComecandoCom(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNomeStartingWith(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeStartingWith(nome.toUpperCase());
        }
    }

    public List<Sabor> buscarSaborTerminandoCom(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNomeEndingWith(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeEndingWith(nome.toUpperCase());
        }
    }

    public List<Sabor> buscarSaborQueContenha(String nome) {
        if (nome.isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if (repository.findByNomeContaining(nome.toUpperCase()).isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeContaining(nome.toUpperCase());
        }
    }

    public List<Sabor> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Sabor editar(Long id, SaborDTO saborNovo){
        Sabor saborBanco = this.buscarPorId(id);

        if(id == 0 || !saborNovo.getId().equals(saborBanco.getId())){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        saborBanco.setNome(saborNovo.getNome());
        saborBanco.setDescricao(saborNovo.getDescricao());

        return repository.save(saborBanco);
    }

    @Transactional
    public void delete(Long id){
        Sabor sabor = this.buscarPorId(id);

        repository.delete(sabor);
    }
}
