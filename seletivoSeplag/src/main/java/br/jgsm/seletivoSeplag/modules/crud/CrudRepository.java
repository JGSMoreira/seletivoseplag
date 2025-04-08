package br.jgsm.seletivoSeplag.modules.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CrudRepository<T extends CrudEntity, Id> extends JpaRepository<T, Integer>{
    
    Page<T> findAll(Specification<T> spec, Pageable pageable);
}
