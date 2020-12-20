package com.test.cadastropessoas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tb_Pessoa")
@Data
@NoArgsConstructor
public class PessoaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "nome")
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "apelido")
    private String apelido;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "cpf")
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "profissao")
    private String profissao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "salario")
    private BigDecimal salario;

    @JsonFormat(pattern="dd/MM/yyyy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "dependente_id")
    private List<DependenteEntity> dependente;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id")
    private List<TelefoneEntity> telefone;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private List<EnderecoEntity> enderecos;


}
