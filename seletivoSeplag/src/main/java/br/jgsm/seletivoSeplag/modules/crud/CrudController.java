package br.jgsm.seletivoSeplag.modules.crud;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

public abstract class CrudController<T extends CrudEntity, R extends CrudRepository<T, Integer>, S extends Specification<T>, D, M extends CrudMapper<T, D>> {

    @Autowired
    protected R repository;

    @Autowired
    protected M mapper;

    private Class<T> entityClass;

    protected SpecificationBuilder<T> specBuilder;

    @SuppressWarnings("unchecked")
    public CrudController() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @GetMapping
    public Page<T> listar(@RequestParam Map<String, String> params, Pageable pageable) {
        Specification<T> spec = specBuilder.buildFromParams(params);
        return repository.findAll(spec, pageable);
    }
    
}
