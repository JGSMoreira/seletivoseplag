package br.jgsm.seletivoSeplag.modules.unidadeendereco;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.endereco.Endereco;
import br.jgsm.seletivoSeplag.modules.endereco.EnderecoRepository;
import br.jgsm.seletivoSeplag.modules.endereco.dtos.EnderecoDTO;
import br.jgsm.seletivoSeplag.modules.unidade.Unidade;
import br.jgsm.seletivoSeplag.modules.unidade.UnidadeRepository;

@Mapper(componentModel = "spring")
public abstract class UnidadeEnderecoMapper {

    @Autowired
    UnidadeRepository unidadeRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @CrudMappings
    @Mapping(target = "unidade", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    public abstract UnidadeEndereco toEntity(EnderecoDTO dto);

    Unidade mapUnidade(Integer id){
        if (id == null) return null;

        return unidadeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Unidade não encontrada"));
    }

    Endereco mapEndereco(Integer id){
        if (id == null) return null;

        return enderecoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Endereco não encontrado"));
    }
    

}
