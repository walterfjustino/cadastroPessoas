package com.test.cadastropessoas.dto;

import com.test.cadastropessoas.constant.TipoDependente;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class DepedenteDTO extends RepresentationModel<DepedenteDTO> {


    private Long id;

    @NotBlank(message = "Informe o Nome do Dependente.")
    @Size(min = 2 , max = 200, message = "Preenchimento Mínimo 2 Máximo 200 caracteres. ")
    private String nome;

    @NotBlank(message = "Informe o Tipo do Dependente")
    private TipoDependente tipoDependente;


}
