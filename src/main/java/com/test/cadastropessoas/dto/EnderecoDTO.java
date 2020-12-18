package com.test.cadastropessoas.dto;

import com.test.cadastropessoas.constant.Logradouro;
import com.test.cadastropessoas.constant.TipoEndereco;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EnderecoDTO extends RepresentationModel<EnderecoDTO> {

    private Long id;

    private TipoEndereco tipoEndereco;

    private Logradouro logradouro;

    private String nomeRua;

    private Integer numResidencia;

    private String complemento;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;
}
