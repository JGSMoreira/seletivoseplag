package br.jgsm.seletivoSeplag.modules.lotacao;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.lotacao.dtos.LotacaoDTO;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController extends CrudController<Lotacao, LotacaoRepository, Specification<Lotacao>, LotacaoDTO, LotacaoMapper> {

    public LotacaoController(LotacaoRepository repository, LotacaoMapper mapper, SpecificationBuilder<Lotacao> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }

}
