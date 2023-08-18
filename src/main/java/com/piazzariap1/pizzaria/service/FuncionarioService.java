package com.piazzariap1.pizzaria.service;


import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Funcionario;
import com.piazzariap1.pizzaria.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    public Funcionario cadastrar(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setAtivo(funcionarioDTO.isAtivo());

        if(repository.verificaCPF(funcionario.getCpf()).isEmpty()){
            return repository.save(funcionario);
        } else{
            throw new RuntimeException("funcionario informado já esta cadastrado!");
        }
    }

    public FuncionarioDTO buscarPorId(Long id) {

        if (id == 0) {
            throw new RuntimeException("por favor, informe um valor valido!");
        } else if (repository.findById(id).isEmpty()) {
            throw new RuntimeException("não foi possivel localizar o funcionario informado!");
        } else {

            Funcionario funcionario = repository.findById(id).orElse(null);
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

            funcionarioDTO.setId(funcionario.getId());
            funcionarioDTO.setNome(funcionario.getNome());
            funcionarioDTO.setCpf(funcionario.getCpf());
            funcionarioDTO.setTelefone(funcionario.getTelefone());
            funcionarioDTO.setAtivo(funcionario.isAtivo());
            funcionarioDTO.setCadastro(funcionario.getCadastro());
            funcionarioDTO.setEdicao(funcionario.getEdicao());

            return funcionarioDTO;
        }
    }

    public List<FuncionarioDTO> listar(){
        List<Funcionario> funcionarios = repository.findAll();
        if(funcionarios.isEmpty()){
            throw new RuntimeException("não foi possivel localizar nenhum funcionario cadastrado!");
        }

        return funcionarios.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }


    public FuncionarioDTO converterParaDTO(Funcionario funcionario){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

        funcionarioDTO.setId(funcionario.getId());
        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setCpf(funcionario.getCpf());
        funcionarioDTO.setTelefone(funcionario.getTelefone());
        funcionarioDTO.setAtivo(funcionario.isAtivo());
        funcionarioDTO.setCadastro(funcionario.getCadastro());
        funcionarioDTO.setEdicao(funcionario.getEdicao());

        return funcionarioDTO;
    }

    @Transactional
    public FuncionarioDTO editar(Long id, FuncionarioDTO funcionarioNovo){
        Funcionario funcionarioBanco = repository.findById(id).orElse(null);

        if(funcionarioNovo.getId() == 0 || !funcionarioNovo.getId().equals(funcionarioBanco.getId())){
            throw new RuntimeException("Não foi possível localizar o funcionario informado!");
        }

        funcionarioBanco.setNome(funcionarioNovo.getNome());
        funcionarioBanco.setCpf(funcionarioNovo.getCpf());
        funcionarioBanco.setTelefone(funcionarioNovo.getTelefone());
        funcionarioBanco.setAtivo(funcionarioNovo.isAtivo());

        repository.save(funcionarioBanco);

        return converterParaDTO(funcionarioBanco);
    }

    @Transactional
    public String deletar(Long id){
        repository.deleteById(id);
        return ("Funcionario deletado com sucesso!");
    }
}
