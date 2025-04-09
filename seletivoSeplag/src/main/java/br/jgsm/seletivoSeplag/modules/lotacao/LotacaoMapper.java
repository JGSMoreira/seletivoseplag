package br.jgsm.seletivoSeplag.modules.lotacao;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.lotacao.dtos.LotacaoDTO;
import br.jgsm.seletivoSeplag.modules.pessoa.Pessoa;
import br.jgsm.seletivoSeplag.modules.pessoa.PessoaRepository;
import br.jgsm.seletivoSeplag.modules.unidade.Unidade;
import br.jgsm.seletivoSeplag.modules.unidade.UnidadeRepository;

@Mapper(componentModel = "spring")
public abstract class LotacaoMapper implements CrudMapper<Lotacao, LotacaoDTO> {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    UnidadeRepository unidadeRepository;

    @CrudMappings
    @Mapping(target = "pessoa", ignore = true)
    public abstract Lotacao toEntity(LotacaoDTO dto);

    Pessoa mapPessoa(Integer id) {
        if (id == null) {
            return null;
        }

        return pessoaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
    }

    Unidade mapUnidade(Integer id) {
        if (id == null) {
            return null;
        }

        return unidadeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Unidade não encontrada"));
    }

    Integer map(Pessoa pessoa) {
        return pessoa != null ? pessoa.getId() : null;
    }

    Integer map(Unidade unidade) {
        return unidade != null ? unidade.getId() : null;
    }

}
