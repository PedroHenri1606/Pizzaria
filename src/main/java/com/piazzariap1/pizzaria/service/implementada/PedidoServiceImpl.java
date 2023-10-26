package com.piazzariap1.pizzaria.service.implementada;

import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.entity.Pedido;
import com.piazzariap1.pizzaria.entity.enuns.SituacaoPedido;
import com.piazzariap1.pizzaria.repository.PedidoRepository;
import com.piazzariap1.pizzaria.service.PedidoService;
import com.piazzariap1.pizzaria.service.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    public PedidoRepository repository;

    private static final String NAO_LOCALIZADO = "{pedido.exception.nao-localizado}";
    private static final String NAO_CADASTRADO = "{pedido.exception.nao-cadastrado}";

    @Transactional
    public Pedido cadastrar(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();

        BeanUtils.copyProperties(pedidoDTO,pedido);
        pedido.setSituacaoPedido(SituacaoPedido.EM_ABERTO);
        repository.save(pedido);

        return pedido;
    }

    public Pedido buscarPorId(Long id){
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return pedido.get();
        }
    }

    public List<Pedido> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Pedido editar(Long id, PedidoDTO pedidoNovo){
        Pedido pedidoBanco = this.buscarPorId(id);

        if(id == 0 || !pedidoNovo.getId().equals(pedidoBanco.getId())){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        pedidoBanco.setAcompanhamento(pedidoNovo.getAcompanhamento());
        pedidoBanco.setEntregar(pedidoNovo.getEntregar());
        pedidoBanco.setObservacao(pedidoNovo.getObservacao());
        pedidoBanco.setFormaDePagamento(pedidoNovo.getFormaDePagamento());
        pedidoBanco.setEnderecoEntrega(pedidoNovo.getEnderecoEntrega());

        return repository.save(pedidoBanco);
    }

}
