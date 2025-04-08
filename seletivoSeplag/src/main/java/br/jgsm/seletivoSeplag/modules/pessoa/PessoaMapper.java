package br.jgsm.seletivoSeplag.modules.pessoa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;

@Mapper(componentModel = "spring")
public interface PessoaMapper extends CrudMapper<Pessoa, PessoaDTO> {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pessoaEnderecos", ignore = true)
    @Mapping(target = "fotos", ignore = true)
    Pessoa toEntity(PessoaDTO pessoaDTO);

}
