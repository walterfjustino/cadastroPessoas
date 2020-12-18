package com.test.cadastropessoas.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.cadastropessoas.constant.Logradouro;
import com.test.cadastropessoas.constant.TipoEndereco;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_Endereco")
@Data
@NoArgsConstructor
public class EnderecoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "tipo_endereco")
    private TipoEndereco tipoEndereco;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "logradouro")
    private Logradouro logradouro;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "nome_rua")
    private String nomeRua;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "numero_residencia")
    private Integer numResidencia;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "complemento")
    private String complemento;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "cep")
    private String cep;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "bairro")
    private String bairro;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "cidade")
    private String cidade;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "estado")
    private String estado;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "país")
    private String pais;


}
