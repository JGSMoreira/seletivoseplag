package br.jgsm.seletivoSeplag.modules.unidade;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.unidade.dtos.UnidadeDTO;

@RestController
@RequestMapping("/unidade")
public class UnidadeController extends CrudController<Unidade, UnidadeRepository, Specification<Unidade>, UnidadeDTO, UnidadeMapper> {

    public UnidadeController(UnidadeRepository repository, UnidadeMapper mapper, SpecificationBuilder<Unidade> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }

}
