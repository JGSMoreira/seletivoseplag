package br.jgsm.seletivoSeplag.modules.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.endereco.EnderecoMapper;
import br.jgsm.seletivoSeplag.modules.endereco.dtos.EnderecoDTO;
import br.jgsm.seletivoSeplag.modules.lotacao.Lotacao;
import br.jgsm.seletivoSeplag.modules.lotacao.LotacaoMapper;
import br.jgsm.seletivoSeplag.modules.lotacao.dtos.LotacaoDTO;
import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;
import br.jgsm.seletivoSeplag.modules.pessoaendereco.PessoaEndereco;
import br.jgsm.seletivoSeplag.modules.pessoaendereco.PessoaEnderecoMapper;

@Mapper(componentModel = "spring", uses = { LotacaoMapper.class, PessoaEnderecoMapper.class })
public abstract class PessoaMapper implements CrudMapper<Pessoa, PessoaDTO> {

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private LotacaoMapper lotacaoMapper;

    @CrudMappings
    @Mapping(target = "fotos", ignore = true)
    @Mapping(target = "idade", ignore = true)
    @Mapping(target = "pessoaEnderecos", ignore = true)
    @Mapping(target = "lotacoes", ignore = true)
    public abstract Pessoa toEntity(PessoaDTO pessoaDTO);

    List<PessoaEndereco> mapEnderecosToPessoaEnderecos(List<EnderecoDTO> dtos, Pessoa pessoa) {
        if (dtos == null)
            return new ArrayList<>();

        return dtos.stream().map(dto -> {
            PessoaEndereco pe = new PessoaEndereco();
            pe.setEndereco(enderecoMapper.toEntity(dto));
            pe.setPessoa(pessoa);
            return pe;
        }).collect(Collectors.toList());
    }

    List<Lotacao> mapLotacoes(List<LotacaoDTO> dtos, Pessoa pessoa) {
        if (dtos == null)
            return new ArrayList<>();

        return dtos.stream().map(dto -> {
            Lotacao lotacao = lotacaoMapper.toEntity(dto);
            lotacao.setPessoa(pessoa);
            return lotacao;
        }).collect(Collectors.toList());
    }

    @AfterMapping
    void afterMapping(@MappingTarget Pessoa pessoa, PessoaDTO dto) {
        pessoa.setPessoaEnderecos(new ArrayList<>());
        if (dto.getEnderecos() != null) {
            pessoa.getPessoaEnderecos().addAll(mapEnderecosToPessoaEnderecos(dto.getEnderecos(), pessoa));
        }
    
        pessoa.setLotacoes(new ArrayList<>());
        if (dto.getLotacoes() != null) {
            pessoa.getLotacoes().addAll(mapLotacoes(dto.getLotacoes(), pessoa));
        }
    }
    

}
