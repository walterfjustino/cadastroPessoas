package com.test.cadastropessoas.controller;

import com.test.cadastropessoas.dto.PessoaDTO;
import com.test.cadastropessoas.model.Response;
import com.test.cadastropessoas.service.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private IPessoaService pessoaService;


    //LISTAR TODAS AS PESSOAS
    @GetMapping
    public ResponseEntity<Response<List<PessoaDTO>>> listarPessoas(){
        Response<List<PessoaDTO>> response = new Response<>();
        response.setData(this.pessoaService.listar());
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    //CADASTRAR PESSOAS
    public ResponseEntity<Response<Boolean>> cadastrarPessoas(@Valid @RequestBody PessoaDTO pessoa){
        Response<Boolean> response = new Response<>();
        response.setData(this.pessoaService.cadastrar(pessoa));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
