package com.test.cadastropessoas.constant;

import lombok.Getter;

@Getter
public enum Logradouro {

    RUA("Rua: "),
    VIELA("Viela: "),
    AVENIDA("Avenida: "),
    ALAMEDA("Alameda: "),
    ESTRADA("Estrada: ");

    private final String valor;

    Logradouro(String valor) {
        this.valor = valor;
    }
}
