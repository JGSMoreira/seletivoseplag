package br.jgsm.seletivoSeplag.modules.pessoa;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    Pessoa toEntity(PessoaDTO pessoaDTO);

}
