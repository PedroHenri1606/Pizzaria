package com.piazzariap1.pizzaria.entity;


import com.piazzariap1.pizzaria.entity.abstractEntity.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Endereco extends AbstractEntity {

    @Getter @Setter
    @Column(name = "cep_endereco")
    @NotNull(message = "CEP do endereço é um campo obrigatorio!")
    @NotBlank(message = "CEP do endereço informado não pode ser vazio!")
    private String cep;

    @Getter @Setter
    @NotNull(message = "Bairro do endereço informado é um campo obrigatorio!")
    @NotBlank(message = "Bairro do endereço informado não pode ser vazio!")
    @Column(name = "bairro_endereco")
    private String bairro;

    @Getter @Setter
    @NotNull(message = "Logadouro do endereço informado é um campo obrigatorio!")
    @NotBlank(message = "Logadouro do endereço informado não pode ser vazio!")
    @Column(name = "logadouro_endereco")
    private String logadouro;

    @Getter @Setter
    @NotNull(message = "Numero do endereço é um campo obrigatorio!")
    @NotBlank(message = "Numero do endereço informado não pode ser vazio!")
    @Column(name = "numero_endereco")
    private String numero;

    @ManyToOne
    @Getter @Setter
    @NotNull(message = "Cliente do endereço é um campo obrigatorio!")
    @NotBlank(message = "Cliente do endereço não pode ser vazio!")
    @JoinColumn(name = "id_cliente_endereco")
    private Cliente idCliente;
}
