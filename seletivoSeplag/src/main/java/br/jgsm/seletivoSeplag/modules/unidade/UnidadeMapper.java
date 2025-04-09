package br.jgsm.seletivoSeplag.modules.unidade;

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
import br.jgsm.seletivoSeplag.modules.unidade.dtos.UnidadeDTO;
import br.jgsm.seletivoSeplag.modules.unidadeendereco.UnidadeEndereco;
import br.jgsm.seletivoSeplag.modules.unidadeendereco.UnidadeEnderecoMapper;

@Mapper(componentModel = "spring", uses = { UnidadeEnderecoMapper.class })
public abstract class UnidadeMapper implements CrudMapper<Unidade, UnidadeDTO> {

    @Autowired
    EnderecoMapper enderecoMapper;

    @CrudMappings
    @Mapping(target = "unidadeEnderecos", ignore = true)
    public abstract Unidade toEntity(UnidadeDTO dto);

   List<UnidadeEndereco> mapEnderecosToUnidadeEnderecos(List<EnderecoDTO> dtos, Unidade unidade) {
        if (dtos == null) return new ArrayList<>();
        return dtos.stream().map(dto -> {
            UnidadeEndereco ue = new UnidadeEndereco();
            ue.setEndereco(enderecoMapper.toEntity(dto));
            ue.setUnidade(unidade);
            return ue;
        }).collect(Collectors.toList());
    }

    @AfterMapping
    void afterMapping(@MappingTarget Unidade unidade, UnidadeDTO dto) {
        if (dto.getEnderecos() != null) {
            unidade.getUnidadeEnderecos().clear();
            unidade.getUnidadeEnderecos().addAll(mapEnderecosToUnidadeEnderecos(dto.getEnderecos(), unidade));
        }
    }

}
