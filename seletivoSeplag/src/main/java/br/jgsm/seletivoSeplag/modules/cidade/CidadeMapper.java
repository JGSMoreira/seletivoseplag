package br.jgsm.seletivoSeplag.modules.cidade;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.jgsm.seletivoSeplag.modules.cidade.dtos.CidadeDTO;
import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;

@Mapper(componentModel = "spring")
public interface CidadeMapper extends CrudMapper<Cidade, CidadeDTO> {

    @CrudMappings
    Cidade toEntity(CidadeDTO pessoaDTO);

}
