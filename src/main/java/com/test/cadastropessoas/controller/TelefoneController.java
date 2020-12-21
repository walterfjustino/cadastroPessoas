package com.test.cadastropessoas.controller;


import com.test.cadastropessoas.dto.EnderecoDTO;
import com.test.cadastropessoas.dto.TelefoneDTO;
import com.test.cadastropessoas.model.Response;
import com.test.cadastropessoas.service.ITelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    private ITelefoneService telefoneService;

    //LISTAR TODOS OS TELEFONES
    @GetMapping
    public ResponseEntity<Response<List<TelefoneDTO>>> listarTelefones() {
        Response<List<TelefoneDTO>> response = new Response<>();
        response.setData(this.telefoneService.listar());
        response.setStatusCode(HttpStatus.OK.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TelefoneController.class).listarTelefones()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //CONSULTAR UM TELEFONE PELO ID
    @GetMapping("/{id}")
    public ResponseEntity<Response<TelefoneDTO>> consultarTelefone(@PathVariable Long id) {
        Response<TelefoneDTO> response = new Response<>();
        TelefoneDTO telefone = this.telefoneService.consultar(id);
        response.setData(telefone);
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //CADASTRAR UM TELEFONE
    @PostMapping
    public ResponseEntity<Response<Boolean>> cadastrarTelefone(@Valid @RequestBody TelefoneDTO telefone) {
        Response<Boolean> response = new Response<>();
        response.setData(this.telefoneService.cadastrar(telefone));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //ATUALIZA UM TELEFONE
    @PutMapping
    public ResponseEntity<Response<Boolean>> atualizarTelefone(@Valid @RequestBody TelefoneDTO telefone) {
        Response<Boolean> response = new Response<>();
        response.setData(this.telefoneService.atualizar(telefone));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //EXCLUI UM TELEFONE
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> excluirTelefone(@PathVariable Long id) {
        Response<Boolean> response = new Response<>();
        response.setData(this.telefoneService.excluir(id));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}

