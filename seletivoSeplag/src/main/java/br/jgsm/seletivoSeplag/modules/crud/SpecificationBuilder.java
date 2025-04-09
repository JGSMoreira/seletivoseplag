package br.jgsm.seletivoSeplag.modules.crud;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    
    Specification<T> buildFromParams(Map<String, String> params);
  
    default boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    default boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
}
