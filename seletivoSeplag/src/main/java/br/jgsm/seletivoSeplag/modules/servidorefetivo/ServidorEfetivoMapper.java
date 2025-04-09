package br.jgsm.seletivoSeplag.modules.servidorefetivo;

import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.pessoa.PessoaMapper;
import br.jgsm.seletivoSeplag.modules.servidorefetivo.dtos.ListarDTO;
import br.jgsm.seletivoSeplag.modules.servidorefetivo.dtos.ServidorEfetivoDTO;

@Mapper(componentModel = "spring", uses = { PessoaMapper.class })
public interface ServidorEfetivoMapper extends CrudMapper<ServidorEfetivo, ServidorEfetivoDTO> {

    ServidorEfetivoMapper INSTANCE = Mappers.getMapper(ServidorEfetivoMapper.class);

    @CrudMappings
    @Mapping(target = "pessoa", source = ".")
    ServidorEfetivo toEntity(ServidorEfetivoDTO dto);

    public default ListarDTO toListarDTO(ServidorEfetivo entity){
        ListarDTO dto = new ListarDTO();

        dto.setNome(entity.getPessoa().getNome());
        if (entity.getPessoa().getDataNascimento() != null) 
            dto.setIdade(entity.getPessoa().getIdade());
        
        dto.setUnidadeLotacao(entity.getPessoa().getLotacoes().stream().map(l -> l.getUnidade().getNome()).collect(Collectors.joining(", ")));
        return dto;
    }
}
