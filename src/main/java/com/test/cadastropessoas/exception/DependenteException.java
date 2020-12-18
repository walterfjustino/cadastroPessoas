package com.test.cadastropessoas.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DependenteException extends RuntimeException{ private static final long serialVersionUID = 1L;

        private final HttpStatus httpStatus;

    public DependenteException(final String mensagem, final HttpStatus httpStatus) {
        super(mensagem);
        this.httpStatus = httpStatus;
    }
}
