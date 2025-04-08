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
            .where(nomeLike(params.get("nome")));
    }

    private Specification<Pessoa> nomeLike(String nome) {
        return (root, query, cb) -> {
            if (isBlank(nome))
                return cb.conjunction();

            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }
    
}
