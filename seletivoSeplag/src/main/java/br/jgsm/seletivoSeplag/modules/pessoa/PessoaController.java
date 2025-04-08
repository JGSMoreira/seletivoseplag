package br.jgsm.seletivoSeplag.modules.pessoa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;

@RestController
@RequestMapping("/pessoa")
public class PessoaController extends CrudController<Pessoa, PessoaRepository, Specification<Pessoa>, PessoaDTO, PessoaMapper> {

    public PessoaController(PessoaRepository repository, PessoaMapper mapper, SpecificationBuilder<Pessoa> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }

}
