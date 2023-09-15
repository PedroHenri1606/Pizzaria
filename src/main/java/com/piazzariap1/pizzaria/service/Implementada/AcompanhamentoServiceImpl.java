package com.piazzariap1.pizzaria.service.Implementada;

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

    @Transactional
    public Acompanhamento cadastrar(AcompanhamentoDTO acompanhamentoDTO){
        Acompanhamento acompanhamento = new Acompanhamento();

        BeanUtils.copyProperties(acompanhamentoDTO,acompanhamento);
        acompanhamento.setDescricao(acompanhamentoDTO.getDescricao().toUpperCase());

        return repository.save(acompanhamento);
    }

    public Acompanhamento buscarPorId(Long id){
        Optional<Acompanhamento> acompanhamento = repository.findById(id);
        if(acompanhamento.isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else {
            return acompanhamento.get();
        }
    }

    public List<Acompanhamento> buscarPorDescricao(String descricao) {
        if(descricao.isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else if(repository.findByDescricao(descricao.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else {
            return repository.findByDescricao(descricao.toUpperCase());
        }
    }

    public List<Acompanhamento> buscarPorValor(Long valor) {
        if (valor == null){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else if(repository.findByValor(valor).isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else {
            return repository.findByValor(valor);
        }
    }

    public List<Acompanhamento> buscarAcompanhamentoComecandoCom(String descricao) {
        if(descricao.isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else if(repository.findByDescricaoStartingWith(descricao.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else {
            return repository.findByDescricaoStartingWith(descricao.toUpperCase());
        }
    }

    public List<Acompanhamento> buscarAcompanhamentoTerminandoCom(String descricao) {
        if(descricao.isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else if(repository.findByDescricaoEndingWith(descricao.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else {
            return repository.findByDescricaoEndingWith(descricao.toUpperCase());
        }
    }

    public List<Acompanhamento> buscarAcompanhamentoQueContenha(String descricao) {
        if (descricao.isEmpty()) {
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else if (repository.findByDescricaoContaining(descricao.toUpperCase()).isEmpty()) {
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");

        } else {
            return repository.findByDescricaoContaining(descricao.toUpperCase());
        }
    }

    public List<Acompanhamento> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-cadastrado}");

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Acompanhamento editar(Long id, AcompanhamentoDTO acompanhamentoNovo){
        Acompanhamento acompanhamentoBanco = this.buscarPorId(id);

        if(id == 0 || !acompanhamentoNovo.getId().equals(acompanhamentoBanco.getId())){
            throw new NaoLocalizadoException("{acompanhamento.exception.nao-localizado}");
        }

        acompanhamentoBanco.setDescricao(acompanhamentoNovo.getDescricao());
        acompanhamentoBanco.setValor(acompanhamentoBanco.getValor());

        return repository.save(acompanhamentoBanco);
    }

    @Transactional
    public void delete(Long id){
        Acompanhamento acompanhamento = this.buscarPorId(id);

        repository.delete(acompanhamento);
    }
}
