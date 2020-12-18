package com.test.cadastropessoas.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.cadastropessoas.constant.TipoDependente;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tb_Dependente")
@Data
@NoArgsConstructor
public class DependenteEntity implements Serializable { private static final long serialVersionUID = 1L;

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
    @Column(name = "Tipo_Dependente")
    private TipoDependente tipoDependente;


}
