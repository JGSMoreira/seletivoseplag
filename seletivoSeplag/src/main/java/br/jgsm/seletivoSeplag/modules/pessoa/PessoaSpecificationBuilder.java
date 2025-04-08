package br.jgsm.seletivoSeplag.modules.pessoa;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;

@Component
public class PessoaSpecificationBuilder implements SpecificationBuilder<Pessoa> {

    @Override
    public Specification<Pessoa> buildFromParams(Map<String, String> params) {
        return Specification
            .where(nomeContem(params.get("nome")));
    }

    private Specification<Pessoa> nomeContem(String nome) {
        return nome == null ? null :
            (root, query, cb) -> cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }
    
}
