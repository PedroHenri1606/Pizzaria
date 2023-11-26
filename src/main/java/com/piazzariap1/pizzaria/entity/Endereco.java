package com.piazzariap1.pizzaria.entity;


import com.piazzariap1.pizzaria.validation.constraints.CEP;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ENDERECO")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cep")
    @CEP(message = "{campo.endereco-cep-CEP}")
    private String cep;

    @Column(name = "bairro")
    @NotNull(message = "{campo.endereco-bairro-NotNull}")
    @NotBlank(message = "{campo.endereco-bairro-NotBlank}")
    private String bairro;

    @Column(name = "logadouro")
    @NotNull(message = "{campo.endereco-logadouro-NotNull}")
    @NotBlank(message = "{campo.endereco-logadouro-NotBlank}")
    private String logadouro;

    @Column(name = "numero")
    @Min(value = 1,message = "{campo.endereço-numero-Min}")
    private Integer numero;
}
