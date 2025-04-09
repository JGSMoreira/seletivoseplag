package br.jgsm.seletivoSeplag.modules.endereco;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;

@Component
public class EnderecoSpecificationBuilder implements SpecificationBuilder<Endereco> {

    @Override
    public Specification<Endereco> buildFromParams(Map<String, String> params) {
        return Specification
            .where(nomeLike(params.get("nome"))
            .and(ufEqual(params.get("uf"))));
    }

    private Specification<Endereco> nomeLike(String nome) {
        return (root, query, cb) -> {
            if (isBlank(nome))
                return cb.conjunction();

            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    private Specification<Endereco> ufEqual(String uf) {
        return (root, query, cb) -> {
            if (isBlank(uf)) 
                return cb.conjunction();
           return  cb.equal(cb.upper(root.get("uf")),  uf.toUpperCase());
        };
    }
    
}
