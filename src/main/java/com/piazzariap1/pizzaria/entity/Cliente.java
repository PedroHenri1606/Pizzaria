package com.piazzariap1.pizzaria.entity;

import com.piazzariap1.pizzaria.validation.constraints.CPF;
import com.piazzariap1.pizzaria.validation.constraints.Telefone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_cliente")
@Getter @Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "nome")
    @NotNull(message = "{campo.cliente/funcionario-nome-NotNull}")
    @NotBlank(message = "{campo.cliente/funcionario-nome-NotBlank}")
    private String nome;

    @Column(name = "cpf")
    @CPF(message = "{campo.cliente/funcionario-cpf-CPF}")
    private String cpf;

    @Column(name = "telefone")
    @Telefone(message = "{campo.cliente/funcionario-telefone-Tell}")
    private String telefone;

    @OneToMany
    @JoinColumn(name = "cliente")
    private Set<Endereco> enderecos;

    @OneToOne
    @JoinColumn(name = "usuario")
    private UserEntity user;
}
