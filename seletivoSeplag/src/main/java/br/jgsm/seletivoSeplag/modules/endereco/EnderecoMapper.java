package br.jgsm.seletivoSeplag.modules.endereco;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import br.jgsm.seletivoSeplag.modules.cidade.Cidade;
import br.jgsm.seletivoSeplag.modules.cidade.CidadeMapper;
import br.jgsm.seletivoSeplag.modules.cidade.CidadeRepository;
import br.jgsm.seletivoSeplag.modules.crud.CrudMapper;
import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.endereco.dtos.EnderecoDTO;

@Mapper(componentModel = "spring", uses = { CidadeMapper.class})
public abstract class EnderecoMapper implements CrudMapper<Endereco, EnderecoDTO> {

    @Autowired
    CidadeRepository cidadeRepository;

    @CrudMappings
    public abstract Endereco toEntity(EnderecoDTO pessoaDTO);

    Cidade mapCidade(Integer id) {
        if (id == null) 
            return null;

        return cidadeRepository.findById(id).orElse(null);
    }

    Integer map(Cidade cidade) {
        return cidade != null ? cidade.getId() : null;
    }

}
