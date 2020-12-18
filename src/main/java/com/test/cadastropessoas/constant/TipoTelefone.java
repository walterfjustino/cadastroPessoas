package com.test.cadastropessoas.constant;

import lombok.Getter;

@Getter
public enum TipoTelefone {

    CELULAR("Celular: "),
    RESIDENCIAL("Residencial: "),
    COMERCIAL("Comercial: "),
    OUTROS("Outros: ");

    private final String valor;

    TipoTelefone(String valor) {
        this.valor = valor;
    }
}
