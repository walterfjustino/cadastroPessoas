package com.test.cadastropessoas.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PessoaDTO extends RepresentationModel<PessoaDTO> {

    private Long id;

    @NotBlank(message = "Infome o Nome Completo")
    @Size(min = 2, max = 200, message = "Preenchimento Minimo de 2 Máximo de 200 caracteres.")
    private String nome;

    @Size(min = 2, max = 50)
    private String apelido;

    @NotBlank(message = "Infome o CPF.")
    @Size(min = 11, max = 11, message = "CPF preenchimento obrigatório de 11 dígitos.")
    private String cpf;

    @NotBlank(message = "Infome a Profissão.")
    @Size(min = 2, max = 70, message = "Preenchimento Mínimo de 2 caracteres Máximo de 70 caracteres ")
    private String profissao;

    @NotBlank(message = "Informe o Salário.")
    private BigDecimal salario;

    @NotBlank(message = "Infome a Data de Nascimento.")
    @Size(min =8 , max = 8 , message ="Preencher somente números - DD/MM/AAAA." )
    private Date dataNascimento;
}
