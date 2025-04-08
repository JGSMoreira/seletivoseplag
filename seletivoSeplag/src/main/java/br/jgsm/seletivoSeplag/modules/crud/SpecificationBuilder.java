package br.jgsm.seletivoSeplag.modules.crud;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    
    Specification<T> buildFromParams(Map<String, String> params);
}
