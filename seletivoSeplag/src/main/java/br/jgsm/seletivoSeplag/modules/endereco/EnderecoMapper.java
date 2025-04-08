package br.jgsm.seletivoSeplag.modules.endereco;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.endereco.dtos.EnderecoDTO;

@Mapper(componentModel = "spring")
public interface EnderecoMapper extends CrudMapper<Endereco, EnderecoDTO> {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    @CrudMappings
    Endereco toEntity(EnderecoDTO pessoaDTO);

}
