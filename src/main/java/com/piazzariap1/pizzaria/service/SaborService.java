package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.SaborDTO;
import com.piazzariap1.pizzaria.entity.Sabor;
import com.piazzariap1.pizzaria.repository.SaborRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaborService {

    @Autowired
    private SaborRepository repository;

    @Transactional
    public Sabor cadastrar(SaborDTO saborDTO){
        Sabor sabor = new Sabor();

        sabor.setNome(saborDTO.getNome());
        sabor.setDescricao(saborDTO.getDescricao());
        sabor.setAtivo(sabor.isAtivo());

        if(repository.verificarNome(sabor.getNome()).isEmpty()){
            return repository.save(sabor);
        } else{
            throw new RuntimeException("sabor informado já esta cadastrado!");
        }
    }

    public SaborDTO buscarPorId(Long id) {

        if (id == 0) {
            throw new RuntimeException("por favor, informe um valor valido!");
        } else if (repository.findById(id).isEmpty()) {
            throw new RuntimeException("não foi possivel localizar o sabor informado!");
        } else {

            Sabor sabor = repository.findById(id).orElse(null);
            SaborDTO saborDTO = new SaborDTO();

            saborDTO.setId(sabor.getId());
            saborDTO.setCadastro(sabor.getCadastro());
            saborDTO.setEdicao(sabor.getEdicao());
            saborDTO.setAtivo(sabor.isAtivo());
            saborDTO.setNome(sabor.getNome());
            saborDTO.setDescricao(sabor.getDescricao());

            return saborDTO;
        }
    }

    public List<SaborDTO> listar(){
        List<Sabor> sabores = repository.findAll();
        if(sabores.isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum sabor cadastrado!");
        }
        return sabores.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    public SaborDTO converterParaDTO(Sabor sabor){
        SaborDTO saborDTO = new SaborDTO();

        saborDTO.setId(sabor.getId());
        saborDTO.setCadastro(sabor.getCadastro());
        saborDTO.setEdicao(sabor.getEdicao());
        saborDTO.setAtivo(sabor.isAtivo());
        saborDTO.setNome(sabor.getNome());
        saborDTO.setDescricao(sabor.getDescricao());

        return saborDTO;
    }

    @Transactional
    public SaborDTO editar(Long id, SaborDTO saborNovo){
        Sabor saborBanco = repository.findById(id).orElse(null);

        if(saborNovo.getId() == 0 || !saborNovo.getId().equals(saborBanco.getId())){
            throw new RuntimeException("Não foi possivel localizar o sabor informado!");
        }

        saborBanco.setAtivo(saborNovo.isAtivo());
        saborBanco.setNome(saborNovo.getNome());
        saborBanco.setDescricao(saborNovo.getDescricao());

        return this.converterParaDTO(saborBanco);
    }

    @Transactional
    public String deletar(Long id){
        repository.deleteById(id);
        return ("Sabor informado deletado com sucesso!");
    }
}
