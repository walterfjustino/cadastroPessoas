package com.test.cadastropessoas.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


import javax.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnderecoDTO extends RepresentationModel<EnderecoDTO> {

    private Long id;

    @NotBlank(message = "Informar tipo do endereço.")
    private String tipoEndereco;

    @NotBlank(message = "Informar Logradouro.")
    private String logradouro;

    @NotBlank(message = "Informar o Nome do Endereço.")
    @Size(min = 3 , max = 200 , message = "Preenchimento Mínimo de 3 Máximo de 200 caracteres")
    private String nomeRua;

    @NotNull(message = "Informar o número do endereço.")
    private Integer numResidencia;

    @NotBlank(message = "Preencher o complemento.")
    @Size(min = 3, max = 20, message = "Preenchimento mínimo de 3 máximo 20 caracteres.")
    private String complemento;

    @Size(min = 8, max = 8, message = "CEP requer preechimento de 8 dígitos.")
    private String cep;

    @NotBlank(message = "Informar o Bairro")
    @Size(min = 3, max = 50, message = "Preenchimento minimo 3 máximo 50 caracteres.")
    private String bairro;

    @NotBlank(message = "Informar a cidade.")
    @Size(min = 3, max = 50, message = "Preenchimento minimo 3 máximo 50 caracteres.")
    private String cidade;

    @NotBlank(message = "Informar o estado.")
    @Size(min = 2, max = 2, message = "Preencher conforme exemplo (SP, RJ, PR...)")
    private String estado;

    @NotBlank(message = "Informar o País.")
    @Size(min = 3, max = 50, message = "Preenchimento minimo 3 máximo 50 caracteres.")
    private String pais;
}
