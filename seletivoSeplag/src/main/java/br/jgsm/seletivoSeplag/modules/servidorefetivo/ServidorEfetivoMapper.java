package br.jgsm.seletivoSeplag.modules.servidorefetivo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.pessoa.PessoaMapper;
import br.jgsm.seletivoSeplag.modules.servidorefetivo.dtos.ServidorEfetivoDTO;

@Mapper(componentModel = "spring", uses = { PessoaMapper.class })
public interface ServidorEfetivoMapper extends CrudMapper<ServidorEfetivo, ServidorEfetivoDTO> {

    ServidorEfetivoMapper INSTANCE = Mappers.getMapper(ServidorEfetivoMapper.class);

    @CrudMappings
    @Mapping(target = "pessoa", source = ".")
    ServidorEfetivo toEntity(ServidorEfetivoDTO dto);

}
