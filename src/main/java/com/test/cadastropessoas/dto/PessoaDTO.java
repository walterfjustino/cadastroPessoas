package com.test.cadastropessoas.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PessoaDTO extends RepresentationModel<PessoaDTO> {

    private Long id;

    @NotBlank(message = "Infome o Nome Completo")
    @Size(min = 3, max = 200)
    private String nome;

    @Size(min = 2, max = 50)
    private String apelido;

    @NotBlank(message = "Infome o CPF.")
    @Size(max = 11)
    private String cpf;

    @NotBlank(message = "Infome a Profissão.")
    @Size(min = 4, max = 50)
    private String profissao;

    @NotBlank(message = "Informe o Salário.")
    private BigDecimal salario;

    @NotBlank(message = "Infome a Data de Nascimento.")
    private Date dataNascimento;
}
