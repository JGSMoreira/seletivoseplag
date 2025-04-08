package br.jgsm.seletivoSeplag.modules.crud;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

public interface CrudMapper<E extends CrudEntity, D> {

    @Mapping(target = "id", ignore = true)
    E toEntity(D dto);

    D toDto(E entity);

    @InheritConfiguration(name = "toEntity")
    E updateFromDto(D dto, @MappingTarget E entity);
    
}
