package br.jgsm.seletivoSeplag.modules.servidorefetivo;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.servidorefetivo.dtos.ServidorEfetivoDTO;

@RestController
@RequestMapping("/servidor-efetivo")
public class ServidorEfetivoController extends CrudController<ServidorEfetivo, ServidorEfetivoRepository, Specification<ServidorEfetivo>, ServidorEfetivoDTO, ServidorEfetivoMapper> {

    public ServidorEfetivoController(ServidorEfetivoRepository repository, ServidorEfetivoMapper mapper, SpecificationBuilder<ServidorEfetivo> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }

}
