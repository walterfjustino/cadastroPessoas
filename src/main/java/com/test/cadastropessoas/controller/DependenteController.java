package com.test.cadastropessoas.controller;


import com.test.cadastropessoas.dto.DependenteDTO;
import com.test.cadastropessoas.model.Response;
import com.test.cadastropessoas.service.IDependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dependente")
public class DependenteController {

    @Autowired
    IDependenteService dependenteService;

    //LISTAR TODOS OS DEPENDENTES
    @GetMapping
    public ResponseEntity<Response<List<DependenteDTO>>> listarDependentes(){
        Response<List<DependenteDTO>> response = new Response<>();
        response.setData(this.dependenteService.listar());
        response.setStatusCode(HttpStatus.OK.value());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DependenteController.class).listarDependentes()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //CONSULTAR UM DEPENDENTE PELO ID
    @GetMapping("/{id}")
    public ResponseEntity<Response<DependenteDTO>> consultarDependente(@PathVariable Long id){
        Response<DependenteDTO> response = new Response<>();
        DependenteDTO dependente = this.dependenteService.consultar(id);
        response.setData(dependente);
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //CADASTRAR UM DEPENDENTE
    @PostMapping
    public ResponseEntity<Response<Boolean>> cadastrarDependente(@Valid @RequestBody DependenteDTO dependente){
        Response<Boolean> response = new Response<>();
        response.setData(this.dependenteService.cadastrar(dependente));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //ATUALIZA UM DEPENDENTE
    @PutMapping
    public ResponseEntity<Response<Boolean>> atualizarDependente(@Valid @RequestBody DependenteDTO dependente){
        Response<Boolean> response = new Response<>();
        response.setData(this.dependenteService.atualizar(dependente));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //EXCLUI UM DEPENDENTE
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> excluirDependente(@PathVariable Long id){
        Response<Boolean> response = new Response<>();
        response.setData(this.dependenteService.excluir(id));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
