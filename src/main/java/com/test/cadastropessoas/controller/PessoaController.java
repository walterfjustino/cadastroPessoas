package com.test.cadastropessoas.controller;

import com.test.cadastropessoas.dto.PessoaDTO;
import com.test.cadastropessoas.model.Response;
import com.test.cadastropessoas.service.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PessoaController.class).listarPessoas()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    //CONSULTAR PESSOA PELO ID
    @GetMapping("/{id}")
    public ResponseEntity<Response<PessoaDTO>> consultaPessoa(@PathVariable Long id){
        Response<PessoaDTO> response = new Response<>();
        PessoaDTO pessoa = this.pessoaService.consultar(id);
        response.setData(pessoa);
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //CADASTRAR PESSOAS
    @PostMapping
    public ResponseEntity<Response<Boolean>> cadastrarPessoa(@Valid @RequestBody PessoaDTO pessoa){
        Response<Boolean> response = new Response<>();
        response.setData(this.pessoaService.cadastrar(pessoa));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //ATUALIZAR PESSOAS
    @PutMapping("/{id}")
    public ResponseEntity<Response<Boolean>> atualizarPessoa(@Valid @RequestBody PessoaDTO pessoa){
        Response<Boolean> response = new Response<>();
        response.setData(this.pessoaService.atualizar(pessoa));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //EXCLUIR PESSOAS
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> excluirPessoa(@PathVariable Long id){
        Response<Boolean> response = new Response<>();
        response.setData(this.pessoaService.excluir(id));
        response.setStatusCode(HttpStatus.OK.value());
        return  ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
