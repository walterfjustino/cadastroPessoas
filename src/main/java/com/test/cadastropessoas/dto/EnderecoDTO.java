package com.test.cadastropessoas.dto;

import com.test.cadastropessoas.constant.Logradouro;
import com.test.cadastropessoas.constant.TipoEndereco;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnderecoDTO extends RepresentationModel<EnderecoDTO> {

    private Long id;

    @NotBlank(message = "Informar tipo do endereço.")
    private TipoEndereco tipoEndereco;

    @NotBlank(message = "Informar Logradouro.")
    private Logradouro logradouro;

    @NotBlank(message = "Informar o Nome do Endereço.")
    @Size(min = 3 , max = 200 , message = "Preenchimento Mínimo de 3 Máximo de 200 caracteres")
    private String nomeRua;

    @NotBlank(message = "Informar o número do endereço.")
    @Max(value = 15, message = "Preenchimento máximo de 15 digítos.")
    private Integer numResidencia;

    @NotBlank(message = "Preencher o complemento.")
    @Size(min = 3, max = 20, message = "Preenchimento mínimo de 3 máximo 20 caracteres.")
    private String complemento;

    @Size(min = 8, max = 8, message = "CEP requer preechimento de 8 dígitos.")
    private String cep;

    @NotBlank(message = "Informar o Bairro")

    private String bairro;

    @NotBlank(message = "Informar a cidade.")
    private String cidade;

    @NotBlank(message = "Informar o estado.")
    @Size(min = 2, max = 2, message = "Preencher conforme exemplo (SP, RJ, PR...)")
    private String estado;

    @NotBlank(message = "Informar o País.")
    @Size(min = 3, max = 50, message = "Preenchimento minimo 3 máximo 50 caracteres.")
    private String pais;
}
