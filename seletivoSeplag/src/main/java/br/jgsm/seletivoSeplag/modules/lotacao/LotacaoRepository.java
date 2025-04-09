package br.jgsm.seletivoSeplag.modules.lotacao;

import org.springframework.stereotype.Repository;

import br.jgsm.seletivoSeplag.modules.crud.CrudRepository;

@Repository
public interface LotacaoRepository extends CrudRepository<Lotacao, Integer> {

}
