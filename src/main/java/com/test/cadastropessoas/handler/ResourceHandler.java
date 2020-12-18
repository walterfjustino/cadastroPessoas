package com.test.cadastropessoas.handler;

import com.test.cadastropessoas.exception.DependenteException;
import com.test.cadastropessoas.exception.EnderecoException;
import com.test.cadastropessoas.exception.PessoaException;
import com.test.cadastropessoas.exception.TelefoneException;
import com.test.cadastropessoas.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResourceHandler {


        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Response<Map<String, String>>> handlerMethodArgumentNotValidException (MethodArgumentNotValidException m){

            Map<String, String> erros = new HashMap<>();
            m.getBindingResult().getAllErrors().forEach(erro -> {
                String campo = ((FieldError) erro).getField();
                String mensagem = erro.getDefaultMessage();
                erros.put(campo, mensagem);
            });

            Response<Map<String, String>> response = new Response<>();
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setData(erros);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

        }
        @ExceptionHandler(PessoaException.class)
        public ResponseEntity<Response<String>> handlerPessoaException(PessoaException m){
            Response<String> response = new Response<>();
            response.setStatusCode(m.getHttpStatus().value());
            response.setData(m.getMessage());
            return ResponseEntity.status(m.getHttpStatus().value()).body(response);
        }
        @ExceptionHandler(EnderecoException.class)
        public ResponseEntity<Response<String>> handlerEnderecoException(EnderecoException m){
            Response<String> response = new Response<>();
            response.setStatusCode(m.getHttpStatus().value());
            response.setData(m.getMessage());
            return  ResponseEntity.status(m.getHttpStatus().value()).body(response);
        }

        @ExceptionHandler(TelefoneException.class)
        public ResponseEntity<Response<String>> handlerTelefoneException(TelefoneException m){
            Response<String> response = new Response<>();
            response.setStatusCode(m.getHttpStatus().value());
            response.setData(m.getMessage());
            return ResponseEntity.status(m.getHttpStatus().value()).body(response);
        }

        public ResponseEntity<Response<String>> handlerDependenteException(DependenteException m){
            Response<String> response = new Response<>();
            response.setStatusCode(m.getHttpStatus().value());
            response.setData(m.getMessage());
            return ResponseEntity.status(m.getHttpStatus().value()).body(response);
        }
    }

