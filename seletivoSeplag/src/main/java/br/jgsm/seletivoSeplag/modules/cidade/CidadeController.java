package br.jgsm.seletivoSeplag.modules.cidade;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.cidade.dtos.CidadeDTO;
import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;

@RestController
@RequestMapping("/cidade")
public class CidadeController extends CrudController<Cidade, CidadeRepository, Specification<Cidade>, CidadeDTO, CidadeMapper> {

    public CidadeController(CidadeRepository repository, CidadeMapper mapper, SpecificationBuilder<Cidade> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }

}
