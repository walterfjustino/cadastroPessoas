package com.test.cadastropessoas.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TelefoneDTO extends RepresentationModel<TelefoneDTO> {

    private Long id;

    @NotBlank(message = "Informe o código do País.")
    @Size(min = 2 , max = 4, message = "Mínimo permitido caractere (+) mais 1, Máximo permitido caractere (+) mais 3 dígitos.")
    private String codPais;

    @NotBlank(message = "Informe o DDD ou DDI().")
    @Size(min = 1, max = 4, message = "Tamanho mínimo permitido (1) dígito, Tamanho máximo permitdo (4) dígitos.")
    private String ddd;

    @NotBlank(message = "Informe o número.")
    @Size(min = 8 , max = 10, message = "Tamanho de Mínimo 8 máximo 10 dígitos.")
    private String numero;

    @NotBlank(message = "Informe o tipo. ")
    private String tipoTelefone;
}
