package com.piazzariap1.pizzaria.service.implementada;

import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Funcionario;
import com.piazzariap1.pizzaria.repository.FuncionarioRepository;
import com.piazzariap1.pizzaria.service.FuncionarioService;
import com.piazzariap1.pizzaria.service.exception.CadastroNaoRealizadoException;
import com.piazzariap1.pizzaria.service.exception.NaoLocalizadoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    public FuncionarioRepository repository;

    private static final String NAO_LOCALIZADO = "{funcionario.exception.nao-localizado}";
    private static final String NAO_LOCALIZADO2 = "{funcionario.exception.nao-localizado2}";
    private static final String NAO_CADASTRADO = "{funcionario.exception.nao-cadastrado}";
    private static final String CPF_CADASTRADO = "{funcionario.exception.cpf-cadastrado}";

    @Transactional
    public Funcionario cadastrar(FuncionarioDTO funcionarioDTO) {
        if (!repository.findByCpf(funcionarioDTO.cpf()).isEmpty()) {
            throw new CadastroNaoRealizadoException(CPF_CADASTRADO);
        } else {

            Funcionario funcionario = new Funcionario();

            BeanUtils.copyProperties(funcionarioDTO, funcionario);
            funcionario.setNome(funcionarioDTO.nome().toUpperCase());
            repository.save(funcionario);

            return funcionario;
        }
    }

    public Funcionario buscarPorId(Long id){
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else {
            return funcionario.get();
        }
    }

    public List<Funcionario> buscarPorNome(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNome(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNome(nome.toUpperCase());
        }
    }

    public List<Funcionario> buscarPorCpf(String cpf) {
        if (cpf == null){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByCpf(cpf).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByCpf(cpf);
        }
    }

    public List<Funcionario> buscarFuncionarioComecandoCom(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNomeStartingWith(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeStartingWith(nome.toUpperCase());
        }
    }

    public List<Funcionario> buscarFuncionarioTerminandoCom(String nome) {
        if(nome.isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if(repository.findByNomeEndingWith(nome.toUpperCase()).isEmpty()){
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeEndingWith(nome.toUpperCase());
        }
    }


    public List<Funcionario> buscarFuncionarioQueContenha(String nome) {
        if (nome.isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO);

        } else if (repository.findByNomeContaining(nome.toUpperCase()).isEmpty()) {
            throw new NaoLocalizadoException(NAO_LOCALIZADO2);

        } else {
            return repository.findByNomeContaining(nome.toUpperCase());
        }
    }

    public List<Funcionario> listar(){
        if(repository.findAll().isEmpty()){
            throw new NaoLocalizadoException(NAO_CADASTRADO);

        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Funcionario editar(Long id, FuncionarioDTO funcionarioNovo){
        if(id == 0){
            throw new NaoLocalizadoException(NAO_LOCALIZADO);
        }

        Funcionario funcionarioBanco = this.buscarPorId(id);

        funcionarioBanco.setNome(funcionarioNovo.nome());
        funcionarioBanco.setTelefone(funcionarioNovo.telefone());
        funcionarioBanco.setAtivo(funcionarioNovo.ativo());

        return repository.save(funcionarioBanco);
    }

    @Transactional
    public void delete(Long id){
        Funcionario funcionario = this.buscarPorId(id);

        repository.delete(funcionario);
    }
}
