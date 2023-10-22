package com.piazzariap1.pizzaria.service.implementada;

import com.piazzariap1.pizzaria.dto.AcompanhamentoDTO;
import com.piazzariap1.pizzaria.entity.Acompanhamento;
import com.piazzariap1.pizzaria.repository.AcompanhamentoRepository;
import com.piazzariap1.pizzaria.service.AcompanhamentoService;
import com.piazzariap1.pizzaria.service.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcompanhamentoServiceImpl implements AcompanhamentoService {

    @Autowired
    public AcompanhamentoRepository repository;

    private static final String NAO_LOCALIZADO = "{acompanhamento.exception.nao-localizado}";
    private static final String NAO_LOCALIZADO2 = "{acompanhamento.exception.nao-localizado2}";
    private static final String NAO_CADASTRADO = "{acompanhamento.exception.nao-cadastrado}";


    @Transactional
    public Acompanhamento cadastrar(AcompanhamentoDTO acompanhamentoDTO){
        Acompanhamento acompanhamento = new Acompanhamento();

        BeanUtils.copyProperties(acompanhamentoDTO,acompanhamento);
        acompanhamento.setDescricao(acompanhamentoDTO.getDescricao().toUpperCase());
        repository.save(acompanhamento);

        return acompanhamento;
    }

    public Acompanhamento buscarPorId(Long id){
        Optional<Acompanhamento> acompanhamento = repository.findById(id);
        if(acompanhamento.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return acompanhamento.get();
        }
    }

    public List<Acompanhamento> buscarPorDescricao(String descricao) {
        if(descricao.toUpperCase().isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        List<Acompanhamento> acompanhamentos = repository.findByDescricao(descricao.toUpperCase());

        if(acompanhamentos.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return acompanhamentos;
        }
    }

    public List<Acompanhamento> buscarPorValor(Long valor) {
        if (valor == null){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        List<Acompanhamento> acompanhamentos = repository.findByValor(valor);

        if(acompanhamentos.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return acompanhamentos;
        }
    }

    public List<Acompanhamento> buscarAcompanhamentoComecandoCom(String descricao) {
        if(descricao.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        List<Acompanhamento> acompanhamentos = repository.findByDescricaoStartingWith(descricao.toUpperCase());

        if(acompanhamentos.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return acompanhamentos;
        }
    }

    public List<Acompanhamento> buscarAcompanhamentoTerminandoCom(String descricao) {
        if(descricao.isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        List<Acompanhamento> acompanhamentos = repository.findByDescricaoEndingWith(descricao.toUpperCase());

         if(acompanhamentos.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return acompanhamentos;
        }
    }

    public List<Acompanhamento> buscarAcompanhamentoQueContenha(String descricao) {
        if (descricao.isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        List<Acompanhamento> acompanhamentos = repository.findByDescricaoContaining(descricao.toUpperCase());

        if (acompanhamentos.isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return acompanhamentos;
        }
    }

    public List<Acompanhamento> listar(){
        List<Acompanhamento> acompanhamentos = repository.findAll();
        if(acompanhamentos.isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return acompanhamentos;
        }
    }

    @Transactional
    public Acompanhamento editar(Long id, AcompanhamentoDTO acompanhamentoNovo){
        if(id == 0){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        Acompanhamento acompanhamentoBanco = this.buscarPorId(id);

        acompanhamentoBanco.setDescricao(acompanhamentoNovo.getDescricao());
        acompanhamentoBanco.setValor(acompanhamentoBanco.getValor());
        acompanhamentoBanco.setAtivo(acompanhamentoBanco.isAtivo());

        return repository.save(acompanhamentoBanco);
    }

    @Transactional
    public void delete(Long id){
        Acompanhamento acompanhamento = this.buscarPorId(id);

        repository.delete(acompanhamento);
    }
}
