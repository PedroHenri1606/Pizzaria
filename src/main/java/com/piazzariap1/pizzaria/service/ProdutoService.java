package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    @Transactional
    public Produto cadastrar(ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValor(produtoDTO.getValor());
        produto.setTamanho(produto.getTamanho());

        return repository.save(produto);
    }

    public ProdutoDTO buscarPorId(Long id){

        if (id == 0) {
            throw new RuntimeException("por favor, informe um valor valido!");
        } else if (repository.findById(id).isEmpty()) {
            throw new RuntimeException("não foi possivel localizar o produto informado!");
        } else {

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
    }

    public List<ProdutoDTO> listar(){
        List<Produto> produtos = repository.findAll();
        if(produtos.isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum produto cadastrado!");
        }

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

    @Transactional
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

    @Transactional
    public String deletar(Long id){
        repository.deleteById(id);
        return ("Produto informado deletado com sucesso!");
    }
}
