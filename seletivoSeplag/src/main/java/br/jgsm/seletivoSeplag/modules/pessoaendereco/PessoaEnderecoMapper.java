package br.jgsm.seletivoSeplag.modules.pessoaendereco;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import br.jgsm.seletivoSeplag.modules.crud.CrudMappings;
import br.jgsm.seletivoSeplag.modules.endereco.Endereco;
import br.jgsm.seletivoSeplag.modules.endereco.EnderecoRepository;
import br.jgsm.seletivoSeplag.modules.endereco.dtos.EnderecoDTO;
import br.jgsm.seletivoSeplag.modules.pessoa.Pessoa;
import br.jgsm.seletivoSeplag.modules.pessoa.PessoaRepository;

@Mapper(componentModel = "spring")
public abstract class PessoaEnderecoMapper {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @CrudMappings
    @Mapping(target = "pessoa", ignore = true)
    @Mapping(target = "endereco", ignore = true)
    public abstract PessoaEndereco toEntity(EnderecoDTO dto);

    Pessoa mapPessoa(Integer id){
        if (id == null) return null;

        return pessoaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
    }

    Endereco mapEndereco(Integer id){
        if (id == null) return null;

        return enderecoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Endereco não encontrado"));
    }
    

}
