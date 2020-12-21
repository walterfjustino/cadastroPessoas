package com.test.cadastropessoas.service;

import com.test.cadastropessoas.constant.Mensagens;
import com.test.cadastropessoas.dto.TelefoneDTO;
import com.test.cadastropessoas.entity.TelefoneEntity;
import com.test.cadastropessoas.exception.PessoaException;
import com.test.cadastropessoas.exception.TelefoneException;
import com.test.cadastropessoas.repository.ITelefoneRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService implements ITelefoneService {

    private final ITelefoneRepository telefoneRepository;
    private final ModelMapper mapper;

    @Autowired
    public TelefoneService(ITelefoneRepository telefoneRepository) {
        this.mapper = new ModelMapper();
        this.telefoneRepository = telefoneRepository;


    }

    //LISTAR TODOS TELEFONES
    @Override
    public List<TelefoneDTO> listar() {
        try {
            return this.mapper.map(this.telefoneRepository.findAll(), new TypeToken<List<TelefoneDTO>>() {
            }.getType());
        }catch (TelefoneException m){
            throw m;
        }catch (Exception m){
            throw new TelefoneException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CONSULTAR TELEFONE POR ID.
    @Override
    public TelefoneDTO consultar(Long id) {
        try {
            Optional<TelefoneEntity> telefoneOptional = this.telefoneRepository.findById(id);
            if(telefoneOptional.isPresent()){
                return this.mapper.map(telefoneOptional.get(),TelefoneDTO.class);
            }
            throw new TelefoneException(Mensagens.ERRO_TELEFONE_NAO_ENCONTRADO.getValor(), HttpStatus.NOT_FOUND);
        }catch (TelefoneException m){
            throw m;
        }catch (Exception e){
            throw new TelefoneException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    //CADASTRAR TELEFONE
    @Override
    public Boolean cadastrar(TelefoneDTO telefone) {
        try{
            if(telefone.getId()!= null){
                throw new PessoaException(Mensagens.ERRO_ID_INFORMADO.getValor(), HttpStatus.BAD_REQUEST);
            }
            if(this.telefoneRepository.findByNumero(telefone.getNumero())!= null){
                throw new PessoaException(Mensagens.ERRO_TELEFONE_CADASTRADO.getValor(), HttpStatus.BAD_REQUEST);
            }
            return this.cadastrarOuAtualizar(telefone) ;

        }catch (TelefoneException m){
            throw m;

        }catch (Exception e){
            throw new TelefoneException(Mensagens.ERRO_GENERICO.getValor(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //ATUALIZAR TELEFONE
    @Override
    public Boolean atualizar(TelefoneDTO telefone) {
        try{
            this.consultar(telefone.getId());
            return this.cadastrarOuAtualizar(telefone);
        }catch (TelefoneException m){
            throw m;
        }catch (Exception e){
            throw new TelefoneException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    //EXCLUIR TELEFONE
    @Override
    public Boolean excluir(Long id) {
        try {
            this.consultar(id);
            this.telefoneRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (TelefoneException m) {
            throw m;
        }catch (Exception e){
            throw new TelefoneException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private Boolean cadastrarOuAtualizar(TelefoneDTO telefone){
        TelefoneEntity telefoneEnt = this.mapper.map(telefone,TelefoneEntity.class);
        this.telefoneRepository.save(telefoneEnt);
        return Boolean.TRUE;
    }
}