package br.jgsm.seletivoSeplag.modules.servidorefetivo;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.lotacao.Lotacao;
import br.jgsm.seletivoSeplag.modules.pessoa.Pessoa;
import jakarta.persistence.criteria.Join;

@Component
public class ServidorEfetivoSpecificationBuilder implements SpecificationBuilder<ServidorEfetivo> {

    @Override
    public Specification<ServidorEfetivo> buildFromParams(Map<String, String> params) {
        return Specification
            .where(nomeLike(params.get("nome"))
            .and(unidadeIdEqual(params.get("unidade"))));
    }

    private Specification<ServidorEfetivo> nomeLike(String nome) {
        return (root, query, cb) -> {
            if (isBlank(nome))
                return cb.conjunction();

            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    private Specification<ServidorEfetivo> unidadeIdEqual(String unidadeId) {
        return (root, query, cb) -> {
            if (isBlank(unidadeId))
                return cb.conjunction();
            if (!isNumeric(unidadeId))
                throw new IllegalArgumentException("Id da Unidade deve ser um número");

            Integer id = Integer.valueOf(unidadeId);

            Join<ServidorEfetivo, Pessoa> pessoa = root.join("pessoa");
            Join<Pessoa, Lotacao> lotacao = pessoa.join("lotacoes");

            return cb.equal(lotacao.get("unidade").get("id"), id);
        };
    }
    
}
