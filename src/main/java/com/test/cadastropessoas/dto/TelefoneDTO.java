package com.test.cadastropessoas.dto;

import com.test.cadastropessoas.constant.TipoTelefone;
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
    @Size(min = 1, max = 3)
    private String codPais;

    @NotBlank(message = "Informe o DDD.")
    @Size(min = 3, max = 3)
    private String ddd;

    @NotBlank(message = "Informe o número.")
    @Size(min = 8 , max = 10)
    private String numero;

    @NotBlank(message = "Informe o tipo. ")
    private TipoTelefone tipoTelefone;
}
