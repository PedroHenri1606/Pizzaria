package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public Produto cadastrar(ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValor(produtoDTO.getValor());
        produto.setTamanho(produto.getTamanho());

        return repository.save(produto);
    }

    public ProdutoDTO buscarPorId(Long id){

        Produto produto = repository.findById(id).orElse(null);
        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setId(produto.getId());
        produtoDTO.setCadastro(produto.getCadastro());
        produtoDTO.setEdicao(produto.getEdicao());
        produtoDTO.setAtivo(produto.isAtivo());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setValor(produto.getValor());
        produtoDTO.setTamanho(produto.getTamanho());

        return produtoDTO;
    }

    public List<ProdutoDTO> listar(){
        List<Produto> produtos = repository.findAll();

        return produtos.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    public ProdutoDTO converterParaDTO(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setId(produto.getId());
        produtoDTO.setCadastro(produto.getCadastro());
        produtoDTO.setEdicao(produto.getEdicao());
        produtoDTO.setAtivo(produto.isAtivo());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setValor(produto.getValor());
        produtoDTO.setTamanho(produto.getTamanho());

        return produtoDTO;
    }

    public ProdutoDTO editar(Long id, ProdutoDTO produtoNovo){
        Produto produtoBanco = repository.findById(id).orElse(null);

        if(produtoNovo.getId() == 0 || !produtoNovo.getId().equals(produtoBanco.getId())){
            throw new RuntimeException("Não foi possivel localizar o produto informado!");
        }

        produtoBanco.setDescricao(produtoNovo.getDescricao());
        produtoBanco.setValor(produtoNovo.getValor());
        produtoBanco.setTamanho(produtoNovo.getTamanho());

        return this.converterParaDTO(produtoBanco);
    }

    public String deletar(Long id){
        repository.deleteById(id);
        return ("Produto deletado com sucesso!");
    }
}
