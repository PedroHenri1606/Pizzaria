package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.SaborDTO;
import com.piazzariap1.pizzaria.entity.Sabor;
import com.piazzariap1.pizzaria.repository.SaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaborService {

    @Autowired
    private SaborRepository repository;

    public Sabor cadastrar(SaborDTO saborDTO){
        Sabor sabor = new Sabor();

        sabor.setNome(saborDTO.getNome());
        sabor.setDescricao(saborDTO.getDescricao());
        sabor.setAtivo(sabor.isAtivo());

        return repository.save(sabor);
    }

    public SaborDTO buscarPorId(Long id){
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

    public List<SaborDTO> listar(){
        List<Sabor> sabores = repository.findAll();

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

    public String deletar(Long id){
        repository.deleteById(id);
        return ("Sabor informado deletado com sucesso!");
    }
}
