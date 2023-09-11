package com.piazzariap1.pizzaria.service.Implementada;

import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.entity.Pedido;
import com.piazzariap1.pizzaria.repository.PedidoRepository;
import com.piazzariap1.pizzaria.service.PedidoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Transactional
    public Pedido cadastrar(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();

        BeanUtils.copyProperties(pedidoDTO,pedido);

        return repository.save(pedido);
    }

    public Pedido buscarPorId(Long id){
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o pedido informado!");

        } else {
            return pedido.get();
        }
    }

    public List<Pedido> listar(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum pedido cadastrado!");

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Pedido editar(Long id, PedidoDTO pedidoNovo){
        Pedido pedidoBanco = this.buscarPorId(id);

        if(id == 0 || !pedidoNovo.getId().equals(pedidoBanco.getId())){
            throw new RuntimeException("não foi possivel localizar o pedido informado!");
        }

        pedidoBanco.setItem(pedidoNovo.getItem());
        pedidoBanco.setAcompanhamento(pedidoNovo.getAcompanhamento());
        pedidoBanco.setEntregar(pedidoNovo.getEntregar());
        pedidoBanco.setObservacao(pedidoNovo.getObservacao());
        pedidoBanco.setFormaDePagamento(pedidoNovo.getFormaDePagamento());

        return repository.save(pedidoBanco);
    }

}
