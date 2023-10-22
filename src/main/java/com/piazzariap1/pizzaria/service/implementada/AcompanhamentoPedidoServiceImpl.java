package com.piazzariap1.pizzaria.service.implementada;

import com.piazzariap1.pizzaria.dto.AcompanhamentoPedidoDTO;
import com.piazzariap1.pizzaria.entity.AcompanhamentoPedido;
import com.piazzariap1.pizzaria.repository.AcompanhamentoPedidoRepository;
import com.piazzariap1.pizzaria.service.AcompanhamentoPedidoService;
import com.piazzariap1.pizzaria.service.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcompanhamentoPedidoServiceImpl implements AcompanhamentoPedidoService {

    @Autowired
    public AcompanhamentoPedidoRepository repository;

    private static final String NAO_LOCALIZADO = "{acompanhamento.exception.nao-localizado}";
    private static final String NAO_CADASTRADO = "{acompanhamento-pedido.exception.nao-cadastrado}";

    @Transactional
    public AcompanhamentoPedido cadastrar(AcompanhamentoPedidoDTO acompanhamentoPedidoDTO){
        AcompanhamentoPedido acompanhamento = new AcompanhamentoPedido();

        BeanUtils.copyProperties(acompanhamentoPedidoDTO,acompanhamento);
        repository.save(acompanhamento);

        return acompanhamento;
    }

    public AcompanhamentoPedido buscarPorId(Long id){
        Optional<AcompanhamentoPedido> acompanhamento = repository.findById(id);
        if(acompanhamento.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return acompanhamento.get();
        }
    }

    public List<AcompanhamentoPedido> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public AcompanhamentoPedido editar(Long id, AcompanhamentoPedidoDTO acompanhamentoNovo){
        AcompanhamentoPedido acompanhamentoBanco = this.buscarPorId(id);

        if(id == 0 || !acompanhamentoNovo.getId().equals(acompanhamentoBanco.getId())){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        acompanhamentoBanco.setQuantidade(acompanhamentoNovo.getQuantidade());
        acompanhamentoBanco.setObservacao(acompanhamentoBanco.getObservacao());
        acompanhamentoBanco.setAcompanhamento(acompanhamentoBanco.getAcompanhamento());

        return repository.save(acompanhamentoBanco);
    }

    @Transactional
    public void delete(Long id){
        AcompanhamentoPedido acompanhamento = this.buscarPorId(id);

        repository.delete(acompanhamento);
    }
}
