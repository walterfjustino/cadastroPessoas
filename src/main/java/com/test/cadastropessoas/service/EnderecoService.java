package com.test.cadastropessoas.service;

import com.test.cadastropessoas.constant.Mensagens;
import com.test.cadastropessoas.dto.EnderecoDTO;
import com.test.cadastropessoas.entity.EnderecoEntity;
import com.test.cadastropessoas.exception.EnderecoException;
import com.test.cadastropessoas.repository.IEnderecoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService implements IEnderecoService {

    private final IEnderecoRepository enderecoRepository;
    private final ModelMapper mapper;


    @Autowired
    public EnderecoService(IEnderecoRepository enderecoRepository) {
        this.mapper = new ModelMapper();
        this.enderecoRepository = enderecoRepository;
    }


    //LISTAR ENDEREÇOS
    @Override
    public List<EnderecoDTO> listar() {
        try{
            return this.mapper.map(this.enderecoRepository.findAll(), new TypeToken<List<EnderecoDTO>>(){}.getType());
        }catch (EnderecoException m){
            throw m;
        }catch (Exception e){
            throw new EnderecoException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //CONSULTAR ENDEREÇO
    @Override
    public EnderecoDTO consultar(Long id) {
        try{
            Optional<EnderecoEntity> enderecoOptional = this.enderecoRepository.findById(id);
            if(enderecoOptional.isPresent()){
                return this.mapper.map(enderecoOptional.get(),EnderecoDTO.class);
            }
                throw new EnderecoException(Mensagens.ERRO_ENDERECO_NAO_ENCONTRADO.getValor(),HttpStatus.BAD_REQUEST);
        }catch (EnderecoException m){
            throw m;

        }catch (Exception e){
            throw new EnderecoException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CADASTRAR ENDEREÇO
    @Override
    public Boolean cadastrar(EnderecoDTO endereco) {
        try {
            if(endereco.getId()!=null){
                throw new EnderecoException(Mensagens.ERRO_ID_INFORMADO.getValor(), HttpStatus.BAD_REQUEST);
            }
            if(this.enderecoRepository.findByEndereco(endereco.getNomeRua()) != null){
                throw new EnderecoException(Mensagens.ERRO_ENDERECO_CADASTRADO.getValor(),HttpStatus.BAD_REQUEST);
            }
            return this.cadastrarOuAtualizar(endereco);
        }catch (EnderecoException m){
            throw m;
        }catch (Exception m){
            throw new EnderecoException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //ATUALIZAR ENDEREÇO
    @Override
    public Boolean atualizar(EnderecoDTO endereco) {
        try {
            this.consultar(endereco.getId());
            return this.cadastrarOuAtualizar(endereco);
        } catch (EnderecoException m) {
            throw m;
        } catch (Exception e) {
            throw new EnderecoException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //EXCLUIR ENDEREÇO
    @Override
    public Boolean excluir(Long id) {
        try {
            this.consultar(id);
            this.enderecoRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (EnderecoException m) {
                throw m;
        }catch (Exception e){
            throw new EnderecoException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private Boolean cadastrarOuAtualizar(EnderecoDTO endereco){
        EnderecoEntity enderecoEnt = this.mapper.map(endereco,EnderecoEntity.class);
        this.enderecoRepository.save(enderecoEnt);
        return Boolean.TRUE;
    }
}
