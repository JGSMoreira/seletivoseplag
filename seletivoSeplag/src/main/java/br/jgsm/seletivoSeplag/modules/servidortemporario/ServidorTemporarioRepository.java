package br.jgsm.seletivoSeplag.modules.servidortemporario;

import org.springframework.stereotype.Repository;

import br.jgsm.seletivoSeplag.modules.crud.CrudRepository;

@Repository
public interface ServidorTemporarioRepository extends CrudRepository<ServidorTemporario, Integer> {

}
