package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.PedidoDTO;
import com.piazzariap1.pizzaria.dto.ProdutoDTO;
import com.piazzariap1.pizzaria.entity.Pedido;
import com.piazzariap1.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido cadastrar(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();

        pedido.setAtivo(pedidoDTO.isAtivo());

        pedido.setCliente(pedidoDTO.getCliente());
        pedido.setItem(pedidoDTO.getItem());
        pedido.setAcompanhamento(pedidoDTO.getAcompanhamento());
        pedido.setFuncionario(pedidoDTO.getFuncionario());
        pedido.setObservacao(pedido.getObservacao());
        pedido.setEntregar(pedidoDTO.getEntregar());
        pedido.setPago(pedido.getPago());
        pedido.setSituacaoPedido(pedidoDTO.getSituacaoPedido());
        pedido.setFormaDePagamento(pedidoDTO.getFormaDePagamento());
        pedido.setValorTotal(pedidoDTO.getValorTotal());

        return pedido;
    }

    public PedidoDTO buscarPorId(Long id){
        Pedido pedido = repository.findById(id).orElse(null);
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setCadastro(pedido.getCadastro());
        pedidoDTO.setEdicao(pedido.getEdicao());
        pedidoDTO.setAtivo(pedidoDTO.isAtivo());
        pedidoDTO.setCliente(pedido.getCliente());
        pedidoDTO.setItem(pedido.getItem());
        pedidoDTO.setAcompanhamento(pedido.getAcompanhamento());
        pedidoDTO.setFuncionario(pedido.getFuncionario());
        pedidoDTO.setObservacao(pedido.getObservacao());
        pedidoDTO.setEntregar(pedido.getEntregar());
        pedidoDTO.setPago(pedido.getPago());
        pedidoDTO.setSituacaoPedido(pedido.getSituacaoPedido());
        pedidoDTO.setFormaDePagamento(pedido.getFormaDePagamento());
        pedidoDTO.setValorTotal(pedido.getValorTotal());

        return pedidoDTO;
    }

    public List<PedidoDTO> listar(){
        List<Pedido> pedidos = repository.findAll();

        return pedidos.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    public PedidoDTO converterParaDTO(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setCadastro(pedido.getCadastro());
        pedidoDTO.setEdicao(pedido.getEdicao());
        pedidoDTO.setAtivo(pedidoDTO.isAtivo());
        pedidoDTO.setCliente(pedido.getCliente());
        pedidoDTO.setItem(pedido.getItem());
        pedidoDTO.setAcompanhamento(pedido.getAcompanhamento());
        pedidoDTO.setFuncionario(pedido.getFuncionario());
        pedidoDTO.setObservacao(pedido.getObservacao());
        pedidoDTO.setEntregar(pedido.getEntregar());
        pedidoDTO.setPago(pedido.getPago());
        pedidoDTO.setSituacaoPedido(pedido.getSituacaoPedido());
        pedidoDTO.setFormaDePagamento(pedido.getFormaDePagamento());
        pedidoDTO.setValorTotal(pedido.getValorTotal());

        return pedidoDTO;
    }

    public PedidoDTO editar(Long id, PedidoDTO pedidoNovo){
         Pedido pedidoBanco = repository.findById(id).orElse(null);

         if(pedidoNovo.getId() == 0 || !pedidoNovo.getId().equals(pedidoBanco.getId())){
             throw new RuntimeException("Não foi possivel localizar o pedido informado!");
         }

        pedidoBanco.setAtivo(pedidoNovo.isAtivo());
        pedidoBanco.setCliente(pedidoNovo.getCliente());
        pedidoBanco.setItem(pedidoNovo.getItem());
        pedidoBanco.setAcompanhamento(pedidoNovo.getAcompanhamento());
        pedidoBanco.setFuncionario(pedidoNovo.getFuncionario());
        pedidoBanco.setObservacao(pedidoNovo.getObservacao());
        pedidoBanco.setEntregar(pedidoNovo.getEntregar());
        pedidoBanco.setPago(pedidoNovo.getPago());
        pedidoBanco.setSituacaoPedido(pedidoNovo.getSituacaoPedido());
        pedidoBanco.setFormaDePagamento(pedidoNovo.getFormaDePagamento());
        pedidoBanco.setValorTotal(pedidoNovo.getValorTotal());

        repository.save(pedidoBanco);

        return converterParaDTO(pedidoBanco);
    }

    public String deletar(Long id){
        repository.deleteById(id);

        return ("Pedido deletado com sucesso!");
    }

}
