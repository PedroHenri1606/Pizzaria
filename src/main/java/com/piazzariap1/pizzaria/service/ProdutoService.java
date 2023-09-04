package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto cadastrar(ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        BeanUtils.copyProperties(produtoDTO,produto);

        return repository.save(produto);
    }

    public Produto buscarPorId(Long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o produto informado!");
        } else {
            return produto.get();
        }
    }

    public List<Produto> listar(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum produto cadastrado!");
        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Produto editar(Long id, ProdutoDTO produtoNovo){
        Produto produtoBanco = this.buscarPorId(id);

        if(id == 0 || !produtoNovo.getId().equals(produtoBanco.getId())){
            throw new RuntimeException("não foi possivel localizar o produto informado!");
        }

        produtoBanco.setDescricao(produtoNovo.getDescricao());
        produtoBanco.setValor(produtoNovo.getValor());

        return repository.save(produtoBanco);
    }

    @Transactional
    public void delete(Long id){
        Produto produto = this.buscarPorId(id);

        repository.delete(produto);
    }
}
