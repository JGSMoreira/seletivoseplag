package br.jgsm.seletivoSeplag.modules.endereco;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.endereco.dtos.EnderecoDTO;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends CrudController<Endereco, EnderecoRepository, Specification<Endereco>, EnderecoDTO, EnderecoMapper> {

    public EnderecoController(EnderecoRepository repository, EnderecoMapper mapper, SpecificationBuilder<Endereco> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }

}
