package br.jgsm.seletivoSeplag.modules.crud;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MappingTarget;

public interface CrudMapper<E extends CrudEntity, D> {

    @CrudMappings
    E toEntity(D dto);

    D toDto(E entity);

    @InheritConfiguration(name = "toEntity")
    void update(@MappingTarget E entity, D dto);

    Object toListarDTO(E item);
    
}
