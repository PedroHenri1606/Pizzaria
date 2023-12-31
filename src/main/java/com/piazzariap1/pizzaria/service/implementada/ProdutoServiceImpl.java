package com.piazzariap1.pizzaria.service.implementada;

import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Produto;
import com.piazzariap1.pizzaria.repository.ProdutoRepository;
import com.piazzariap1.pizzaria.service.ProdutoService;
import com.piazzariap1.pizzaria.service.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    public ProdutoRepository repository;

    private static final String NAO_CADASTRADO = "{produto.exception.nao-cadastrado}";
    private static final String NAO_LOCALIZADO = "{produto.exception.nao-localizado}";
    private static final String NAO_LOCALIZADO2 = "{produto.exception.nao-localizado2}";

    @Transactional
    public Produto cadastrar(ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        BeanUtils.copyProperties(produtoDTO,produto);
        produto.setDescricao(produtoDTO.descricao().toUpperCase());
        repository.save(produto);

        return produto;
    }

    public Produto buscarPorId(Long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return produto.get();
        }
    }

    public List<Produto> buscarPorDescricao(String descricao) {
        if(descricao.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByDescricao(descricao.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByDescricao(descricao.toUpperCase());
        }
    }

    public List<Produto> buscarPorValor(Long valor) {
        if (valor == null ){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByValor(valor).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByValor(valor);
        }
    }

    public List<Produto> buscarProdutoComecandoCom(String descricao) {
        if(descricao.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByDescricaoStartingWith(descricao.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByDescricaoStartingWith(descricao.toUpperCase());
        }
    }

    public List<Produto> buscarProdutoTerminandoCom(String descricao) {
        if(descricao.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByDescricaoEndingWith(descricao.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByDescricaoEndingWith(descricao.toUpperCase());
        }
    }


    public List<Produto> buscarProdutoQueContenha(String descricao) {
        if (descricao.isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if (repository.findByDescricaoContaining(descricao.toUpperCase()).isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByDescricaoContaining(descricao.toUpperCase());
        }
    }

    public List<Produto> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Produto editar(Long id, ProdutoDTO produtoNovo){
        Produto produtoBanco = this.buscarPorId(id);

        if(id == 0 || !produtoNovo.id().equals(produtoBanco.getId())){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        produtoBanco.setDescricao(produtoNovo.descricao());
        produtoBanco.setTamanho(produtoNovo.tamanho());
        produtoBanco.setValor(produtoNovo.valor());
        produtoBanco.setAtivo(produtoNovo.ativo());

        return repository.save(produtoBanco);
    }

    @Transactional
    public void delete(Long id){
        Produto produto = this.buscarPorId(id);

        repository.delete(produto);
    }
}
