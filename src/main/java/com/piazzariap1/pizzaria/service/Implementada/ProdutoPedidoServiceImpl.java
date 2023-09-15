package com.piazzariap1.pizzaria.service.Implementada;

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

    @Transactional
    public ProdutoPedido cadastrar(ProdutoPedidoDTO produtoPedidoDTO){
        ProdutoPedido itemPedido = new ProdutoPedido();

        BeanUtils.copyProperties(produtoPedidoDTO,itemPedido);

        return repository.save(itemPedido);
    }

    public ProdutoPedido buscarPorId(Long id){
        Optional<ProdutoPedido> itemPedido = repository.findById(id);
        if(itemPedido.isEmpty()){
            throw new NaoLocalizadoException("{produto-pedido.exception.nao-localizado}");

        } else {
            return itemPedido.get();
        }
    }

    public List<ProdutoPedido> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException("{produto-pedido.exception.nao-cadastrado}");

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public ProdutoPedido editar(Long id, ProdutoPedidoDTO itemPedidoNovo){
        ProdutoPedido itemPedidoBanco = this.buscarPorId(id);

        if(id == 0 || !itemPedidoNovo.getId().equals(itemPedidoBanco.getId())){
            throw new NaoLocalizadoException("{produto-pedido.exception.nao-localizado}");
        }

        itemPedidoBanco.setQuantidade(itemPedidoNovo.getQuantidade());

        return repository.save(itemPedidoBanco);
    }

    @Transactional
    public void delete(Long id){
        ProdutoPedido itemPedido = this.buscarPorId(id);

        repository.delete(itemPedido);
    }
}
