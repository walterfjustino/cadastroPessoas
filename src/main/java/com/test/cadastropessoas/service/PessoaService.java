package com.test.cadastropessoas.service;

import com.test.cadastropessoas.constant.Mensagens;
import com.test.cadastropessoas.dto.PessoaDTO;
import com.test.cadastropessoas.entity.EnderecoEntity;
import com.test.cadastropessoas.entity.PessoaEntity;
import com.test.cadastropessoas.exception.PessoaException;
import com.test.cadastropessoas.repository.IEnderecoRepository;
import com.test.cadastropessoas.repository.IPessoaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements IPessoaService {

    private final IEnderecoRepository enderecoRepository;
    private final IPessoaRepository pessoaRepository;
    private final ModelMapper mapper;

    @Autowired
    public PessoaService(IEnderecoRepository enderecoRepository, IPessoaRepository pessoaRepository) {
        this.mapper = new ModelMapper();
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<PessoaDTO> listar() {
        try {
            return this.mapper.map(this.pessoaRepository.findAll(), new TypeToken<List<PessoaDTO>>() {
            }.getType());
        } catch (PessoaException m) {
            throw m;
        } catch (Exception m) {
            throw new PessoaException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public PessoaDTO consultar(Long id) {
        try {
            Optional<PessoaEntity> pessoaOptional = this.pessoaRepository.findById(id);
            if (pessoaOptional.isPresent()) {
                return this.mapper.map(pessoaOptional.get(), PessoaDTO.class);
            }
            throw new PessoaException(Mensagens.ERRO_PESSOA_NAO_ENCONTRADA.getValor(), HttpStatus.NOT_FOUND);
        } catch (PessoaException m) {
            throw m;
        } catch (Exception e) {
            throw new PessoaException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public Boolean cadastrar(PessoaDTO pessoa) {
        try {
            if (pessoa.getId() != null) {
                throw new PessoaException(Mensagens.ERRO_ID_INFORMADO.getValor(), HttpStatus.BAD_REQUEST);
            }
            if (this.pessoaRepository.findByNome(pessoa.getNome()) != null) {
                throw new PessoaException(Mensagens.ERRO_PESSOA_CADASTRADA.getValor(), HttpStatus.BAD_REQUEST);
            }
            return this.cadastrarOuAtualizar(pessoa);

        } catch (PessoaException m) {
            throw m;

        } catch (Exception e) {
            throw new PessoaException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public Boolean atualizar(PessoaDTO pessoa) {
        try {
            this.consultar(pessoa.getId());
            return this.cadastrarOuAtualizar(pessoa);
        } catch (PessoaException m) {
            throw m;
        } catch (Exception e) {
            throw new PessoaException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public Boolean excluir(Long id) {
        try {
            this.consultar(id);
            this.pessoaRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (PessoaException m) {
            throw m;
        } catch (Exception e) {
            throw new PessoaException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    private Boolean cadastrarOuAtualizar(PessoaDTO pessoa) {
        List<EnderecoEntity> listEnderecoEntity = new ArrayList<>();
        if (!pessoa.getEnderecos().isEmpty()) {
            pessoa.getEnderecos().forEach(endereco -> {
                if (this.enderecoRepository.findById(endereco).isPresent()) {
                    listEnderecoEntity.add(this.enderecoRepository.findById(endereco).get());
                }
            });

        }
        PessoaEntity pessoaEntity = new PessoaEntity();
        if (pessoa.getId() != null) {
            pessoaEntity.setId(pessoa.getId());
            pessoaEntity.setNome(pessoa.getNome());
            pessoaEntity.setApelido(pessoa.getApelido());
            pessoaEntity.setCpf(pessoa.getCpf());
            pessoaEntity.setProfissao(pessoa.getProfissao());
            pessoaEntity.setSalario(pessoa.getSalario());
            pessoaEntity.setDataNascimento(pessoa.getDataNascimento());
            pessoaEntity.setEnderecos(listEnderecoEntity);
            PessoaEntity pessoaEnt = this.mapper.map(pessoa, PessoaEntity.class);
            this.pessoaRepository.save(pessoaEnt);
            return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }
}
/*
   private Boolean cadastrarOuAtualizar(PessoaDTO pessoa) {
            PessoaEntity pessoaEnt = this.mapper.map(pessoa, PessoaEntity.class);
            this.pessoaRepository.save(pessoaEnt);
            return Boolean.TRUE;
        }}*/