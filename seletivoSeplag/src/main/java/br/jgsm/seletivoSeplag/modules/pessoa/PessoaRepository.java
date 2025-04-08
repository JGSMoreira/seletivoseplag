package br.jgsm.seletivoSeplag.modules.pessoa;

import org.springframework.stereotype.Repository;

import br.jgsm.seletivoSeplag.modules.crud.CrudRepository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {


}
