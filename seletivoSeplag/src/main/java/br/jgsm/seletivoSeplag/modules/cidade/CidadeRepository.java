package br.jgsm.seletivoSeplag.modules.cidade;

import org.springframework.stereotype.Repository;

import br.jgsm.seletivoSeplag.modules.crud.CrudRepository;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Integer> {

}
