package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.repository.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcompanhamentoService {

    @Autowired
    private AcompanhamentoRepository repository;

    public Acompanhamento cadastrar(AcompanhamentoDTO acompanhamentoDTO){
        Acompanhamento acompanhamento = new Acompanhamento();

        acompanhamento.setAtivo(acompanhamentoDTO.isAtivo());
        acompanhamento.setDescricao(acompanhamentoDTO.getDescricao());
        acompanhamento.setValor(acompanhamentoDTO.getValor());

        return repository.save(acompanhamento);
    }

    public AcompanhamentoDTO buscarPorId(Long id){

        Acompanhamento acompanhamento = repository.findById(id).orElse(null);
        AcompanhamentoDTO acompanhamentoDTO = new AcompanhamentoDTO();

        acompanhamentoDTO.setId(acompanhamento.getId());
        acompanhamentoDTO.setCadastro(acompanhamento.getCadastro());
        acompanhamentoDTO.setEdicao(acompanhamento.getEdicao());
        acompanhamentoDTO.setAtivo(acompanhamento.isAtivo());
        acompanhamentoDTO.setDescricao(acompanhamento.getDescricao());
        acompanhamentoDTO.setValor(acompanhamento.getValor());

        return acompanhamentoDTO;
    }

    public List<AcompanhamentoDTO> listar(){
        List<Acompanhamento> acompanhamentos = repository.findAll();

        return acompanhamentos.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    public AcompanhamentoDTO converterParaDTO(Acompanhamento acompanhamento){
        AcompanhamentoDTO acompanhamentoDTO = new AcompanhamentoDTO();

        acompanhamentoDTO.setId(acompanhamento.getId());
        acompanhamentoDTO.setCadastro(acompanhamento.getCadastro());
        acompanhamentoDTO.setEdicao(acompanhamento.getEdicao());
        acompanhamentoDTO.setAtivo(acompanhamento.isAtivo());
        acompanhamentoDTO.setDescricao(acompanhamento.getDescricao());
        acompanhamentoDTO.setValor(acompanhamento.getValor());

        return acompanhamentoDTO;
    }

    public AcompanhamentoDTO editar(Long id, AcompanhamentoDTO acompanhamentoNovo){
        Acompanhamento acompanhamento = repository.findById(id).orElse(null);

        if(acompanhamentoNovo.getId() == 0 || !acompanhamentoNovo.getId().equals(acompanhamento.getId())){
            throw new RuntimeException("Não foi possivel localizar o produto informado!");
        }

        acompanhamento.setAtivo(acompanhamentoNovo.isAtivo());
        acompanhamento.setDescricao(acompanhamentoNovo.getDescricao());
        acompanhamento.setValor(acompanhamentoNovo.getValor());

        return this.converterParaDTO(acompanhamento);
    }

    public String deletar(Long id){
        repository.deleteById(id);
        return ("Acompanhamento deletado com sucesso!");
    }
}
