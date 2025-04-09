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
import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;
import br.jgsm.seletivoSeplag.modules.pessoaendereco.PessoaEndereco;
import br.jgsm.seletivoSeplag.modules.pessoaendereco.PessoaEnderecoMapper;

@Mapper(componentModel = "spring", uses = { LotacaoMapper.class, PessoaEnderecoMapper.class })
public abstract class PessoaMapper implements CrudMapper<Pessoa, PessoaDTO> {

    @Autowired
    EnderecoMapper enderecoMapper;

    @CrudMappings
    @Mapping(target = "fotos", ignore = true)
    @Mapping(target = "pessoaEnderecos", source = "enderecos")
    public abstract Pessoa toEntity(PessoaDTO pessoaDTO);

    List<PessoaEndereco> mapEnderecosToPessoaEnderecos(List<EnderecoDTO> dtos) {
        if (dtos == null) return null;
        return dtos.stream().map(dto -> {
            PessoaEndereco pe = new PessoaEndereco();
            pe.setEndereco(enderecoMapper.toEntity(dto));
            return pe;
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    @AfterMapping
    void afterMapping(@MappingTarget Pessoa pessoa) {
        if (pessoa.getLotacoes() != null) {
            for (Lotacao lotacao : pessoa.getLotacoes()) {
                lotacao.setPessoa(pessoa);
            }
        }

        if (pessoa.getPessoaEnderecos() != null) {
            for (var endereco : pessoa.getPessoaEnderecos()) {
                endereco.setPessoa(pessoa);
            }
        }
    }

}
