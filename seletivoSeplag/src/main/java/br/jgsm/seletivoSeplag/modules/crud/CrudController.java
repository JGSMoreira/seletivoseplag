package br.jgsm.seletivoSeplag.modules.crud;

import java.beans.Transient;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

public abstract class CrudController<T extends CrudEntity, R extends CrudRepository<T, Integer>, S extends Specification<T>, D, M extends CrudMapper<T, D>> {

    protected R repository;

    protected M mapper;

    private Class<T> entityClass;

    protected SpecificationBuilder<T> specBuilder;

    @SuppressWarnings("unchecked")
    public CrudController() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @GetMapping
    public Page<Object> listar(@RequestParam Map<String, String> params, Pageable pageable)
            throws ClassNotFoundException {
        Specification<T> spec = specBuilder.buildFromParams(params);
        Page<T> page = repository.findAll(spec, pageable);
        List<Object> entitiesDTO;
        try {
            Method toListarDTOMethod = mapper.getClass().getMethod("toListarDTO", Object.class);

            entitiesDTO = page.getContent().stream()
                    .map(item -> {
                        try {
                            return toListarDTOMethod.invoke(mapper, item);
                        } catch (Exception e) {
                            return item;
                        }
                    })
                    .toList();

        } catch (NoSuchMethodException e) {
            entitiesDTO = new ArrayList<>(page.getContent());
        }
        return new PageImpl<>(entitiesDTO, pageable, page.getTotalElements());
    }

    @PostMapping
    @Transient
    public ResponseEntity<T> criar(@RequestBody @Valid D dto) {
        T entity = mapper.toEntity(dto);
        return ResponseEntity.ok(repository.save(entity));
    }

    @PutMapping("/{id}")
    @Transient
    public ResponseEntity<T> atualizar(@PathVariable Integer id, @RequestBody @Valid D dto) {
        T entity = repository.findById(id).orElse(null);

        if (entity == null)
            return ResponseEntity.notFound().build();

        mapper.update(entity, dto);
        return ResponseEntity.ok(repository.save(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable Integer id) {
        T entity = repository.findById(id).orElse(null);

        if (entity == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")
    @Transient
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        T entity = repository.findById(id).orElse(null);

        if (entity == null)
            return ResponseEntity.notFound().build();

        repository.delete(entity);
        return ResponseEntity.noContent().build();
    }

}
