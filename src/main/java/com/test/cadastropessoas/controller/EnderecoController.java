package com.test.cadastropessoas.controller;



import com.test.cadastropessoas.dto.EnderecoDTO;
import com.test.cadastropessoas.model.Response;
import com.test.cadastropessoas.service.IEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    IEnderecoService enderecoService;

    //LISTAR TODOS OS ENDEREÇOS
    @GetMapping
    public ResponseEntity <Response<List<EnderecoDTO>>> listarEnderecos(){
        Response<List<EnderecoDTO>> response = new Response<>();
        response.setData(this.enderecoService.listar());
        response.setStatusCode(HttpStatus.OK.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnderecoController.class).listarEnderecos()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //CONSULTAR UM ENDEREÇO PELO ID
    @GetMapping("/{id}")
    public ResponseEntity<Response<EnderecoDTO>> consultarEndereco(@PathVariable Long id){
        Response<EnderecoDTO> response = new Response<>();
        EnderecoDTO endereco = this.enderecoService.consultar(id);
        response.setData(endereco);
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //CADASTRAR UM ENDERECO
    @PostMapping
    public ResponseEntity<Response<Boolean>> cadastrarEndereco(@Valid @RequestBody EnderecoDTO endereco){
        Response<Boolean> response = new Response<>();
        response.setData(this.enderecoService.cadastrar(endereco));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //ATUALIZA UM ENDEREÇO
    @PutMapping("/{id}")
    public ResponseEntity<Response<Boolean>> atualizarEndereco(@Valid @RequestBody EnderecoDTO endereco){
        Response<Boolean> response = new Response<>();
        response.setData(this.enderecoService.atualizar(endereco));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //EXCLUI UM ENDEREÇO
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> excluirEndereco(@PathVariable Long id){
        Response<Boolean> response = new Response<>();
        response.setData(this.enderecoService.excluir(id));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
