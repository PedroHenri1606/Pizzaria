package com.piazzariap1.pizzaria.service.Implementada;

import com.piazzariap1.pizzaria.dto.SaborDTO;

import com.piazzariap1.pizzaria.entity.Sabor;
import com.piazzariap1.pizzaria.repository.SaborRepository;
import com.piazzariap1.pizzaria.service.SaborService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaborServiceImpl implements SaborService {

    @Autowired
    private SaborRepository repository;

    @Transactional
    public Sabor cadastrar(SaborDTO saborDTO){
        Sabor sabor = new Sabor();

        BeanUtils.copyProperties(saborDTO,sabor);

        return repository.save(sabor);
    }

    public Sabor buscarPorId(Long id){
        Optional<Sabor> sabor = repository.findById(id);
        if(sabor.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o sabor informado!");
        } else {
            return sabor.get();
        }
    }

    public List<Sabor> listar(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum sabor cadastrado!");
        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Sabor editar(Long id, SaborDTO saborNovo){
        Sabor saborBanco = this.buscarPorId(id);

        if(id == 0 || !saborNovo.getId().equals(saborBanco.getId())){
            throw new RuntimeException("não foi possivel localizar o sabor informado!");
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
