package br.jgsm.seletivoSeplag.modules.servidortemporario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.pessoa.PessoaMapper;
import br.jgsm.seletivoSeplag.modules.servidortemporario.dtos.ServidorTemporarioDTO;

@Mapper(componentModel = "spring", uses = { PessoaMapper.class })
public abstract class ServidorTemporarioMapper implements CrudMapper<ServidorTemporario, ServidorTemporarioDTO> {

    @CrudMappings
    @Mapping(target = "pessoa", source = ".")
    public abstract ServidorTemporario toEntity(ServidorTemporarioDTO dto);

}
