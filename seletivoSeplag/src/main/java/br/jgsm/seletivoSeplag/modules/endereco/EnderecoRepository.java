package br.jgsm.seletivoSeplag.modules.endereco;

import org.springframework.stereotype.Repository;

import br.jgsm.seletivoSeplag.modules.crud.CrudRepository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

}
