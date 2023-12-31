package com.piazzariap1.pizzaria.service.implementada;

import com.piazzariap1.pizzaria.dto.ProdutoPedidoDTO;
import com.piazzariap1.pizzaria.entity.ProdutoPedido;
import com.piazzariap1.pizzaria.repository.ProdutoPedidoRepository;
import com.piazzariap1.pizzaria.service.ProdutoPedidoService;
import com.piazzariap1.pizzaria.service.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoPedidoServiceImpl implements ProdutoPedidoService {

    @Autowired
    public ProdutoPedidoRepository repository;

    private static final String NAO_LOCALIZADO = "{produto-pedido.exception.nao-localizado}";
    private static final String NAO_CADASTRADO = "{produto-pedido.exception.nao-cadastrado}";

    @Transactional
    public ProdutoPedido cadastrar(ProdutoPedidoDTO produtoPedidoDTO){
        ProdutoPedido itemPedido = new ProdutoPedido();

        BeanUtils.copyProperties(produtoPedidoDTO,itemPedido);
        repository.save(itemPedido);

        return itemPedido;
    }

    public ProdutoPedido buscarPorId(Long id){
        Optional<ProdutoPedido> itemPedido = repository.findById(id);
        if(itemPedido.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return itemPedido.get();
        }
    }

    public List<ProdutoPedido> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public ProdutoPedido editar(Long id, ProdutoPedidoDTO itemPedidoNovo){
        ProdutoPedido itemPedidoBanco = this.buscarPorId(id);

        if(id == 0 || !itemPedidoNovo.id().equals(itemPedidoBanco.getId())){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        itemPedidoBanco.setQuantidade(itemPedidoNovo.quntidade());
        itemPedidoBanco.setSabores(itemPedidoBanco.getSabores());
        itemPedidoBanco.setObservacao(itemPedidoBanco.getObservacao());

        return repository.save(itemPedidoBanco);
    }

    @Transactional
    public void delete(Long id){
        ProdutoPedido itemPedido = this.buscarPorId(id);

        repository.delete(itemPedido);
    }
}