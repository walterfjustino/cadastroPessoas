package com.test.cadastropessoas.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_telefone")
@Data
@NoArgsConstructor
public class TelefoneEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "codigo_pais")
    private String codPais;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "DDD")
    private String ddd;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "numero")
    private String numero;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "tipo_telefone")
    private String tipoTelefone;


}
