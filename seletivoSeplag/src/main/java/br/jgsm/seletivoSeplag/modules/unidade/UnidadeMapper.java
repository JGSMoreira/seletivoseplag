package br.jgsm.seletivoSeplag.modules.unidade;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.unidade.dtos.UnidadeDTO;

@Mapper(componentModel = "spring")
public abstract class UnidadeMapper implements CrudMapper<Unidade, UnidadeDTO> {


    @CrudMappings
    public abstract Unidade toEntity(UnidadeDTO dto);

}
