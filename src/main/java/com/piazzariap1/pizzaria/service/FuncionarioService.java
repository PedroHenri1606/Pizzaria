package com.piazzariap1.pizzaria.service;


import com.piazzariap1.pizzaria.dto.FuncionarioDTO;
import com.piazzariap1.pizzaria.entity.Funcionario;
import com.piazzariap1.pizzaria.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario cadastrar(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setAtivo(funcionarioDTO.isAtivo());

        return repository.save(funcionario);
    }

    public FuncionarioDTO buscarPorId(Long id){
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

    public List<FuncionarioDTO> listar(){
        List<Funcionario> funcionarios = repository.findAll();

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

    public String deletar(Long id){
        repository.deleteById(id);
        return ("Funcionario deletado com sucesso!");
    }
}
