package com.piazzariap1.pizzaria.service;

import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Funcionario;
import com.piazzariap1.pizzaria.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    public Funcionario cadastrar(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();

        BeanUtils.copyProperties(funcionarioDTO,funcionario);

        return repository.save(funcionario);
    }

    public Funcionario buscarPorId(Long id){
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isEmpty()){
            throw new RuntimeException("não foi possivel localizar o funcionario informado!");
        } else {
            return funcionario.get();
        }
    }

    public List<Funcionario> listar(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum funcionario cadastrado!");
        } else {
            return repository.findAll();
        }
    }

    @Transactional
    public Funcionario editar(Long id, FuncionarioDTO funcionarioNovo){
        Funcionario funcionarioBanco = this.buscarPorId(id);

        if(id == 0 || !funcionarioNovo.getId().equals(funcionarioBanco.getId())){
            throw new RuntimeException("não foi possivel localizar o funcionario informado!");
        }

        funcionarioBanco.setNome(funcionarioNovo.getNome());
        funcionarioBanco.setTelefone(funcionarioNovo.getTelefone());
        funcionarioBanco.setCpf(funcionarioNovo.getCpf());

        return repository.save(funcionarioBanco);
    }

    @Transactional
    public void delete(Long id){
        Funcionario funcionario = this.buscarPorId(id);

        repository.delete(funcionario);
    }
}
