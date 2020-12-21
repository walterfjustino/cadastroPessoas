package com.test.cadastropessoas.service;

import com.test.cadastropessoas.constant.Mensagens;
import com.test.cadastropessoas.dto.DependenteDTO;
import com.test.cadastropessoas.entity.DependenteEntity;
import com.test.cadastropessoas.exception.DependenteException;
import com.test.cadastropessoas.repository.IDependenteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class DependenteService implements IDependenteService {

    private final IDependenteRepository dependenteRepository;
    private final ModelMapper mapper;

    @Autowired
    public DependenteService(IDependenteRepository dependenteRepository) {
        this.mapper = new ModelMapper();
        this.dependenteRepository = dependenteRepository;
    }

    //LISTAR TODOS DEPENDENTES
    @Override
    public List<DependenteDTO> listar() {
        try {
            return this.mapper.map(this.dependenteRepository.findAll(), new TypeToken<List<DependenteDTO>>() {
            }.getType());
        } catch (DependenteException m) {
            throw m;
        } catch (Exception m) {
            throw new DependenteException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CONSULTAR DEPENDENTE POR ID
    @Override
    public DependenteDTO consultar(Long id) {
        try {
            Optional<DependenteEntity> dependenteOptional = this.dependenteRepository.findById(id);
            if (dependenteOptional.isPresent()) {
                return this.mapper.map(dependenteOptional.get(), DependenteDTO.class);
            }
            throw new DependenteException(Mensagens.ERRO_DEPENDENTE_NAO_ENCONTRADO.getValor(), HttpStatus.NOT_FOUND);
        } catch (DependenteException m) {
            throw m;
        } catch (Exception e) {
            throw new DependenteException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    //CADASTRAR DEPENDENTE
    @Override
    public Boolean cadastrar(DependenteDTO dependente) {
        try {
            if (dependente.getId() != null) {
                throw new DependenteException(Mensagens.ERRO_ID_INFORMADO.getValor(), HttpStatus.BAD_REQUEST);
            }
            if (this.dependenteRepository.findByNomeDependente(dependente.getNome()) != null) {
                throw new DependenteException(Mensagens.ERRO_DEPENDENTE_CADASTRADO.getValor(), HttpStatus.BAD_REQUEST);
            }
            return this.cadastrarOuAtualizar(dependente);

        } catch (DependenteException m) {
            throw m;

        } catch (Exception e) {
            throw new DependenteException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //ATUALIZAR DEPENDENTE
    @Override
    public Boolean atualizar(DependenteDTO dependente) {
        try {
            this.consultar(dependente.getId());
            return this.cadastrarOuAtualizar(dependente);
        } catch (DependenteException m) {
            throw m;
        } catch (Exception e) {
            throw new DependenteException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    //EXCLUIR DEPENDENTE
    @Override
    public Boolean excluir(Long id) {
        try {
            this.consultar(id);
            this.dependenteRepository.deleteById(id);
            return Boolean.TRUE;
        }catch (DependenteException m){
            throw m;
        }catch (Exception e){
            throw new DependenteException(Mensagens.ERRO_GENERICO.getValor(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private Boolean cadastrarOuAtualizar(DependenteDTO dependente){
        DependenteEntity dependenteEnt = this.mapper.map(dependente,DependenteEntity.class);
        this.dependenteRepository.save(dependenteEnt);
        return Boolean.TRUE;
    }
}
