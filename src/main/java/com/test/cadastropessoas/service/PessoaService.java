package com.test.cadastropessoas.service;

import com.test.cadastropessoas.constant.Mensagens;
import com.test.cadastropessoas.dto.PessoaDTO;
import com.test.cadastropessoas.entity.PessoaEntity;
import com.test.cadastropessoas.exception.PessoaException;
import com.test.cadastropessoas.repository.IPessoaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements IPessoaService {

    private final IPessoaRepository pessoaRepository;
    private final ModelMapper mapper;

    @Autowired
    public PessoaService(IPessoaRepository pessoaRepository) {
        this.mapper = new ModelMapper();
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<PessoaDTO> listar() {
        try {
            return this.mapper.map(this.pessoaRepository.findAll(),new TypeToken<List<PessoaDTO>>(){}.getType());
        }catch (Exception m){
            throw new PessoaException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<PessoaEntity> findByNomeTel(String telefone) {
        return null;
    }

    @Override
    public PessoaDTO consultar(Long id) {

        return null;
    }

    @Override
    public Boolean cadastrar(PessoaDTO pessoa) {
        try{
            if(pessoa.getId()!= null){
                throw new PessoaException(Mensagens.ERRO_ID_INFORMADO.getValor(), HttpStatus.BAD_REQUEST);
            }
            if(this.pessoaRepository.findByNome(pessoa.getNome())!= null){
                throw new PessoaException(Mensagens.ERRO_PESSOA_CADASTRADA.getValor(), HttpStatus.BAD_REQUEST);
            }
            return this.cadastrarOuAtualizar(pessoa) ;
                return Boolean.TRUE;
        }catch (Exception m){
            throw m;

        }catch (PessoaException e){
            throw new PessoaException(Mensagens.ERRO_GENERICO.getValor(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

            }

    @Override
    public Boolean atualizar(PessoaDTO pessoa) {
        return null;
    }

    @Override
    public Boolean excluir(Long id) {
        return null;
    }

    private Boolean cadastrarOuAtualizar(PessoaDTO pessoa) {
        PessoaEntity pessoaEntity = this.mapper.map(pessoa, PessoaEntity.class);
        this.pessoaRepository.save(pessoaEntity);
        return Boolean.TRUE;
    }
}
